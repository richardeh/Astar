import java.util.ArrayList;

/**
 * Created by Richard H on 8/6/2014.
 * Pretty straight-forward, the Node class stores a two-variable position,
 * and allows the user to set the cost, a parent, and whether the node is reachable.
 */
public class Node implements Comparable<Node>{
    AreaMap map;
    private float costEstimated = Float.MAX_VALUE, costActual = Float.MAX_VALUE;
    private int x,y;
    private Node parent = null;
    private boolean reachable;
    Node north;
    Node south;
    Node east;
    Node west;
    Node northWest;
    Node northEast;
    Node southWest;
    Node southEast;
    ArrayList<Node> adjacent;
    boolean visited, isStart, isGoal;
    float distanceToGoal;
    float distanceFromStart;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
        this.visited = this.isStart = this.isGoal = false;
        this.adjacent = new ArrayList<Node>();
    }

    public Node(int x, int y, float cost){
        this(x,y);
        this.costEstimated = cost;
    }

    public ArrayList<Node> getAdjacent(){ return adjacent;    }

    public float getCostEstimated(){return costEstimated;    }

    public void setCostEstimated(float cost){ this.costEstimated = cost; }

    public float getCostActual(){ return costActual;}

    public void setCostActual(float costActual){ this.costActual = costActual;}

    public int getX(){ return x; }

    public int getY(){ return y; }

    public Node getParent(){ return parent; }

    public void setParent(Node parent){ this.parent = parent; }

    public boolean isReachable(){ return reachable; }

    public void setReachable(boolean reachable){ this.reachable = reachable; }

    public boolean isEqual(Node other){ return (this.getX()==other.getX()&&this.getY()==other.getY()); }

    public Node getSouthEast() { return southEast; }

    public void setSouthEast(Node southEast) {
        this.southEast = southEast;
        adjacent.add(southEast);
    }

    public Node getNorth() { return north; }

    public void setNorth(Node north) {
        this.north = north;
        adjacent.add(north);
    }

    public Node getSouth() { return south; }

    public void setSouth(Node south) {
        this.south = south;
        adjacent.add(south);
    }

    public Node getEast() { return east; }

    public void setEast(Node east) {
        this.east = east;
        adjacent.add(east);
    }

    public Node getWest() { return west; }

    public void setWest(Node west) {
        this.west = west;
        adjacent.add(west);
    }

    public Node getNorthWest() { return northWest; }

    public void setNorthWest(Node northWest) {
        this.northWest = northWest;
        adjacent.add(northWest);
    }

    public Node getNorthEast() { return northEast; }

    public void setNorthEast(Node northEast) {
        this.northEast = northEast;
        adjacent.add(northEast);
    }

    public Node getSouthWest() { return southWest; }

    public void setSouthWest(Node southWest) {
        this.southWest = southWest;
        adjacent.add(southWest);
    }

    public boolean isGoal() { return isGoal; }

    public void setGoal(boolean isGoal) { this.isGoal = isGoal; }

    public boolean isStart() { return isStart; }

    public void setStart(boolean isStart) { this.isStart = isStart; }

    public boolean isVisited() { return visited; }

    public void setVisited(boolean visited) { this.visited = visited; }

    public float getDistanceFromStart() { return distanceFromStart; }

    public void setDistanceFromStart(float distanceFromStart) { this.distanceFromStart = distanceFromStart; }

    public float getDistanceToGoal() { return distanceToGoal; }

    public void setDistanceToGoal(float distanceToGoal) { this.distanceToGoal = distanceToGoal; }

    @Override
    public int compareTo(Node o) {
        float thisTotalDistance = distanceToGoal+distanceFromStart;
        float otherTotalDistance = o.getDistanceToGoal() + o.getDistanceFromStart();

        if(thisTotalDistance < otherTotalDistance){
            return -1;
        } else if(thisTotalDistance > otherTotalDistance){
            return 1;
        } else {
            return 0;
        }
    }
}
