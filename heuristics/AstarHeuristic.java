package heuristics;

/**
 * Created by Richard Harrington on 8/8/2014.
 */
public interface AstarHeuristic {
    public float getEstimatedDistanceToGoal(int startX, int startY, int goalX, int goalY);
}
