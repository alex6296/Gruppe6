/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.pathfinding;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.data.ITile;
import dk.sdu.g3.common.services.IMap;
import dk.sdu.g3.common.services.IPathfinding;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

@ServiceProviders(value = {
    @ServiceProvider(service = IPathfinding.class),})
public class Pathfinding implements IPathfinding {

    IMap map;
    int lenghtX = map.getLengthX();
    int lengthY = map.getLengthY();
    List<Node> nodes = new ArrayList<>();

    @Override
    public Coordinate getNextCoordinate(Coordinate currentCoord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Coordinate> generatePath(IMap map, Coordinate start, Coordinate goal) {
        return null;

    }

    private Node assignNeighbour(int x, int y) { //Look out for null pointer
        for (Node node : nodes) {
            if (node.getCenter().getX() == x) {
                if (node.getCenter().getY() == y) {
                    return node;
                }
            }
        } //Possible null pointer
        return null;
    }

    private void createNodes() {
        List<ITile> tiles = map.getTileList();
        for (ITile tile : tiles) {
            Node node = new Node(tile.getCoordinate(), tile.getSize());
            nodes.add(node);
        }
    }

    private void setAdjacentNodes(Node currentNode) {
        setLeftNeighbour(currentNode);
        setRightNeighbour(currentNode);
        setUpNeighbour(currentNode);
        setDownNeighbour(currentNode);
    }

    private void setLeftNeighbour(Node currentNode) {
        //If (center coordinate of currentNode(x) - size of currentNode(x)) > min(x), we set left neighbour to be the node with center(x) = center(currentnode(x))-2 x size(x)
        if ((currentNode.getCenter().getX() - currentNode.getSize()) > 0) {
            currentNode.setLeftNeighbour(assignNeighbour((currentNode.getCenter().getX() - (currentNode.getSize() * 2)), currentNode.getCenter().getY()));
        }
    }

    private void setRightNeighbour(Node currentNode) {
        //If (center coordinate of currentNode(x) + size of currentNode(x) < max(x), we set right neighbour
        if ((currentNode.getCenter().getX() + currentNode.getSize() < map.getLengthX())) {
            currentNode.setRightNeighbour(assignNeighbour((currentNode.getCenter().getX() + (currentNode.getSize() * 2)), currentNode.getCenter().getY()));
        }
    }

    private void setUpNeighbour(Node currentNode) {
        //If (center coordinate of currentNode(y) - size of currentNode(y)) > min(y), we set up neighbour  
        if((currentNode.getCenter().getY() - currentNode.getSize() > 0)) {
            currentNode.setUpNeighbour(assignNeighbour(currentNode.getCenter().getX(), currentNode.getCenter().getY() - (currentNode.getSize() * 2)));
        }
    }

    private void setDownNeighbour(Node currentNode) {
        //If (center coordinate of currentNode(y) + size of currentNode(y)) < max(y), we set down neighbour  
        if(currentNode.getCenter().getY() + currentNode.getSize() < map.getLengthY()) {
            currentNode.setDownNeightbour(assignNeighbour(currentNode.getCenter().getX(), currentNode.getCenter().getY() + (currentNode.getSize() * 2)));
        }
    }

}
