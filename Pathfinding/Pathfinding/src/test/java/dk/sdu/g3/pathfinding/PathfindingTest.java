/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.pathfinding;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.services.IMap;
import dk.sdu.g3.map.Map;
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
     * Test of defineGoalNode method, of class Pathfinding. Complete and
     * compiled without error
     */
    @Test
    public void testDefineGoalNode() {
        System.out.println("defineGoalNode");
        Coordinate goal = new Coordinate(10, 10);
        Node node = new Node(goal, 10);
        Pathfinding instance = new Pathfinding();
        instance.addNode(node);
        instance.defineStartNode(goal);

        assertEquals((instance.getGoalNode().getCenter()), goal);
    }

    /**
     * Test of defineStartNode method, of class Pathfinding. Complete and
     * compiled without error
     */
    @Test
    public void testDefineStartNode() {
        System.out.println("defineStartNode");
        Coordinate start = new Coordinate(10, 10);
        Node node = new Node(start, 10);
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
     * Test of createNodes method, of class Pathfinding. Complete and compiled
     * without error
     */
    @Test
    public void testCreateNodes() {
        System.out.println("createNodes");
        IMap map = new Map();
        map.setLengthY(100);
        map.setLengthX(100);
        map.generateMap();
        Pathfinding instance = new Pathfinding();
        instance.createNodes(map);

        assertEquals(625, instance.getNodes().size());
    }

    /**
     * Test of calculateHeuristic method, of class Pathfinding. Complete and
     * compiled without error
     */
    @Test
    public void testCalculateHeuristic() {
        System.out.println("calculateHeuristic");
        Node node1 = new Node(new Coordinate(3, 5), 5);
        Node node2 = new Node(new Coordinate(10, 15), 5);
        Node currentNode = node1;
        Pathfinding instance = new Pathfinding();
        instance.setGoalNode(node2);
        instance.calculateHeuristic(currentNode);
        double result = currentNode.getHeuristic();
        double expResult = Math.sqrt(149);

        assertEquals(expResult, result, expResult - result);
    }

    /**
     * Test of calculateTotalPathCost method, of class Pathfinding. Complete and
     * compiled without error
     */
    @Test
    public void testCalculateTotalPathCost() {
        System.out.println("calculateTotalPathCost");
        Node currentNode = new Node(new Coordinate(5, 5), 5);
        currentNode.setHeuristic(5);
        currentNode.setAccumulatedStepCost(5);
        Pathfinding instance = new Pathfinding();
        instance.calculateTotalPathCost(currentNode);

        assertEquals(10, currentNode.getTotalCost(), 10 - currentNode.getTotalCost());
    }

    /**
     * Test of setLeftNeighbour method, of class Pathfinding. Complete and
     * compiled without error
     */
    @Test
    public void testSetLeftNeighbour() {
        System.out.println("setLeftNeighbour");
        Node currentNode = new Node(new Coordinate(20, 20), 5);
        Node leftNode = new Node(new Coordinate(10, 20), 5);
        Pathfinding instance = new Pathfinding();

        instance.addNode(currentNode);
        instance.addNode(leftNode);

        instance.setLeftNeighbour(currentNode);

        Node result = null;

        for (Node node : currentNode.getNeighbours()) {
            if (leftNode.getCenter() == node.getCenter()) {
                result = node;
            }
        }

        if (result != null) {
            assertEquals(leftNode.getCenter(), result.getCenter());
        } else {
            fail("CurrentNode LeftNeighbour was null - Test failure!");
        }

    }

    /**
     * Test of setRightNeighbour method, of class Pathfinding. Complete and
     * compiled without error
     */
    @Test
    public void testSetRightNeighbour() {
        System.out.println("setRightNeighbour");
        Node currentNode = new Node(new Coordinate(20, 20), 5);
        Node rightNode = new Node(new Coordinate(30, 20), 5);
        Pathfinding instance = new Pathfinding();

        instance.setMapLengthX(200);

        instance.addNode(currentNode);
        instance.addNode(rightNode);

        instance.setRightNeighbour(currentNode);

        Node result = null;

        for (Node node : currentNode.getNeighbours()) {
            if (rightNode.getCenter() == node.getCenter()) {
                result = node;
            }
        }

        if (result != null) {
            assertEquals(rightNode.getCenter(), result.getCenter());
        } else {
            fail("CurrentNode RightNeighbour wass null - Test Failure!");
        }

    }

    /**
     * Test of setUpNeighbour method, of class Pathfinding.
     */
    @Test
    public void testSetUpNeighbour() {
        System.out.println("setUpNeighbour");
        Node currentNode = new Node(new Coordinate(20, 20), 5);
        Node upNode = new Node(new Coordinate(20, 10), 5);
        Pathfinding instance = new Pathfinding();

        instance.addNode(currentNode);
        instance.addNode(upNode);

        instance.setUpNeighbour(currentNode);

        Node result = null;

        for (Node node : currentNode.getNeighbours()) {
            if (upNode.getCenter() == node.getCenter()) {
                result = node;
            }
        }

        if (result != null) {
            assertEquals(upNode.getCenter(), result.getCenter());
        } else {
            fail("CurrentNode UpNeighbour  was null - Test failure!");
        }
    }

    /**
     * Test of setDownNeighbour method, of class Pathfinding.
     * Complete and compiled without error
     */
    @Test
    public void testSetDownNeighbour() {
        System.out.println("setDownNeighbour");
        Node currentNode = new Node(new Coordinate(20, 20), 5);
        Node downNode = new Node(new Coordinate(20, 30), 5);
        Pathfinding instance = new Pathfinding();
        
        instance.setMapLengthY(200);
        instance.addNode(currentNode);
        instance.addNode(downNode);
        
        instance.setDownNeighbour(currentNode);
        
        Node result = null;
        
        for(Node node : currentNode.getNeighbours()) {
            if(downNode.getCenter() == node.getCenter()) {
                result = node;
            }
        }
        
        if(result != null) {
            assertEquals(downNode.getCenter(), result.getCenter());
        } else {
            fail("CurrentNode DownNeighbour was null - Test failure");
        }
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
