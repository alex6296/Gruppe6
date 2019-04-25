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

    private IMap map;
    private Coordinate start;
    private Coordinate goal;
    private int mapLenghtX = map.getLengthX();
    private int mapLengthY = map.getLengthY();
    private List<Node> nodes = new ArrayList<>();
    private double totalPathCost; 
    private static final int STEP_COST = 1;

    public Pathfinding() {
    }

    //TODO
    @Override
    public Coordinate getNextCoordinate(Coordinate currentCoord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //TODO
    @Override
    public List<Coordinate> generatePath(IMap map, Coordinate start, Coordinate goal) {
        createNodes();

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
            Node node = new Node(tile.getCoordinate(), tile.getSize(), tile.isOccupied());
            nodes.add(node);
        }
        //Set ajacent nodes right after all nodes has been created in the list
        for (Node node : nodes) {
            setAdjacentNodes(node);
        }
    }

    /**
     * Method used to calculate the value of the heuristic function, used to
     * determine the estimated distance to the goal coordinate in a straight
     * line
     *
     * @param currentNode is the Node that the pathfinding algorithm has reached
     * in its current iteration Variable a is the distance from currentNode's
     * center x Coordinate to the goal Coordinate Variable b is the distance
     * from currentNode's center y Coordinate to the goal Coordinate This forms
     * a triangle between the currentNode and the goal, with the sides being a,
     * b and c By using pythagore, the variable c is calculated, which is the
     * distance from the currentNode to the goal Coordinate
     */
    private void calculateHeuristic(Node currentNode) {
        int sideA = (goal.getX() - currentNode.getCenter().getX());
        int sideB = (goal.getY() - currentNode.getCenter().getY());
        double diagonal = Math.sqrt(Math.pow(sideA, 2.0) + Math.pow(sideB, 2.0));
        currentNode.setHeuristic(diagonal);
    }
    
    private void calculateTotalPathCost(Node currentNode) {
        setTotalPathCost(currentNode.getAccumulatedStepCost() + currentNode.getHeuristic());
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
        if ((currentNode.getCenter().getX() + currentNode.getSize() < mapLenghtX)) {
            currentNode.setRightNeighbour(assignNeighbour((currentNode.getCenter().getX() + (currentNode.getSize() * 2)), currentNode.getCenter().getY()));
        }
    }

    private void setUpNeighbour(Node currentNode) {
        //If (center coordinate of currentNode(y) - size of currentNode(y)) > min(y), we set up neighbour  
        if ((currentNode.getCenter().getY() - currentNode.getSize() > 0)) {
            currentNode.setUpNeighbour(assignNeighbour(currentNode.getCenter().getX(), currentNode.getCenter().getY() - (currentNode.getSize() * 2)));
        }
    }

    private void setDownNeighbour(Node currentNode) {
        //If (center coordinate of currentNode(y) + size of currentNode(y)) < max(y), we set down neighbour  
        if (currentNode.getCenter().getY() + currentNode.getSize() < mapLengthY) {
            currentNode.setDownNeightbour(assignNeighbour(currentNode.getCenter().getX(), currentNode.getCenter().getY() + (currentNode.getSize() * 2)));
        }
    }

    public double getTotalPathCost() {
        return totalPathCost;
    }

    public void setTotalPathCost(double totalPathCost) {
        this.totalPathCost = totalPathCost;
    }

}
