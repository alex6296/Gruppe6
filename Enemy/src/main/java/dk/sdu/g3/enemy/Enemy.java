/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.enemy;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.entities.ILifeFunctions;
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
    List<IPlaceableEntity> EntitiesOnMap;
    List<IUnitFactory> UnitFactoryList;
    int unitNumber;
    //valid tileSize = 2 * map.tilesize
    public Enemy() {
        
    }

    
    // put this method in IController, since both player/enemy uses it
    @Override
    public void putEntityOnMap(IPlaceableEntity unit,IMap map1) throws Exception{
        mapList = (List<IMap>) new ServiceLoader(IMap.class);
        for (IMap map : mapList){
            
             Coordinate startPosition = new Coordinate(map.getTileSize(),random.nextInt(map.getLengthY()/(2*map.getTileSize())));
               unit.setPosition(startPosition);
               pathlist = (List<IPathfinding>) new ServiceLoader(IPathfinding.class);

               for (IPathfinding IPath : pathlist){
                    addPathToUnit(IPath.generatePath(map1, unit.getCurrentPosition(), unit.getCurrentPosition()), (IUnit) unit);
                    }
               
                map.addEntity(unit);
                

        }
    }
    
    public void removeEntityFromMap(IPlaceableEntity unit){
        
        for (IMap map : mapList){
             map.removeEntity(unit);
        }
    }
    public void addPathToUnit(List<Coordinate> path, IUnit unit){
        unit.setPath(path);
    }
    @Override
    public int getCurrentWave() {
        return currentWave;
        
    }

    @Override
    public void createWave() {
   

    }
    public int generateWaveComposition(){
        counter = 0;
        unitNumber = random.nextInt(101);
        while(unitNumber>0){
            create();
        }
        
    return unitNumber;
}

    @Override
    public  IPlaceableEntity create() {
        for (IUnitFactory unitfactory : UnitFactoryList){
            IUnit createdUnit = unitfactory.getNewUnit();
            EntityList.add(createdUnit);
            return createdUnit;    
        }
        return null;
    }

    @Override
    public List<IPlaceableEntity> getEntities() {
        return EntityList;
    }

    @Override
    public void remove(ILifeFunctions livingEntity) {
        removeEntityFromMap((IPlaceableEntity) livingEntity);
    }

    @Override
    public boolean decreaseHp(int damage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean Update() throws Exception{
        for(IMap map : mapList){
        if(counter < EntityList.size()){
            putEntityOnMap(EntityList.get(counter),map.getMap());
            counter++;
        }
        }
        if(EntitiesOnMap.isEmpty()){
        return false;
        }
        return true;
    }
    

}