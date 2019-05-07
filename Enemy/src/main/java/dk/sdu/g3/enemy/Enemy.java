/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.enemy;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.services.IEnemy;
import dk.sdu.g3.common.services.IMap;
import dk.sdu.g3.common.services.IPathfinding;
import dk.sdu.g3.common.services.IPlaceableEntity;
import dk.sdu.g3.common.services.IUnit;
import dk.sdu.g3.common.services.IUnitFactory;
import java.util.Random;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;
import dk.sdu.g3.common.serviceLoader.ServiceLoader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author robertfrancisti
 */
@ServiceProviders(value = {
    @ServiceProvider(service = IEnemy.class)
})
public class Enemy implements IEnemy {

    int currentWave = 0;
    int gold = 0;
    Random random = new Random();
    int bigUnits;
    int smallUnits;
    int counter;
    IMap realMap;
    List<IMap> mapList;
    List<IPathfinding> pathlist;
    List<IUnit> Unitlist;
    List<IPlaceableEntity> EntityList;
    List<IPlaceableEntity> EntitiesOnMap= new ArrayList<>();
    List<IUnitFactory> UnitFactoryList;
    List<Coordinate> TestList;
    int unitNumber;

    //valid tileSize = 2 * map.tilesize
    public Enemy() {
        UnitFactoryList = (List<IUnitFactory>) new ServiceLoader(IUnitFactory.class).getServiceProviderList();
        mapList = (List<IMap>) new ServiceLoader(IMap.class).getServiceProviderList();
        pathlist = (List<IPathfinding>) new ServiceLoader(IPathfinding.class).getServiceProviderList();

    }

    // put this method in IController, since both player/enemy uses it
    @Override
    public void putEntityOnMap(IPlaceableEntity unit, IMap map1) {
        System.out.println("you have entered the method :)");

        try {
            System.out.println("this is the try thingy");

            for (IMap map : mapList) {
                Coordinate startPosition = new Coordinate(map.getTileSize(), random.nextInt((map.getLengthY() / (2 * map.getTileSize())))* 2 * map.getTileSize() + map.getTileSize());
                Coordinate endPosition = new Coordinate(map.getLengthX() - map.getTileSize(), map.getLengthY()/2 + map.getTileSize());
                System.out.println("start X = " + startPosition.getX() + "start Y = " + startPosition.getY() + " end x = " + endPosition.getX() + " end y = " + endPosition.getY());
                unit.setPosition(startPosition);
                

                for (IPathfinding IPath : pathlist) {
                    List<Coordinate> path = IPath.generatePath(map, startPosition, endPosition);
                    ((IUnit) unit).setPath(path);
//                    addPathToUnit(IPath.generatePath(map, startPosition, endPosition), (IUnit) unit);
                }

                map.addEntity(unit);
                System.out.println("adding entity");
                EntitiesOnMap.add(unit);
                System.out.println("sucess");
            }

        } catch (Exception e) {
            e.getMessage();
            System.out.println("the pathfinding is broken, please help it");
        }

    }

//    public void addPathToUnit(List<Coordinate> path, IUnit unit) {
//        System.out.println("check");
//        unit.setPath(path);
//        System.out.println("");
//    }

    @Override
    public int getCurrentWave() {
        return currentWave;

    }

    @Override
    public void createWave() {
        counter = 0;
        // ad code here 2 deside how many units is created based on how for in the game it is
        unitNumber = random.nextInt(11);
        create(unitNumber);
    }

    private void create(int unitNumber1) {
        EntityList = new ArrayList<>();
        for (IUnitFactory unitfactory : UnitFactoryList) {
            for (int i = unitNumber1; i > 0; i--) {
                IUnit createdUnit = unitfactory.getNewUnit();
                EntityList.add(createdUnit);
            }
        }
    }

    @Override
    public List<IPlaceableEntity> getEntities() {
        return EntityList;
    }

    @Override
    public void remove(IPlaceableEntity unit) {
        for (IMap map : mapList) {
            map.removeEntity(unit);
            EntitiesOnMap.remove(unit);
        }
    }

    @Override
    public boolean decreaseHp(int damage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean Update() {
        for (IMap map : mapList) {
            if (counter < EntityList.size()) {
                putEntityOnMap(EntityList.get(counter), map.getMap());
                counter++;
            }
        }
        if (EntitiesOnMap.isEmpty()) {
            return false;
        }
        return true;
    }

}
