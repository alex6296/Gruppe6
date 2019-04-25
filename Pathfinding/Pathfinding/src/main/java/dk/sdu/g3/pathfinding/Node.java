/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.pathfinding;

import dk.sdu.g3.common.data.Coordinate;


public class Node {
    private double accumulatedStepCost; //The cost accumulated from the start node to the current node
    private double heuristic; //estimated heuristic value, defined by the heuristic function
    private double totalPathCost; //accumulatedStepCost + heuristic - estimated total cost from start to goal through this node
    private final Coordinate center;
    private final int size;
    private boolean isBlocked;
    private Node previousNode;
    private Node leftNeighbour;
    private Node rightNeighbour;
    private Node upNeighbour;
    private Node downNeightbour;

    public Node(Coordinate center, int size, boolean isBlocked) {
        this.center = center;
        this.size = size;
        this.isBlocked = isBlocked;
    }

    
    
    public Node getLeftNeighbour() {
        return leftNeighbour;
    }

    public void setLeftNeighbour(Node leftNeighbour) {
        this.leftNeighbour = leftNeighbour;
    }

    public Node getRightNeighbour() {
        return rightNeighbour;
    }

    public void setRightNeighbour(Node rightNeighbour) {
        this.rightNeighbour = rightNeighbour;
    }

    public Node getUpNeighbour() {
        return upNeighbour;
    }

    public void setUpNeighbour(Node upNeighbour) {
        this.upNeighbour = upNeighbour;
    }

    public Node getDownNeightbour() {
        return downNeightbour;
    }

    public void setDownNeightbour(Node downNeightbour) {
        this.downNeightbour = downNeightbour;
    }
    
    public void setAccumulatedStepCost(double accumulatedStepCost) {
        this.accumulatedStepCost = accumulatedStepCost;
    }

    public void setHeuristic(double heuristic) {
        this.heuristic = heuristic;
    }

    public void setTotalPathCost(double totalPathCost) {
        this.totalPathCost = totalPathCost;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    
    
    public double getAccumulatedStepCost() {
        return accumulatedStepCost;
    }

    public double getHeuristic() {
        return heuristic;
    }

    public double getTotalPathCost() {
        return totalPathCost;
    }

    public Coordinate getCenter() {
        return center;
    }

    public int getSize() {
        return size;
    }

    public Node getPreviousNode() {
        return previousNode;
    }
 
    
    
}
