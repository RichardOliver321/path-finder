public class Board {
    private int sizeX = 10;
    private int sizeY = 10;

    private Node[][] boardState = new Node[sizeX][sizeY];

    public void setBoardSize(int x, int y) {
        sizeX = x;
        sizeY = y;
    }

    public void reset() {
        boardState = new Node[sizeX][sizeY];
    }

    public void setNodeAtLocation(Node node, int x, int y) {
        boardState[x][y] = node;
    }
}
