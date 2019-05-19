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

@ServiceProviders(value = {
    @ServiceProvider(service = IEnemy.class)
})
public class Enemy implements IEnemy {

    private int currentWave = 0;
    private int spawnCounter;
    private Random random = new Random();
    private ServiceLoader mapLoader;
    private ServiceLoader pathLoader;
    private ServiceLoader unitFactoryLoader;
    private List<IPlaceableEntity> entityList = new ArrayList<>();
    private List<IPlaceableEntity> entitiesOnMap = new ArrayList<>();


    public Enemy() {
        unitFactoryLoader = new ServiceLoader(IUnitFactory.class);
        mapLoader = new ServiceLoader(IMap.class);
        pathLoader = new ServiceLoader(IPathfinding.class);
    }

    public void putEntityOnMap(IPlaceableEntity unit) {
        try {
            for (IMap map : (List<IMap>) mapLoader.getServiceProviderList()) {
                Coordinate startPosition = new Coordinate(map.getTileSize(), random.nextInt((map.getLengthY() / (2 * map.getTileSize()))) * 2 * map.getTileSize() + map.getTileSize());
                Coordinate endPosition = new Coordinate(map.getLengthX() - map.getTileSize(), map.getLengthY() / 2 + map.getTileSize());
                unit.setPosition(startPosition);

                for (IPathfinding IPath : (List<IPathfinding>) pathLoader.getServiceProviderList()) {
                    List<Coordinate> path = IPath.generatePath(map, startPosition, endPosition);
                    ((IUnit) unit).setPath(path);
                }

                map.addEntity(unit);
                entitiesOnMap.add(unit);
            }

        } catch (Exception e) {
            e.getMessage();
            System.out.println("Pathfinding threw an exception");
        }
    }

    @Override
    public int getCurrentWave() {
        return currentWave;
    }

    @Override
    public void createWave() {
        spawnCounter = 0;
        entityList = new ArrayList<>();
        currentWave++;
        System.out.println("You are currently at wave number: " + currentWave);
        int weighting = (int) Math.floor(currentWave * 0.5) + 1;  // minimum wave-size get larger as game progresses

        for (IUnitFactory unitFactory : (List<IUnitFactory>) unitFactoryLoader.getServiceProviderList()) {
            int unitNumber = random.nextInt(11) + weighting;
            System.out.println("This wave contains " + unitNumber + " enemy units!");
            while (unitNumber > 0) {
                IUnit createdUnit = unitFactory.getNewUnit();
                entityList.add(createdUnit);
                unitNumber--;
            }
        }
    }

    @Override
    public List<IPlaceableEntity> getEntities() {
        return this.entityList;
    }

    @Override
    public void remove(IPlaceableEntity unit) {
        for (IMap map : (List<IMap>) mapLoader.getServiceProviderList()) {
            map.removeEntity(unit);
            entitiesOnMap.remove(unit);
        }
    }

    @Override
    public boolean update() {
        if (spawnCounter < entityList.size()) {
            putEntityOnMap(entityList.get(spawnCounter));
            spawnCounter++;
        }
        return !entitiesOnMap.isEmpty();
    }

}
