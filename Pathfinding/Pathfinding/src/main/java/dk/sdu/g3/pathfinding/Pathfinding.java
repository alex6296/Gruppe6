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
    private final int mapLenghtX = map.getLengthX();
    private final int mapLengthY = map.getLengthY();
    private static final int STEP_COST = 1;
    private List<Node> nodes = new ArrayList<>();
    private List<Node> openList;
    private List<Node> closedList;
    private List<Coordinate> coordinateList;
    private Node startNode;
    private Node goalNode;

    public Pathfinding() {
    }

    //TODO
//    @Override
//    public Coordinate getNextCoordinate(Coordinate currentCoord) {
//        //-1 in case of false return of -1
//        List<Coordinate> coords = generatePath(map, startNode.getCenter(), goalNode.getCenter());
//        int coordIndex = -2;
//        if (currentCoord != goalNode.getCenter()) {
//            for (int i = 0; i <= coordinateList.size(); i++) {
//                if (currentCoord.getX() == coordinateList.get(i).getX()) {
//                    if (currentCoord.getY() == coordinateList.get(i).getY()) {
//                        coordIndex = i;
//                    }
//                }
//            }
//            return coordinateList.get(coordIndex + 1);
//        }
//        return null;
//    }

    //TODO
    @Override
    public List<Coordinate> generatePath(IMap map, Coordinate start, Coordinate goal) {
        openList = new ArrayList<>();
        closedList = new ArrayList<>();
        Node currentNode = null;

        createNodes(); //Convert all Coordinates to nodes
        defineStartNode(start); //Define startNode from nodes
        defineGoalNode(goal); // Define goalNode from nodes

        calculateHeuristic(startNode);
        calculateTotalPathCost(startNode);
        openList.add(startNode); //Line 1

        while (!openList.isEmpty()) { //Line 2
            currentNode = openList.get(0);

            for (Node node : openList) { //totalCost calcualted
                calculateHeuristic(node);
                calculateTotalPathCost(node);
                if (node.getTotalCost() < currentNode.getTotalCost()) {
                    currentNode = node;
                }
            }

            if (currentNode.getCenter().equals(goalNode.getCenter())) { //if Node with lowest cost == Goal --> success! (Line 5)
                closedList.add(currentNode);
                convertNodes(closedList);

                return coordinateList; //Changed return
            }

            setAdjacentNodes(currentNode); //Line 6 //find all seccessorNodes

            for (Node successor : currentNode.getNeighbours()) { //(Line 7)
                double successorCurrentCost = currentNode.getAccumulatedStepCost() + STEP_COST; //Line 8 // XXXXXXX What is "w" in pseudocode? XXXXXXXXX
                if (openList.contains(successor)) { //Line 9
                    if (successor.getAccumulatedStepCost() <= successorCurrentCost) { //Line 10
                        closedList.add(currentNode); //Line 20
                    }
                } else if (closedList.contains(successor)) { //Line 11
                    if (successor.getAccumulatedStepCost() <= successorCurrentCost) { //Check denne mod pseudo
                        closedList.add(currentNode);
                    } else {
                        openList.add(successor);
                        closedList.remove(successor);
                    }
                } else {
                    openList.add(successor); //Line 15
                    calculateHeuristic(successor); //Line 16
                }
                successor.setAccumulatedStepCost(successorCurrentCost); //Line 18
                successor.setParent(currentNode); //Line 19
            }
            closedList.add(currentNode);
        }
        if (currentNode != goalNode) {
            return null; //<- Insert exception handeling here
        }
        return null;
    }

    private void defineGoalNode(Coordinate goal) {
        goalNode = null;
        for (Node node : nodes) {
            if (node.getCenter().equals(goal)) {

            }
        }
    }

    private void defineStartNode(Coordinate start) {
        startNode = null;
        for (Node node : nodes) {
            if (node.getCenter().equals(start)) {
                startNode = node;
            }
        }
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
            //If Node has tower placed i.e. isBlocked -> no use for it (No need to add)
            if (!node.isBlocked()) {
                nodes.add(node);
            }
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
        int sideA = (goalNode.getCenter().getX() - currentNode.getCenter().getX());
        int sideB = (goalNode.getCenter().getY() - currentNode.getCenter().getY());
        double diagonal = Math.sqrt(Math.pow(sideA, 2.0) + Math.pow(sideB, 2.0));
        currentNode.setHeuristic(diagonal);
    }

    private void calculateTotalPathCost(Node currentNode) {
        currentNode.setTotalCost(currentNode.getAccumulatedStepCost() + currentNode.getHeuristic());
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
            if (assignNeighbour((currentNode.getCenter().getX() - (currentNode.getSize() * 2)), currentNode.getCenter().getY()) != null) {
                currentNode.addNeighbour(assignNeighbour((currentNode.getCenter().getX() - (currentNode.getSize() * 2)), currentNode.getCenter().getY()));
            }
        }
    }

    private void setRightNeighbour(Node currentNode) {
        //If (center coordinate of currentNode(x) + size of currentNode(x) < max(x), we set right neighbour
        if ((currentNode.getCenter().getX() + currentNode.getSize() < mapLenghtX)) {
            if (assignNeighbour((currentNode.getCenter().getX() + (currentNode.getSize() * 2)), currentNode.getCenter().getY()) != null) {
                currentNode.addNeighbour(assignNeighbour((currentNode.getCenter().getX() + (currentNode.getSize() * 2)), currentNode.getCenter().getY()));
            }
        }
    }

    private void setUpNeighbour(Node currentNode) {
        //If (center coordinate of currentNode(y) - size of currentNode(y)) > min(y), we set up neighbour  
        if ((currentNode.getCenter().getY() - currentNode.getSize() > 0)) {
            if (assignNeighbour(currentNode.getCenter().getX(), currentNode.getCenter().getY() - (currentNode.getSize() * 2)) != null) {
                currentNode.addNeighbour(assignNeighbour(currentNode.getCenter().getX(), currentNode.getCenter().getY() - (currentNode.getSize() * 2)));
            }
        }
    }

    private void setDownNeighbour(Node currentNode) {
        //If (center coordinate of currentNode(y) + size of currentNode(y)) < max(y), we set down neighbour  
        if (currentNode.getCenter().getY() + currentNode.getSize() < mapLengthY) {
            if (assignNeighbour(currentNode.getCenter().getX(), currentNode.getCenter().getY() + (currentNode.getSize() * 2)) != null) {
                currentNode.addNeighbour(assignNeighbour(currentNode.getCenter().getX(), currentNode.getCenter().getY() + (currentNode.getSize() * 2)));
            }
        }
    }

    private List<Coordinate> convertNodes(List<Node> openList) {
        coordinateList = new ArrayList<Coordinate>();
        //Termination clause might have to be -2 as we don't need goalNode when creating Coordinates between Nodes
        for (int i = 0; i < openList.size() - 1; i++) {
            //initializing variables to avoid calling openList too much...
            int currentX = closedList.get(i).getCenter().getX();
            int currentY = closedList.get(i).getCenter().getY();
            int nextX = closedList.get(i + 1).getCenter().getX();
            int nextY = closedList.get(i + 1).getCenter().getY();

            //if X-value is equal in i+1 then i Y-value has changed
            if (currentX == nextX) {
                //Check if target coordinate is higher or lower value than current coordinate
                if (currentY > nextY) {
                    for (int y = currentY; y > nextY; y--) {
                        coordinateList.add(new Coordinate(currentX, y));
                    }
                } else {
                    for (int y = currentY; y < nextY; y++) {
                        coordinateList.add(new Coordinate(currentX, y));
                    }
                }
                //If Y-value is equal in i+1 and i X-value has changed
            } else if (currentY == nextY) {
                //Check if target coordinate is higher or lower value than current coordinate
                if (currentX > nextX) {
                    for (int x = currentX; x > nextX; x--) {
                        coordinateList.add(new Coordinate(x, currentY));
                    }
                } else {
                    for (int x = currentX; x < nextX; x++) {
                        coordinateList.add(new Coordinate(x, currentY));
                    }
                }

            }
        }
        return coordinateList;
    }

}
