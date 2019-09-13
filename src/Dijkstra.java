import java.util.List;

public class Dijkstra extends PathFindingAlgo {

    @Override
    public Board solveOneStep(Board board, Node currentNode, Node endNode) {
        List<Node> neighbors = getNeghbours(currentNode, board);

        return null;
    }

    @Override
    public Board completeSolve(Board board, Node currentNode, Node endNode) {
        while (currentNode != endNode)
            solveOneStep(board, currentNode, endNode);

        return board;
    }
}
