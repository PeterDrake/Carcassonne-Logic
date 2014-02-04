import java.awt.*;

import javax.swing.*;

/**
 * This program demonstrates various image processing operations.
 * 
 * @version 1.03 2007-08-16
 * @author Cay Horstmann
 */
public class GUI {
	
	static JFrame frame = new JFrame();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Tile tile = new Tile("0");
//				JFrame frame = new JFrame();
				frame.setSize(600, 600);
				frame.setTitle("Carcassonne");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(new TileFrame(tile, 3));
				Board board = new Board() ;
				updateScore(board);
				frame.setVisible(true);
			}
		});
	}
	
	public static void updateScore(final Board board) {
		frame.add(new JComponent() {
			public void paintComponent(Graphics g) {
				g.drawString(board.getScore(), 0, 15);
			}
		});
	}

}