import javax.swing.*;
import java.awt.*;

public class PathFinder extends Canvas {

    Board boardState;

    public PathFinder(Board board) {
        boardState = board;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Drawing");


        Board board = new Board();
        board.setBoardSize(10, 10);
        Canvas canvas = new PathFinder(board);

        canvas.setSize(board.getSizeX() * 10, board.getSizeY() * 10);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);

    }


    public void paint(Graphics g) {
        int nodeSize = 200;
        for (int i = 0; i < boardState.getSizeX(); i++) {
            for (int j = 0; j < boardState.getSizeY(); j++) {
                if(boardState.getNode(i,j).traversable)
                    g.fillRect(i, j, nodeSize, nodeSize);
            }
        }
    }

}