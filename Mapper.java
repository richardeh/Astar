import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Richard Harrington on 8/6/2014.
 */
public class Mapper {
    public static Pathfinder pathfinder;
    public static List<Node> path;
    public static List<Node> nodes;

    /*public static void main(String args[]) {
        nodes = constructList();
        pathfinder = new Pathfinder(nodes);
        Node start = nodes.get(0), finish = nodes.get(90);
        path = pathfinder.find(start, finish);

        if (path != null) {
            System.out.print("Start node: "+start.getID()+" Finish node: "+finish.getID()+"\n");
            String printString = "Final Path\n";
            for (Node n : path) {
                printString += "Node: " + n.getID() + " Coords: x=" + n.getX() + " y=" + n.getY() + "\n";
            }
            System.out.printf(printString);
        } else {
            System.out.print("No path found");
        }
    }

    private static List<Node> constructList(){
        List<Node> nodeList = new ArrayList<Node>();
        int i = 1;

        int[][] blocked = {
                {0, 0, 1, 0, 0, 0, 0, 1, 1, 0},
                {0, 0, 1, 1, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {1, 1, 0, 1, 0, 1, 1, 0, 0, 0},
                {1, 0, 0, 1, 1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
                {0, 1, 0, 1, 1, 1, 0, 0, 0, 0}
        };
        for(int x=1;x<=10;x++){
            for(int y=1;y<=10;y++){
                Node n = new Node(i, x, y, i);
                if(blocked[y-1][x-1]==1){
                    n.setReachable(false);
                } else n.setReachable(true);

                nodeList.add(n);
                i++;
            }
        }

        return nodeList;
    }

    private static Node getNode(){
        Random random = new Random();
        int r = random.nextInt(nodes.size());
        return nodes.get(r).isReachable()?nodes.get(r):getNode();
    }*/
}
