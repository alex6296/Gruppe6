/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.pathfinding;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.data.ITile;

/**
 *
 * @author Pottemuld
 */
public class Node {
    private double accumulatedStepCost; //The cost accumulated from the start node to the current node
    private double heuristic; //estimated heuristic value, defined by the heuristic function
    private double totalPathCost; //accumulatedStepCost + heuristic - estimated total cost from start to goal through this node
    private Coordinate center;
    private int sizeX;
    private int sizeY;
    private Node previousNode;

    public Node(Coordinate center, int sizeX, int sizeY) {
        this.center = center;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }
    
    
    
    
}
