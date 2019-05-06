/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.enemy;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.entities.ILifeFunctions;
import dk.sdu.g3.common.serviceLoader.ServiceLoader;
import dk.sdu.g3.common.services.IMap;
import dk.sdu.g3.common.services.IPathfinding;
import dk.sdu.g3.common.services.IPlaceableEntity;
import dk.sdu.g3.common.services.IUnit;
import dk.sdu.g3.common.services.IUnitFactory;
import static java.lang.Math.random;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sebastian
 */
public class EnemyTest {
    List<IUnitFactory> unitFactoryList;
    List<IPathfinding> IPathfindingList;
    List<IMap> mapList;
        Random random = new Random();
    IUnitFactory unitFactory1;
    
    public EnemyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of putEntityOnMap method, of class Enemy.
     */
    @Test
    public void testPutEntityOnMap() throws Exception {
        System.out.println("putEntityOnMap");
        unitFactory1 =  (IUnitFactory) new ServiceLoader(IUnitFactory.class);
        IPlaceableEntity unit = unitFactory1.getNewUnit();
        Enemy instance = new Enemy();
        mapList = (List<IMap>) new ServiceLoader(IMap.class).getServiceProviderList();
        for(IMap map1 : mapList){
        instance.putEntityOnMap(unit, map1.getMap());
        
    }
    }
}

    /**
     * Test of removeEntityFromMap method, of class Enemy.
     */
//    @Test
//    public void testRemoveEntityFromMap() {
//        System.out.println("removeEntityFromMap");
//        IPlaceableEntity unit = unitFactory.getNewUnit();
//        Enemy instance = new Enemy();
//        instance.removeEntityFromMap(unit);
//    }
//
//    /**
//     * Test of addPathToUnit method, of class Enemy.
//     */
//    @Test
//    public void testAddPathToUnit() throws Exception {
//        System.out.println("addPathToUnit");
//        Enemy instance = new Enemy();
//        IUnit unit = unitFactory.getNewUnit();
//        Coordinate startPosition = new Coordinate(map1.getTileSize(),random.nextInt(map1.getLengthY()/(2*map1.getTileSize())));
//        Coordinate goal = new Coordinate(map1.getTileSize(),random.nextInt(map1.getLengthY()/(map1.getTileSize())));
//        List<Coordinate> path = pathing.generatePath(map1.getMap(),startPosition , goal);
//        instance.addPathToUnit(path, unit);
//    }
//
//    /**
//     * Test of getCurrentWave method, of class Enemy.
//     */
//    @Test
//    public void testGetCurrentWave() {
//        System.out.println("getCurrentWave");
//        Enemy instance = new Enemy();
//        int expResult = 0;
//        int result = instance.getCurrentWave();
//        System.out.println("expResult" + expResult + "result" + result);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of createWave method, of class Enemy.
//     */
//    @Test
//    public void testCreateWave() {
//        System.out.println("createWave");
//        Enemy instance = new Enemy();
//        instance.createWave();
//    }
//
//    /**
//     * Test of generateWaveComposition method, of class Enemy.
//     */
//    @Test
//    public void testGenerateWaveComposition() {
//        System.out.println("generateWaveComposition");
//        Enemy instance = new Enemy();
//        int expResult = 0;
//        int result = instance.generateWaveComposition();
//        System.out.println("expResult" + expResult + "result" + result);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of create method, of class Enemy.
//     */
//    @Test
//    public void testCreate() {
//        System.out.println("create");
//        Enemy instance = new Enemy();
//        IPlaceableEntity expResult = null;
//        IPlaceableEntity result = instance.create();
//        System.out.println("expResult" + expResult + "result" + result);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getEntities method, of class Enemy.
//     */
//    @Test
//    public void testGetEntities() {
//        System.out.println("getEntities");
//        Enemy instance = new Enemy();
//        List<IPlaceableEntity> expResult = null;
//        List<IPlaceableEntity> result = instance.getEntities();
//        System.out.println("expResult" + expResult + "result" + result);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of remove method, of class Enemy.
//     */
//    @Test
//    public void testRemove() {
//        System.out.println("remove");
//        ILifeFunctions livingEntity = null;
//        Enemy instance = new Enemy();
//        instance.remove(livingEntity);
//    }
//
//    /**
//     * Test of decreaseHp method, of class Enemy.
//     */
//    @Test
//    public void testDecreaseHp() {
//        System.out.println("decreaseHp");
//        int damage = 0;
//        Enemy instance = new Enemy();
//        boolean expResult = false;
//        boolean result = instance.decreaseHp(damage);
//        System.out.println("expResult" + expResult + "result" + result);
//        assertEquals(expResult, result);
//    }
//    
//}
