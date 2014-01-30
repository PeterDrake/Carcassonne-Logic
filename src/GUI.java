import java.awt.*;
import javax.swing.*;

public class GUI {
	private static final int DEFAULT_WIDTH = 800;
	private static final int DEFAULT_HEIGHT = 600;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				Tile tile = new Tile();
				frame.add(new GraphicTile(tile, 0));
				frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

//public class GraphicTile extends JFrame {
//
//	public GraphicTile(Tile tile, int xCord, int yCord, int orientation) {
//
//		JFrame frame = new JFrame();
//		Image image;
//		image = tile.getImage();
//	}
//
//}
