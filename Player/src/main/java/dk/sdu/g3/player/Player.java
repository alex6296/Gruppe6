/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.player;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.entities.ILifeFunctions;
import dk.sdu.g3.common.serviceLoader.ServiceLoader;
import dk.sdu.g3.common.services.IMap;
import dk.sdu.g3.common.services.IPlaceableEntity;
import dk.sdu.g3.common.services.IPlayer;
import dk.sdu.g3.common.services.ITower;
import dk.sdu.g3.common.services.ITowerFactory;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

@ServiceProviders(value = {
    @ServiceProvider(service = IPlayer.class)
})

/**
 *
 * @author robertfrancisti
 */
public class Player implements IPlayer {

    private TowerPicker tp;
    int hp = 10;
    int gold = 10;
    ArrayList<IPlaceableEntity> EntityList = new ArrayList();
    ArrayList<ITowerFactory> TowerFactoryList = new ArrayList();
    ITower tower1;
    List<IMap> mapList;
    ITower reservedTower;
    List<ITowerFactory> factoryList;
    List<ITower> towerlist;

    public Player() {
        tp = new TowerPicker();
    }

    public Player(int hp, int gold) {
        this.hp = hp;
        this.gold = gold;
    }

    @Override
    public int getCurrentHp() {
        return hp;
    }

    @Override
    public int getCurrentGold() {
        return gold;
    }

    @Override
    public ArrayList<IPlaceableEntity> getEntities() {
        return EntityList;
    }

//    @Override
//    public IPlaceableEntity create() {
//        factoryList = (List<ITowerFactory>) new ServiceLoader(ITowerFactory.class).getServiceProviderList();
//        for (ITowerFactory tower : factoryList) {
//            ITower createdTower = tower.getNewTower();
//            return createdTower;
//        }
//        return null;
//    }

    @Override
    public void remove(IPlaceableEntity livingEntity) {
        for (IMap map : mapList) {
            map.removeEntity(livingEntity);
        }
    }

    public void placeTowerOnMap(ITower Tower) {
//    unitLoader.getSP(IMap.class).add(Tower);

    }

    @Override
    public boolean decreaseHp(int damage) {
        hp = hp - damage;
        if (hp <= 0) {
            return false;
        }
        return true;
    }

    @Override
    public void putEntityOnMap(IPlaceableEntity Entity, IMap map1) throws Exception {
        for (IMap map : mapList) {
            map.getMap().addEntity(Entity);
        }
    }

    @Override
    public void reserveTower(ITower tower) {
        mapList = (List<IMap>) new ServiceLoader(IMap.class).getServiceProviderList();
        reservedTower = tower;
        System.out.println("this tower is reserved:" + reservedTower.toString());
    }

    @Override
    public void placeReservedTower(Coordinate coor) {
//        towerlist = (List<ITower>) new ServiceLoader(ITower.class);
//         for (ITower tower : towerlist){
        if (reservedTower != null) {
            reservedTower.setPosition(coor);
//         }
            mapList = (List<IMap>) new ServiceLoader(IMap.class).getServiceProviderList();
            for (IMap map : mapList) {
                map.addEntity(reservedTower);
                reservedTower = null;
            }

        }
    }
}
