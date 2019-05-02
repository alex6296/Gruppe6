/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.map;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.data.ITile;
import dk.sdu.g3.common.services.IPlaceableEntity;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pvies
 */
public class MapTest {
    
    public MapTest() {
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
     * Test of generateMap method, of class Map.
     */
    @org.junit.Test
    public void testGenerateMap() {
        System.out.println("generateMap");
        Map instance = new Map();
        instance.setLengthX(600);
        instance.setLengthY(600);
        instance.generateMap();
        int tileSize = instance.getTileSize();
        int totalTiles = instance.getTileList().size();
        System.out.println("TileSize: " + tileSize + "\n Total Tiles: " + totalTiles);
        assertEquals(totalTiles, 625);
    }

    /**
     * Test of addEntity method, of class Map.
     */
    @org.junit.Test
    public void testAddEntity() {
        System.out.println("addEntity");
        IPlaceableEntity entity = null;     // ----- create entity
        Map instance = new Map();
        instance.setLengthX(600);
        instance.setLengthY(600);
        instance.generateMap();
        boolean result = instance.addEntity(entity);
        assertEquals(result, true);
    }

    /**
     * Test of removeEntity method, of class Map.
     */
    @org.junit.Test
    public void testRemoveEntity() {
        System.out.println("removeEntity");
        IPlaceableEntity entity = null;        // -------- also create entity
        Map instance = new Map();
        instance.setLengthX(600);
        instance.setLengthY(600);
        instance.generateMap();
        instance.removeEntity(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTileList method, of class Map.
     */
    @org.junit.Test
    public void testGetTileList() {
        System.out.println("getTileList");
        Map instance = new Map();
        List<ITile> expResult = null;
        List<ITile> result = instance.getTileList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLengthX method, of class Map.
     */
    @org.junit.Test
    public void testGetLengthX() {
        System.out.println("getLengthX");
        Map instance = new Map();
        int expResult = 0;
        int result = instance.getLengthX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLengthY method, of class Map.
     */
    @org.junit.Test
    public void testGetLengthY() {
        System.out.println("getLengthY");
        Map instance = new Map();
        int expResult = 0;
        int result = instance.getLengthY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLengthX method, of class Map.
     */
    @org.junit.Test
    public void testSetLengthX() {
        System.out.println("setLengthX");
        int x = 0;
        Map instance = new Map();
        instance.setLengthX(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLengthY method, of class Map.
     */
    @org.junit.Test
    public void testSetLengthY() {
        System.out.println("setLengthY");
        int y = 0;
        Map instance = new Map();
        instance.setLengthY(y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePositions method, of class Map.
     */
    @org.junit.Test
    public void testUpdatePositions() {
        System.out.println("updatePositions");
        Map instance = new Map();
        List<IPlaceableEntity> expResult = null;
        List<IPlaceableEntity> result = instance.updatePositions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateActions method, of class Map.
     */
    @org.junit.Test
    public void testUpdateActions() {
        System.out.println("updateActions");
        Map instance = new Map();
        instance.updateActions();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inspect method, of class Map.
     */
    @org.junit.Test
    public void testInspect() {
        System.out.println("inspect");
        Coordinate coord = null;
        Map instance = new Map();
        List<IPlaceableEntity> expResult = null;
        List<IPlaceableEntity> result = instance.inspect(coord);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
