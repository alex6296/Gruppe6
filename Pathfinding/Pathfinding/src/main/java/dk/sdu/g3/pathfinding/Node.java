package dk.sdu.g3.pathfinding;

import dk.sdu.g3.common.data.Coordinate;
import java.util.ArrayList;
import java.util.List;

public class Node {

    private final Coordinate center;
    private final int size;
    private List<Node> neighbours; //List of adjacent Nodes
    private double totalCost; //accumulatedStepCost + heuristic - estimated total cost from start to goal through this node
    private double accumulatedStepCost;
    private double heuristic; //estimated heuristic value, defined by the heuristic function
    private Node parent;

    
    public Node(Coordinate center, int size) {
        this.center = center;
        this.size = size;
        neighbours = new ArrayList<>();
        
    }

    public void addNeighbour(Node neighbour) {
        neighbours.add(neighbour);
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
    
    public void clearNeighbours() {
        this.neighbours = new ArrayList<>();
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }
}
