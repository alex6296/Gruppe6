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
     * Test of generatePath method, of class Pathfinding.
     */
    @Test
    public void testGeneratePath() throws Exception {
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
     * Test of defineGoalNode method, of class Pathfinding.
     */
    @Test
    public void testDefineGoalNode() {
        System.out.println("defineGoalNode");
        Coordinate goal = new Coordinate(10, 10);
        Node node = new Node(goal, 10, false);
        Pathfinding instance = new Pathfinding();
        instance.addNode(node);
        instance.defineStartNode(goal);
        
        assertEquals((instance.getGoalNode().getCenter()), goal);
    }

    /**
     * Test of defineStartNode method, of class Pathfinding.
     */
    @Test
    public void testDefineStartNode() {
        System.out.println("defineStartNode");
        Coordinate start = new Coordinate(10, 10);
        Node node = new Node(start, 10, false);
        Pathfinding instance = new Pathfinding();
        instance.addNode(node);
        instance.defineStartNode(start);
        
        assertEquals((instance.getStartNode().getCenter()), start);
    }

    /**
     * Test of assignNeighbour method, of class Pathfinding.
     */
    @Test
    public void testAssignNeighbour() {
        System.out.println("assignNeighbour");
        int x = 0;
        int y = 0;
        Pathfinding instance = new Pathfinding();
        Node expResult = null;
        Node result = instance.assignNeighbour(x, y);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of createNodes method, of class Pathfinding.
     */
    @Test
    public void testCreateNodes() {
        System.out.println("createNodes");
        IMap map = null;
        Pathfinding instance = new Pathfinding();
        instance.createNodes(map);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateHeuristic method, of class Pathfinding.
     */
    @Test
    public void testCalculateHeuristic() {
        System.out.println("calculateHeuristic");
        Node node1 = new Node(new Coordinate(3, 5), 5, false);
        Node node2 = new Node(new Coordinate(10, 15), 5, false);
        Node currentNode = node1;
        Pathfinding instance = new Pathfinding();
        instance.setGoalNode(node2);
        instance.calculateHeuristic(currentNode);
        double result = currentNode.getHeuristic();
        double expResult = Math.sqrt(149);
        
        assertEquals(expResult, result, expResult-result);
    }

    /**
     * Test of calculateTotalPathCost method, of class Pathfinding.
     */
    @Test
    public void testCalculateTotalPathCost() {
        System.out.println("calculateTotalPathCost");
        Node currentNode = null;
        Pathfinding instance = new Pathfinding();
        instance.calculateTotalPathCost(currentNode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLeftNeighbour method, of class Pathfinding.
     */
    @Test
    public void testSetLeftNeighbour() {
        System.out.println("setLeftNeighbour");
        Node currentNode = null;
        Pathfinding instance = new Pathfinding();
        instance.setLeftNeighbour(currentNode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRightNeighbour method, of class Pathfinding.
     */
    @Test
    public void testSetRightNeighbour() {
        System.out.println("setRightNeighbour");
        Node currentNode = null;
        Pathfinding instance = new Pathfinding();
        instance.setRightNeighbour(currentNode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUpNeighbour method, of class Pathfinding.
     */
    @Test
    public void testSetUpNeighbour() {
        System.out.println("setUpNeighbour");
        Node currentNode = null;
        Pathfinding instance = new Pathfinding();
        instance.setUpNeighbour(currentNode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDownNeighbour method, of class Pathfinding.
     */
    @Test
    public void testSetDownNeighbour() {
        System.out.println("setDownNeighbour");
        Node currentNode = null;
        Pathfinding instance = new Pathfinding();
        instance.setDownNeighbour(currentNode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertNodes method, of class Pathfinding.
     */
    @Test
    public void testConvertNodes() {
        System.out.println("convertNodes");
        List<Node> openList = null;
        Pathfinding instance = new Pathfinding();
        List<Coordinate> expResult = null;
        List<Coordinate> result = instance.convertNodes(openList);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
