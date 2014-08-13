import Utils.Logger;
import heuristics.AstarHeuristic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Richard Harrington on 8/8/2014.
 */
public class Astar {

    private AreaMap map;
    private AstarHeuristic heuristic;
    private ArrayList<Node> closedList;
    private Path shortestPath;
    private SortedNodeList openList;
    private Logger logger;
    
    Astar(AreaMap map, AstarHeuristic heuristic){
        this.map = map;
        this.heuristic = heuristic;
        logger = new Logger();
        closedList = new ArrayList<Node>();
        openList = new SortedNodeList();
        shortestPath = new Path();
    }

    public Path calcShortestPath(int startX, int startY, int goalX, int goalY){
        map.setStartLocation(startX, startY);
        map.setGoalLocation(goalX, goalY);

        if(!map.getNode(goalX, goalY).isReachable()){
            return null;
        }

        map.getStartNode().setDistanceFromStart(0);
        closedList.clear();
        openList.clear();
        openList.add(map.getStartNode());
        map.getStartNode().setDistanceToGoal(map.getDistance(map.getStartNode(),map.getGoalNode()));

        while(openList.size() != 0){
            Node current = openList.getFirst();
            if(current.getX() == map.getGoalLocationX() && current.getY() == map.getGoalLocationY()){
                return constructPath(current);
            }

            openList.remove(current);
            closedList.add(current);

            float currentDistance = current.getDistanceFromStart()+current.getDistanceToGoal();

            for(Node neighbor:current.getAdjacent()){
                boolean neighborIsBetter;
                if(closedList.contains(neighbor))
                    continue;

                if(neighbor.isReachable()){
                    float neighborDistance = map.getDistance(map.getGoalNode(),neighbor)+neighbor.getDistanceFromStart();
                    neighbor.setDistanceFromStart(neighborDistance);
                    neighbor.setDistanceToGoal(heuristic.getEstimatedDistanceToGoal(neighbor.getX(), neighbor.getY(), map.getGoalLocationX(), map.getGoalLocationY()));

                    if(!openList.contains(neighbor)){
                        openList.add(neighbor);
                        neighborIsBetter = true;
                    }else {
                        neighborIsBetter = neighborDistance < (currentDistance + map.getDistance(current, neighbor));
                    }

                    if(neighborIsBetter){
                        neighbor.setParent(current);
                    }

                }
                // printSteps(current);
            }
        }

        return null;

    }
    public void printPath(){
        Node node;
        for(int x=0;x<map.getMapHeight(); x++){
            if(x==0){
                for(int i=0;i<map.getMapWidth();i++){
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.print("|");

            for(int y=0;y<map.getMapWidth();y++){
                node = map.getNode(x,y);
                if(!node.isReachable()){
                    System.out.print("X");
                } else if(node.isStart()){
                    System.out.print("S");
                } else if(node.isGoal()){
                    System.out.print("G");
                } else if(shortestPath.contains(node.getX(),node.getY())){
                    System.out.print("*");
                } else {
                    System.out.print("o");
                }
                if(y==map.getMapWidth())
                    System.out.print("_");
            }
            System.out.print("|");
            System.out.println();
        }
        for(int i=0;i<map.getMapWidth();i++)
            System.out.print("-");
    }

    public void printSteps(Node current){
        // This function used only for tracing progress of the calcShortestPath method
        Node node;
        for(int x=0;x<map.getMapWidth(); x++){
            if(x==0){
                for(int i=0;i<map.getMapWidth();i++){
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.print("|");

            for(int y=0;y<map.getMapHeight();y++){
                node = map.getNode(x,y);
                if(!node.isReachable()){
                    System.out.print("X");
                } else if(node.isStart()){
                    System.out.print("S");
                } else if(node.isGoal()) {
                    System.out.print("G");
                } else if(node.isEqual(current)){
                    System.out.print("C");
                } else if(openList.contains(node)) {
                    System.out.print("p");
                } else if (closedList.contains(node)){
                    System.out.print("x");
                } else {
                    System.out.print("o");
                }
                if(y==map.getMapHeight())
                    System.out.print("_");
            }
            System.out.print("|");
            System.out.println();
        }
        for(int i=0;i<map.getMapWidth();i++)
            System.out.print("-");
    }
    private Path constructPath(Node n){
        Path p = new Path();
        while(n.getParent() != null){
            p.prependWaypoint(n);
            n = n.getParent();
        }
        this.shortestPath = p;
        return this.shortestPath;
    }
    private class SortedNodeList{
        private ArrayList<Node> list = new ArrayList<Node>();

        public Node getFirst(){
            return list.get(0);
        }

        public void clear(){
            list.clear();
        }

        public void add(Node node){
            list.add(node);
            Collections.sort(list);
        }

        public void remove(Node n){
            list.remove(n);
        }

        public int size(){
            return list.size();
        }

        public boolean contains(Node n){
            return list.contains(n);
        }
    }
}
