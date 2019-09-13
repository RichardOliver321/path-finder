import javax.swing.*;
import java.awt.*;

public class PathFinder extends Canvas {

    private Board boardState;

    public PathFinder(Board board) {
        boardState = board;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Drawing");


        Board board = new Board();
        board.setBoardSize(10, 10);
        Canvas canvas = new PathFinder(board);

        canvas.setSize(board.getSizeX() * board.getCellSize(), board.getSizeY() * board.getCellSize());
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }


    public void paint(Graphics g) {
        for (int x = 0; x < boardState.getSizeX(); x++) {
            for (int y = 0; y < boardState.getSizeY(); y++) {
                if (boardState.getNode(x, y).isPresent() && boardState.getNode(x, y).get().traversable)
                    g.setColor(Color.BLACK);
                else
                    g.setColor(Color.MAGENTA);
                if (boardState.getNode(x, y).isPresent() && boardState.getNode(x, y).get().startingPosition)
                    g.setColor(Color.green);
                if (boardState.getNode(x, y).isPresent() && boardState.getNode(x, y).get().endLocation)
                    g.setColor(Color.red);


                g.fillRect(x * boardState.getCellSize(), y * boardState.getCellSize(), boardState.getCellSize(), boardState.getCellSize());
            }
        }
    }

}