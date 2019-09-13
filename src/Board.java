public class Board {
    private int sizeX = 10;
    private int sizeY = 10;

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
    }

    public void setNodeAtLocation(Node node, int x, int y) {
        boardState[x][y] = node;
    }
}
