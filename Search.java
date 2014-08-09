import java.util.List;

/**
 * Created by Richard Harrington on 8/8/2014.
 */
public interface Search {
    public List<Node> find(Node start, Node finish);
    public Node selectNode(List<Node> nodes);
    public List<Node> getPath(Node node);
    public List<Node> getAdjacent(Node node);
}
