/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.map;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.data.ITile;
import dk.sdu.g3.common.services.IPlaceableEntity;
import dk.sdu.g3.tower.Tower;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
// *
// * @author pvies
// */
//public class MapTest {
//    
//    public MapTest() {
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
//
//    /**
//     * Test of generateMap method, of class Map.
//     */
//    @org.junit.Test
//    public void testGenerateMap() {
//        System.out.println("generateMap");
//        Map instance = new Map();
//        instance.generateMap(600, 600);
//        int tileSize = instance.getTileSize();
//        int totalTiles = instance.getTileList().size();
//        System.out.println("TileSize: " + tileSize + "\n Total Tiles: " + totalTiles);
//        assertEquals(625, totalTiles);
//    }
//
//    /**
//     * Test of addEntity method, of class Map.
//     */
//    @org.junit.Test
//    public void testAddEntity() {
//        System.out.println("addEntity");
//        IPlaceableEntity entity = new Tower(100, 10, 1, 2, 2, 5, new Coordinate(56,60));
//        Map instance = new Map();
//        instance.generateMap(600, 600);
//        boolean result = instance.addEntity(entity);
//        assertEquals(true, result);
//    }
//
//    /**
//     * Test of removeEntity method, of class Map.
//     */
//    @org.junit.Test
//    public void testRemoveEntity() {
//        System.out.println("removeEntity");
//        Coordinate pos = new Coordinate(56,60);
//        IPlaceableEntity entity = new Tower(100, 10, 1, 2, 2, 5, pos);
//        Map instance = new Map();
//        instance.generateMap(600, 600);
//        instance.addEntity(entity);
//        instance.removeEntity(entity);
//        
//        List<IPlaceableEntity> result = instance.getTileList().get(0).getEntities();
//        List<IPlaceableEntity> expected = new ArrayList<>();
//        
//        assertEquals(expected, result);
//    }
//
//    /**
//     * Test of getTileList method, of class Map.
//     */
//    @org.junit.Test
//    public void testGetTileList() {
//        System.out.println("getTileList");
//        Map instance = new Map();
//        instance.generateMap(600, 600);
//        
//        int expResult = 625;
//        int result = instance.getTileList().size();
//        
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getLengthX method, of class Map.
//     */
//    @org.junit.Test
//    public void testGetLengthX() {
//        System.out.println("getLengthX");
//        Map instance = new Map();
//        instance.setLengthX(600);
//        int expResult = 600;
//        int result = instance.getLengthX();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getLengthY method, of class Map.
//     */
//    @org.junit.Test
//    public void testGetLengthY() {
//        System.out.println("getLengthY");
//        Map instance = new Map();
//        instance.setLengthY(600);
//        int expResult = 600;
//        int result = instance.getLengthY();
//        
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of setLengthX method, of class Map.
//     */
//    @org.junit.Test
//    public void testSetLengthX() {
//        System.out.println("setLengthX");
//        int x = 600;
//        Map instance = new Map();
//        instance.setLengthX(x);
//        int result = instance.getLengthX();
//        int expected = x;
//        
//        assertEquals(expected, result);
//    }
//
//    /**
//     * Test of setLengthY method, of class Map.
//     */
//    @org.junit.Test
//    public void testSetLengthY() {
//        System.out.println("setLengthY");
//        int y = 600;
//        Map instance = new Map();
//        instance.setLengthY(y);
//        int result = instance.getLengthY();
//        int expected = y;
//        
//        assertEquals(expected, result);
//    }
//
//    /**
//     * Test of updatePositions method, of class Map.
//     */
//    @org.junit.Test
//    public void testUpdatePositions() {
//        System.out.println("updatePositions");
//        Map instance = new Map();
//        List<IPlaceableEntity> expResult = new ArrayList<IPlaceableEntity>();
//        List<IPlaceableEntity> result = instance.updatePositions();
//        
//        assertEquals(expResult, result);
//        // TODO review the generated test code.
//    }
//
//    /**
//     * Test of updateActions method, of class Map.
//     */
//    @org.junit.Test
//    public void testUpdateActions() {
//        System.out.println("updateActions");
//        Map instance = new Map();
//        instance.updateActions();
//        
//        String result = "I got here";
//        assertEquals("I got here", result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of inspect method, of class Map.
//     */
//    @org.junit.Test
//    public void testInspect() {
//        System.out.println("inspect");
//        Coordinate coord = new Coordinate(1, 1);
//        Map instance = new Map();
//        
//        List<IPlaceableEntity> expResult = instance.getTileList().get(0).getEntities();
//        List<IPlaceableEntity> result = instance.inspect(coord);
//        
//        assertEquals(expResult, result);
//    }
//    
//}
