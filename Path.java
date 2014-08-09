import java.util.ArrayList;

/**
 * Created by Richard Harrington on 8/8/2014.
 */
public class Path {
    private ArrayList<Node> waypoints = new ArrayList<Node>();

    public Path(){

    }

    public int getLength(){
        return waypoints.size();
    }

    public Node getWaypoint(int index){
        return waypoints.get(index);
    }

    public void appendWaypoint(Node node){
        waypoints.add(node);
    }

    public int getX(int index){
        return waypoints.get(index).getX();
    }

    public int getY(int index){
        return waypoints.get(index).getY();
    }

    public void prependWaypoint(Node node){
        waypoints.add(0,node);
    }

    public boolean contains(int x, int y){
        for(Node n:waypoints){
            if(n.getX() == x && n.getY()==y) return true;
        }
        return false;
    }
}
