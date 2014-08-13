package unused;

import heuristics.AstarHeuristic;
import heuristics.ClosestHeuristic;

public class AStarTest{
	private static int mapWidth = 20;
	private static int mapHeight = 20;

	private static int[][] obstacles ={{0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
                                        {0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0},
										{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,0,0},
                                        {0,0,0,0,1,1,0,0,1,0,0,0,0,0,0,1,1,0,0,0},
                                        {0,1,1,1,1,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0},
                                        {0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0},
                                        {1,1,1,1,1,1,1,1,0,0,0,0,1,1,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0},
                                        {0,0,0,0,0,0,0,1,1,0,0,0,1,1,1,0,0,0,0,0},
                                        {0,0,0,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
    private static int startX = 0;
    private static int startY = 1;
    private static int goalX =19;
    private static int goalY = 19;

    public static void main(String[] args){
    	/*AreaMap map = new AreaMap(mapWidth, mapHeight, obstacles);
    	AstarHeuristic heuristic = new ClosestHeuristic();
    	Astar pathFinder = new Astar(map, heuristic);

    	pathFinder.calcShortestPath(startX, startY, goalX, goalY);

    	pathFinder.printPath();*/
    }
        
}