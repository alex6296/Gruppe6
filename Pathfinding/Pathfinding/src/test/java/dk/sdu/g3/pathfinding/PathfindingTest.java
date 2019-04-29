/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.pathfinding;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.services.IMap;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CasaRol
 */
public class PathfindingTest {
    
    public PathfindingTest() {
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
     * Test of getNextCoordinate method, of class Pathfinding.
     */
    @Test
    public void testGetNextCoordinate() {
        System.out.println("getNextCoordinate");
        Coordinate currentCoord = null;
        Pathfinding instance = new Pathfinding();
        Coordinate expResult = null;
        Coordinate result = instance.getNextCoordinate(currentCoord);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generatePath method, of class Pathfinding.
     */
    @Test
    public void testGeneratePath() {
        System.out.println("generatePath");
        IMap map = null;
        Coordinate start = null;
        Coordinate goal = null;
        Pathfinding instance = new Pathfinding();
        List<Coordinate> expResult = null;
        List<Coordinate> result = instance.generatePath(map, start, goal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findSuccessor method, of class Pathfinding.
     */
    @Test
    public void testFindSuccessor() {
        System.out.println("findSuccessor");
        Node currentNode = null;
        Pathfinding instance = new Pathfinding();
        Node expResult = null;
        Node result = instance.findSuccessor(currentNode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToFringe method, of class Pathfinding.
     */
    @Test
    public void testAddToFringe() {
        System.out.println("addToFringe");
        Pathfinding instance = new Pathfinding();
        instance.addToFringe();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalPathCost method, of class Pathfinding.
     */
    @Test
    public void testGetTotalPathCost() {
        System.out.println("getTotalPathCost");
        Pathfinding instance = new Pathfinding();
        double expResult = 0.0;
        double result = instance.getTotalPathCost();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotalPathCost method, of class Pathfinding.
     */
    @Test
    public void testSetTotalPathCost() {
        System.out.println("setTotalPathCost");
        double totalPathCost = 0.0;
        Pathfinding instance = new Pathfinding();
        instance.setTotalPathCost(totalPathCost);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
