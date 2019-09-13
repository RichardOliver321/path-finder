import java.util.ArrayList;
import java.util.List;

public abstract class PathFindingAlgo {


    public abstract Board solveOneStep(Board board, Node currentNode, Node endNode);

    public abstract Board completeSolve(Board board, Node currentNode, Node endNode);

    protected List<Node> getNeghbours(Node node, Board board) {
        List<Node> adjacentNodes = new ArrayList<>();
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                board.getNode(node.locationX + x, node.locationY + y).ifPresent(adjacentNodes::add);
            }
        }
        return adjacentNodes;
    }

}
