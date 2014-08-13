import java.util.ArrayList;

/**
 * Created by Richard Harrington on 8/8/2014.
 */
public class AreaMap {
    private int mapWidth,mapHeight;
    private ArrayList<ArrayList<Node>> map;
    private int startLocationX = 0, startLocationY = 0;
    private int goalLocationX = 0, goalLocationY = 0;
    private int[][] obstacles;

    AreaMap(int mapWidth, int mapHeight, int[][] obstacles){
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.obstacles = obstacles;

        createMap();
        registerEdges();
    }

    private void createMap(){
        Node node;
        map = new ArrayList<ArrayList<Node>>();
        for(int x=0;x<mapHeight;x++){
            map.add(new ArrayList<Node>());
            for(int y=0;y<mapWidth;y++){
                node = new Node(x,y);
                if(obstacles[x][y]==1) {
                    node.setReachable(false);
                } else{
                    node.setReachable(true);
                }
                map.get(x).add(node);
            }
        }
    }

    private void registerEdges(){
        for(int x=0;x<mapHeight;x++){
            for(int y=0;y<mapWidth;y++){
                Node node = map.get(x).get(y);
                if(x!=0) node.setNorth(map.get(x-1).get(y));
                if(x!=0 && y!=mapWidth-1) node.setNorthEast(map.get(x-1).get(y+1));
                if(y!=mapWidth-1) node.setEast(map.get(x).get(y+1));
                if(x!=mapHeight-1 && y!=mapWidth-1) node.setSouthEast(map.get(x+1).get(y+1));
                if(x!=mapHeight-1) node.setSouth(map.get(x+1).get(y));
                if(y!=0 && x!=mapHeight-1) node.setSouthWest(map.get(x+1).get(y-1));
                if(y!=0) node.setWest(map.get(x).get(y-1));
                if(x!=0 && y!=0) node.setNorthWest(map.get(x-1).get(y-1));
            }
        }
    }

    public ArrayList<ArrayList<Node>> getNodes(){
        return map;
    }
    public void setObstacle(int x, int y, boolean isObstacle){
        map.get(x).get(y).setReachable(!isObstacle);
    }

    public Node getNode(int x, int y){
        return map.get(x).get(y);
    }

    public void setStartLocation(int x, int y){
        map.get(startLocationX).get(startLocationY).setStart(false);
        map.get(x).get(y).setStart(true);
        startLocationX = x;
        startLocationY = y;
    }

    public void setGoalLocation(int x, int y){
        map.get(goalLocationX).get(goalLocationY).setGoal(false);
        map.get(x).get(y).setGoal(true);
        goalLocationX = x;
        goalLocationY = y;
    }

    public int getStartLocationX(){
        return startLocationX;
    }

    public int getStartLocationY(){
        return startLocationY;
    }

    public Node getStartNode(){
        return map.get(startLocationX).get(startLocationY);
    }

    public int getGoalLocationX(){
        return goalLocationX;
    }

    public int getGoalLocationY(){
        return goalLocationY;
    }

    public Node getGoalNode(){
        return map.get(goalLocationX).get(goalLocationY);
    }

    public float getDistance(Node node1, Node node2){
        float dx = Math.abs(node1.getX()-node2.getX())+1;
        float dy = Math.abs(node1.getY()-node2.getY())+1;

        return (float)Math.sqrt((double)(dx*dx)+(dy*dy));
    }

    public int getMapWidth(){
        return mapWidth;
    }

    public int getMapHeight(){
        return mapHeight;
    }

    public void clear(){
        startLocationX = 0;
        startLocationY = 0;
        goalLocationX = 0;
        goalLocationY = 0;
        createMap();
        registerEdges();
    }

}
