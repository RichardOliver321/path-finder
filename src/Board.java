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

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {

               if ( j % 2 == 0) {
                   boardState[i][j] = new Node();
                   boardState[i][j].traversable = false;
               } else {
                   boardState[i][j] = new Node();
               }
            }
        }
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

    public Node getNode(int x, int y) {
        return boardState[x][y];
    }
}
