import heuristics.AstarHeuristic;
import heuristics.ClosestHeuristic;

import java.lang.reflect.Array;
import java.util.Random;

/**
 * Created by Richard Harrington on 8/13/2014.
 * Generates a random map to test the path-finding algorithm
 */
public class RandomMapTester {
    static Random rand = new Random();

    public static void main(String[] args){

        // Generate the map width and height
        int mapWidth = rand.nextInt(10)+10;
        int mapHeight = rand.nextInt(10)+10;

        // Set the obstacles, start, and end
        int[][] obstacles = createObstacles(mapHeight, mapWidth);
        int[] startPoint = pickPoint(mapWidth,mapHeight, obstacles);
        int[] endPoint = pickPoint(mapWidth, mapHeight, obstacles);

        AreaMap map = new AreaMap(mapWidth, mapHeight, obstacles);
        AstarHeuristic heuristic = new ClosestHeuristic();
        Astar pathFinder = new Astar(map, heuristic);

        pathFinder.calcShortestPath(startPoint[0], startPoint[1], endPoint[0], endPoint[1]);

        pathFinder.printPath();
    }

    private static int[][] createObstacles(int x, int y){
        // creates an obstacle map given the height and width of the map
        int[][] obstacleMap = new int[x][y];

        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                // To change the probable density of obstacles, change the numbers in the comparison here
                obstacleMap[i][j] = rand.nextInt(10)>=7?1:0;
            }
        }

        return obstacleMap;
    }

    private static int[] pickPoint(int mapWidth, int mapHeight,int[][] obstacles){
        // Given the map width and height, returns a pair of coordinates that are unobstructed

        int[] randCoords = new int[2];
        System.out.println("mapwidth: "+mapWidth+" mapheight: "+mapHeight);
        do{
            randCoords[0] = rand.nextInt(mapHeight-1);
            randCoords[1] = rand.nextInt(mapWidth-1);
            System.out.println("x: " + randCoords[0] + "y: " + randCoords[1]);
            System.out.println(obstacles[randCoords[0]].toString());
            System.out.println(obstacles[randCoords[0]][randCoords[1]]);
            if(obstacles[randCoords[0]][randCoords[1]]!=1) return randCoords;
        } while (true);
    }
}
