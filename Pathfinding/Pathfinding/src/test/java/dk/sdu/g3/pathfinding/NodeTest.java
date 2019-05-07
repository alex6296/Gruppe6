///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dk.sdu.g3.pathfinding;
//
//import dk.sdu.g3.common.data.Coordinate;
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author CasaRol
// */
//public class NodeTest {
//
//    public NodeTest() {
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
//     * Test of addNeighbour method, of class Node.
//     */
//    @Test
//    public void testAddNeighbour() {
//        System.out.println("addNeighbour");
//        Node neighbour = new Node(new Coordinate(10, 20), 5);
//        Node instance = new Node(new Coordinate(20, 20), 5);
//        instance.addNeighbour(neighbour);
//
//        boolean contains = false;
//
//        for (Node node : instance.getNeighbours()) {
//            if (node == neighbour) {
//                contains = true;
//            }
//        }
//
//        assertEquals(true, contains);
//    }
//
//    /**
//     * Test of getCenter method, of class Node.
//     */
//    @Test
//    public void testGetCenter() {
//        System.out.println("getCenter");
//        Node instance = new Node(new Coordinate(10, 10), 5);
//        Coordinate expResult = new Coordinate(10, 10);
//        Coordinate result = instance.getCenter();
//
//        boolean center = false;
//
//        if (expResult.getX() == result.getX() && expResult.getY() == result.getY()) {
//            center = true;
//        }
//
//        assertEquals(true, center);
//    }
//
//    /**
//     * Test of getSize method, of class Node.
//     */
//    @Test
//    public void testGetSize() {
//        System.out.println("getSize");
//        Node instance = new Node(new Coordinate(10, 10), 5);
//        int expResult = 5;
//        int result = instance.getSize();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getAccumulatedStepCost method, of class Node.
//     */
//    @Test
//    public void testGetAccumulatedStepCost() {
//        System.out.println("getAccumulatedStepCost");
//        Node instance = new Node(new Coordinate(10, 10), 5);
//        instance.setAccumulatedStepCost(200);
//        double expResult = 200;
//        double result = instance.getAccumulatedStepCost();
//        assertEquals(expResult, result, 0.0);
//    }
//
//    /**
//     * Test of setAccumulatedStepCost method, of class Node.
//     */
//    @Test
//    public void testSetAccumulatedStepCost() {
//        System.out.println("setAccumulatedStepCost");
//        double accumulatedStepCost = 200;
//        Node instance = new Node(new Coordinate(10, 10), 5);
//        instance.setAccumulatedStepCost(accumulatedStepCost);
//        
//        assertEquals(200, instance.getAccumulatedStepCost(), 0.0);
//        
//    }
//
//    /**
//     * Test of getHeuristic method, of class Node.
//     */
//    @Test
//    public void testGetHeuristic() {
//        System.out.println("getHeuristic");
//        Node instance = new Node(new Coordinate(10, 10), 5);
//        instance.setHeuristic(250);
//        double expResult = 250;
//        double result = instance.getHeuristic();
//        assertEquals(expResult, result, 0.0);
//    }
//
//    /**
//     * Test of setHeuristic method, of class Node.
//     */
//    @Test
//    public void testSetHeuristic() {
//        System.out.println("setHeuristic");
//        double heuristic = 250;
//        Node instance = new Node(new Coordinate(10, 10), 5);
//        instance.setHeuristic(heuristic);
//        
//        assertEquals(heuristic, instance.getHeuristic(), 0.0);
//    }
//
//    /**
//     * Test of getTotalCost method, of class Node.
//     */
//    @Test
//    public void testGetTotalCost() {
//        System.out.println("getTotalCost");
//        Node instance = new Node(new Coordinate(10, 10), 5);
//        instance.setTotalCost(250);
//        double expResult = 250;
//        double result = instance.getTotalCost();
//        assertEquals(expResult, result, 0.0);
//    }
//
//    /**
//     * Test of setTotalCost method, of class Node.
//     */
//    @Test
//    public void testSetTotalCost() {
//        System.out.println("setTotalCost");
//        double totalCost = 500;
//        Node instance = new Node(new Coordinate(10, 10), 5);
//        instance.setTotalCost(totalCost);
//        double expResult = 500;
//        
//        assertEquals(expResult, instance.getTotalCost(), 0.0);
//    }
//
//    /**
//     * Test of getNeighbours method, of class Node.
//     */
//    @Test
//    public void testGetNeighbours() {
//        System.out.println("getNeighbours");
//        Node instance = new Node(new Coordinate(20, 20), 5);
//        
//        Node node1 = new Node(new Coordinate(30, 20), 5);
//        Node node2 = new Node(new Coordinate(10, 20), 5);
//        
//        instance.addNeighbour(node1);
//        instance.addNeighbour(node2);
//        
//        List<Node> expResult = new ArrayList<>();
//        
//        expResult.add(node1);
//        expResult.add(node2);
//        
//        List<Node> result = instance.getNeighbours();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of setParent method, of class Node.
//     */
//    @Test
//    public void testSetParent() {
//        System.out.println("setParent");
//        Node parent = new Node(new Coordinate(10, 20), 5);
//        Node instance = new Node(new Coordinate(20, 20), 5);
//        instance.setParent(parent);
//        
//        Node expResult = parent;
//        
//        assertEquals(expResult, instance.getPatent());
//    }
//
//    /**
//     * Test of getPatent method, of class Node.
//     */
//    @Test
//    public void testGetPatent() {
//        System.out.println("getPatent");
//        Node instance = new Node(new Coordinate(10, 20), 5);
//        Node expResult = new Node(new Coordinate(10, 10), 5);
//        instance.setParent(expResult);
//        Node result = instance.getPatent();
//        assertEquals(expResult, result);
//    }
//
//}
