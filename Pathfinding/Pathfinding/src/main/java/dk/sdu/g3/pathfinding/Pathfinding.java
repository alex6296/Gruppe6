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
    private int mapLenghtX = map.getLengthX();
    private int mapLengthY = map.getLengthY();
    private List<Node> nodes = new ArrayList<>();
    private double totalPathCost;
    private static final int STEP_COST = 1;
    private List<Node> openList;
    private List<Node> closedList;
    private List<Coordinate> coordinateList;
    private Node startNode;
    private Node goalNode;
    private Node mostPromising;
    private Node currentNode;

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
        openList = new ArrayList<>();
        closedList = new ArrayList<>();

        createNodes(); //Convert all Coordinates to Nodes
        defineStartNode(start); //Define startNode from nodes
        defineGoalNode(goal); // Define goalNode from nodes

        calculateHeuristic(startNode);
        startNode.setTotalCost(startNode.getHeuristic());
        openList.add(startNode); //Line 1

        while (!openList.isEmpty()) { //Line 2

            Node bestNode = null; //XXXXXX Best node not in use XXXXXXXX
            for (Node node : openList) { //totalCost calcualted
                calculateHeuristic(node);
                node.setTotalCost(node.getAccumulatedStepCost() + node.getHeuristic());
            }
            //Line 3 here!
                //Find node with lowest totalCost (HINT: TotalCost calculated in line 57 (NetBeans))

            if (currentNode.getCenter().equals(goalNode.getCenter())) { //if Node with lowest cost == Goal --> success! (Line 5)
                break; //Return path found
            }

            currentNode = findSuccessor(currentNode); //Line 6

            for (Node successor : currentNode.getNeighbours()) { //(Line 7)
                successor.setAccumulatedStepCost(currentNode.getAccumulatedStepCost() + STEP_COST); //Line 8 // XXXXXXX What is "w" in pseudocode? XXXXXXXXX
                if (openList.contains(successor)) { //Line 9
                    if (successor.getAccumulatedStepCost() <= successor.getTotalCost()) { //Line 10 //Check denne mod pseudo
                        Node tmpNode = currentNode;
                        currentNode = successor;
                        openList.remove(tmpNode);
                        closedList.add(tmpNode); //Line 20
                    }  
                } else if(closedList.contains(successor)) { //Line 11
                    if (successor.getAccumulatedStepCost() <= successor.getTotalCost()) { //Check denne mod pseudo
                        openList.add(successor);        //XXXXXXXXXX Add node to CLOSED List XXXXXXXXXX (Go to psueudo Line 20)
                        closedList.remove(successor);   // - || -
                    }
                } else {
                    openList.add(successor); //Line 15
                    calculateHeuristic(successor); //Line 16
                }
                successor.setAccumulatedStepCost(successor.getTotalCost()); //Line 18
                successor.setParent(currentNode); //Line 19
            }
            closedList.add(currentNode);
        }
        convertNodes(openList);
        
        
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("NO GOAL NODE WAS FOUND");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        
        
        return coordinateList; //Change return
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
            nodes.add(node);
        }
        //Set ajacent nodes right after all nodes has been created in the list
        for (Node node : nodes) {
            setAdjacentNodes(node);
        }
    }

    //Find the most promising Node to move to next
    public Node findSuccessor(Node currentNode) { //XXXXXXXXXXXX Why public? XXXXXXXXXXX
        double lowestCost = Double.MAX_VALUE;
        for (Node node : openList) { //Finding Node with lowest total cost (Line 3+4)
            if (node.getTotalCost() < lowestCost) {
                lowestCost = node.getTotalCost();
                mostPromising = node; //PROBLEM?!?!?!?
            }
        }
        return mostPromising;
    }

    public void addToFringe() {

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

    public double getTotalPathCost() {
        return totalPathCost;
    }

    public void setTotalPathCost(double totalPathCost) {
        this.totalPathCost = totalPathCost;
    }

    private List<Coordinate> convertNodes(List<Node> openList) {
        coordinateList = new ArrayList<Coordinate>();
        //Termination clause might have to be -2 as we don't need goalNode when creating Coordinates between Nodes
        for(int i = 0; i < openList.size() -1; i++) {
            //if X-value is equal in i+1 and i Y-value has changed
            if(openList.get(i).getCenter().getX() == openList.get(i+1).getCenter().getX()) {
                for(int y = openList.get(i).getCenter().getY(); y < openList.get(i+1).getCenter().getY(); y++) {
                    coordinateList.add(new Coordinate(openList.get(i).getCenter().getX(), y));
                }
                //If Y-value is equal in i+1 and i X-value has changed
            } else if(openList.get(i).getCenter().getY() == openList.get(i+1).getCenter().getY()){
                for(int x = openList.get(i).getCenter().getX(); x < openList.get(i+1).getCenter().getX(); x++) {
                    coordinateList.add(new Coordinate(x, openList.get(i).getCenter().getY()));
                }
            }
        }
        return coordinateList;
    }

}
