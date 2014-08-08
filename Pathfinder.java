import java.util.ArrayList;
import java.util.List;

/**
 * Created by Richard H on 8/6/2014.
 */
public class Pathfinder {
    private List<Node> reachable = new ArrayList<Node>();
    private List<Node> visited = new ArrayList<Node>();
    private List<Node> allNodes = new ArrayList<Node>();

    public Pathfinder(List<Node> nodes){
        allNodes = nodes;
    }

    public List<Node> find(Node start, Node finish){
        reachable.add(start);
        int distance = Math.abs(start.getX()+finish.getX())+Math.abs(start.getY()+finish.getY());

        while(!reachable.isEmpty()){
            Node node = selectNode(reachable, distance);
            if(node.isEqual(finish)){
                return getPath(node);
            }

            reachable.remove(node);
            visited.add(node);
            List<Node> adjacent = getAdjacent(node);

            if(!adjacent.isEmpty()) {
                for (Node n : adjacent) {
                    if (!reachable.contains(n)&&!visited.contains(n)) {
                        reachable.add(n);
                    }
                    if (node.getCost() + 1 <= n.getCost()) {

                        n.setParent(node);
                        n.setCost(node.getCost() + 1);
                    }
                }
            }
        }

        return null;
    }

    public Node selectNode(List<Node> nodes, int distance){
        int minCost = Integer.MAX_VALUE;
        Node bestNode = null;
        int costToStart = 0, totalCost = 0;

        for(Node n:nodes){
            costToStart = n.getCost();
            totalCost = costToStart+distance;

            if(minCost>totalCost){
                minCost = totalCost;
                bestNode = n;
            }
        }
        return bestNode;
    }

    public List<Node> getPath(Node node){
        List<Node> path = new ArrayList<Node>();

        while(node != null){
            path.add(node);
            node = node.getParent();
        }
        return path;
    }

    public List<Node> getAdjacent(Node node){
        // From the list of all nodes, find those that are adjacent to the given node
        // TODO: find a way to take the coordinates of a given node, and see if
        // a node exists at the adjacent coordinates

        int nodeX, x = node.getX();
        int nodeY, y = node.getY();
        List<Node> adj = new ArrayList<Node>();

        for(Node n:allNodes){
            if(n.isReachable()) {
                nodeX = n.getX();
                nodeY = n.getY();
                if ((Math.abs(nodeX - x) == 1 && nodeY == y) || (nodeX == x && Math.abs(nodeY - y) == 1)) {
                    adj.add(n);
                }
            }
        }

        return adj;
    }

}
