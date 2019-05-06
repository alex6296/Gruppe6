///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dk.sdu.g3.enemy;
//
//import dk.sdu.g3.common.data.Coordinate;
//import dk.sdu.g3.common.entities.ILifeFunctions;
//import dk.sdu.g3.common.serviceLoader.ServiceLoader;
//import dk.sdu.g3.common.services.IMap;
//import dk.sdu.g3.common.services.IPathfinding;
//import dk.sdu.g3.common.services.IPlaceableEntity;
//import dk.sdu.g3.common.services.IUnit;
//import dk.sdu.g3.common.services.IUnitFactory;
//import static java.lang.Math.random;
//import java.util.List;
//import java.util.Random;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author sebastian
// */
//public class EnemyTest {
//    List<IUnitFactory> unitFactoryList;
//    List<IPathfinding> IPathfindingList;
//    List<IMap> mapList;
//        Random random = new Random();
//    IUnitFactory unitFactory1;
//    
//    public EnemyTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//}
//    /**
//     * Test of putEntityOnMap method, of class Enemy.
//     */
////    @Test
////    public void testPutEntityOnMap() throws Exception {
////        System.out.println("putEntityOnMap");
////        unitFactoryList = (List<IUnitFactory>) new ServiceLoader(IUnitFactory.class).getServiceProviderList();
////        for(IUnitFactory Unitfactory : unitFactoryList){
////        IUnit unit = Unitfactory.getNewUnit();
////        
////        Enemy instance = new Enemy();
////        
////        
////        mapList = (List<IMap>) new ServiceLoader(IMap.class).getServiceProviderList();
////        for(IMap map1 : mapList){
////            map1.generateMap(600, 600);
////        Coordinate startposition = new Coordinate(12,12);
////        unit.setPosition(startposition);
////        instance.putEntityOnMap(unit, map1.getMap());
////        
////        assertEquals(map1.inspect(startposition).get(0),unit);
////        }
////    }
////    }
////    
////}
