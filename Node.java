/**
 * Created by Richard H on 8/6/2014.
 */
public class Node {
    private int cost = Integer.MAX_VALUE;
    private int x,y;
    private Node parent = null;
    private boolean reachable=false;
    private int id;

    public Node(int id, int x, int y){
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public Node(int id, int x, int y, int cost){
        this(id,x,y);
        this.cost = cost;
    }

    public Node(int id, int x, int y, int cost, Node parent){
        this(id,x,y,cost);
        this.parent = parent;
    }

    public int getCost(){
        return cost;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Node getParent(){
        return parent;
    }

    public void setParent(Node parent){
        this.parent = parent;
    }

    public boolean isReachable(){
        return reachable;
    }

    public void setReachable(boolean reachable){
        this.reachable = reachable;
    }

    public boolean isEqual(Node other){
        if(this.getX()==other.getX()&&this.getY()==other.getY()) return true;
        return false;
    }

    public int getID(){
        return id;
    }
}
