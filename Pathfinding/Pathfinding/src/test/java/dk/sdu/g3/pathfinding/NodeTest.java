/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.pathfinding;

import dk.sdu.g3.common.data.Coordinate;
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
public class NodeTest {
    
    public NodeTest() {
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
     * Test of addNeighbour method, of class Node.
     */
    @Test
    public void testAddNeighbour() {
        System.out.println("addNeighbour");
        Node neighbour = null;
        Node instance = null;
        instance.addNeighbour(neighbour);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isBlocked method, of class Node.
     */
    @Test
    public void testIsBlocked() {
        System.out.println("isBlocked");
        Node instance = null;
        boolean expResult = false;
        boolean result = instance.isBlocked();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCenter method, of class Node.
     */
    @Test
    public void testGetCenter() {
        System.out.println("getCenter");
        Node instance = null;
        Coordinate expResult = null;
        Coordinate result = instance.getCenter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class Node.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Node instance = null;
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccumulatedStepCost method, of class Node.
     */
    @Test
    public void testGetAccumulatedStepCost() {
        System.out.println("getAccumulatedStepCost");
        Node instance = null;
        double expResult = 0.0;
        double result = instance.getAccumulatedStepCost();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccumulatedStepCost method, of class Node.
     */
    @Test
    public void testSetAccumulatedStepCost() {
        System.out.println("setAccumulatedStepCost");
        double accumulatedStepCost = 0.0;
        Node instance = null;
        instance.setAccumulatedStepCost(accumulatedStepCost);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeuristic method, of class Node.
     */
    @Test
    public void testGetHeuristic() {
        System.out.println("getHeuristic");
        Node instance = null;
        double expResult = 0.0;
        double result = instance.getHeuristic();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeuristic method, of class Node.
     */
    @Test
    public void testSetHeuristic() {
        System.out.println("setHeuristic");
        double heuristic = 0.0;
        Node instance = null;
        instance.setHeuristic(heuristic);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalCost method, of class Node.
     */
    @Test
    public void testGetTotalCost() {
        System.out.println("getTotalCost");
        Node instance = null;
        double expResult = 0.0;
        double result = instance.getTotalCost();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotalCost method, of class Node.
     */
    @Test
    public void testSetTotalCost() {
        System.out.println("setTotalCost");
        double totalCost = 0.0;
        Node instance = null;
        instance.setTotalCost(totalCost);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNeighbours method, of class Node.
     */
    @Test
    public void testGetNeighbours() {
        System.out.println("getNeighbours");
        Node instance = null;
        List<Node> expResult = null;
        List<Node> result = instance.getNeighbours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setParent method, of class Node.
     */
    @Test
    public void testSetParent() {
        System.out.println("setParent");
        Node parent = null;
        Node instance = null;
        instance.setParent(parent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
