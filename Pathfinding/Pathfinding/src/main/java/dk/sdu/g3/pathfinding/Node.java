/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.pathfinding;

import dk.sdu.g3.common.data.Coordinate;
import java.util.ArrayList;
import java.util.List;



public class Node {
    
    
    private final Coordinate center;
    private final int size;
    private boolean isBlocked;
    private List<Node> neighbours;
    private double totalCost;
    private double accumulatedStepCost; //accumulatedStepCost + heuristic - estimated total cost from start to goal through this node
    private double heuristic; //estimated heuristic value, defined by the heuristic function
    private Node parent;

    public Node(Coordinate center, int size, boolean isBlocked) {
        this.center = center;
        this.size = size;
        this.isBlocked = isBlocked;
        neighbours = new ArrayList<>();
    }
    
    public void addNeighbour(Node neighbour) {
        neighbours.add(neighbour);
    }

    //Compare two Nodes to see if they are equal
    public boolean equals(Node node) {
        return this.getCenter() == node.getCenter();
    }

    public boolean isIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public Coordinate getCenter() {
        return center;
    }

    public int getSize() {
        return size;
    }
    
    public double getAccumulatedStepCost() {
        return accumulatedStepCost;
    }

    public void setAccumulatedStepCost(double accumulatedStepCost) {
        this.accumulatedStepCost = accumulatedStepCost;
    }

    public double getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(double heuristic) {
        this.heuristic = heuristic;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    
    
}
