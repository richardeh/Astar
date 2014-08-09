package heuristics;

/**
 * Created by Richard Harrington on 8/8/2014.
 */
public class ClosestHeuristic implements AstarHeuristic {
    @Override
    public float getEstimatedDistanceToGoal(int startX, int startY, int goalX, int goalY) {
        float dx = goalX - startX;
        float dy = goalY - startY;

        return (float)Math.sqrt((double)(dx*dx)+(dy*dy));
    }
}
