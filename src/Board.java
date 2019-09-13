import java.util.Optional;

public class Board {
    private int sizeX = 10;
    private int sizeY = 10;
    private int cellSize = 20;

    private Node[][] boardState = new Node[sizeX][sizeY];

    public void setBoardSize(int x, int y) {
        sizeX = x;
        sizeY = y;
        initialiseBoard();
    }

    public void reset() {
        initialiseBoard();
    }

    private void initialiseBoard() {
        boardState = new Node[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {

               if ( i % 2 == 0 || j % 2 == 0) {
                   boardState[i][j] = new Node();
                   boardState[i][j].traversable = true;
               } else {
                   boardState[i][j] = new Node();
               }
            }
        }

        //Test starting positions
        boardState[0][0].startingPosition = true;
        boardState[0][0].traversable = true;
        boardState[sizeY-1][sizeX-1].endLocation = true;
        boardState[sizeY-1][sizeX-1].traversable = true;

    }

    public void setNodeAtLocation(Node node, int x, int y) {
        boardState[x][y] = node;
    }

    public Node[][] getBoardState() {
        return boardState;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public Optional<Node> getNode(int x, int y) {
        if(x >= getSizeX() || x < 0 || y >= getSizeY() || y < 0)
            return Optional.empty();
        return Optional.of(boardState[x][y]);
    }

    public int getCellSize() {
        return cellSize;
    }
}
