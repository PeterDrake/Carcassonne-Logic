import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;

import javax.swing.*;

/**
 * A component with mouse operations for adding and removing squares.
 */
public class GridComponent extends JComponent {

	private static final int DEFAULT_WIDTH = 90;
	private static final int DEFAULT_HEIGHT = 90;

	private BufferedImage image;

	/**
	 * Apply a filter and repaint.
	 * 
	 * @param op
	 *            the image operation to apply
	 */
	private void filter(BufferedImageOp op) {
		if (image == null)
			return;
		image = op.filter(image, null);
		repaint();
	}

	private Game game;

	public GridComponent(Game game) {
		this.game = game;
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
	}

	private class MouseHandler extends MouseAdapter {
		public void mousePressed(MouseEvent event) {
			Point2D point = event.getPoint();
			int x = (int) point.getX();
			int y = (int) point.getY();
			game.mouseClicked(x, y);
		}

		public void mouseClicked(MouseEvent event) {
		}
	}

	private class MouseMotionHandler implements MouseMotionListener {
		public void mouseMoved(MouseEvent event) {
		}

		public void mouseDragged(MouseEvent event) {
		}
	}
	
	Graphics g;

	public void paintComponent(Graphics g) {
		this.g = g;
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(new Line2D.Double(GUI.DEFAULT_HEIGHT, 0, GUI.DEFAULT_HEIGHT,
				GUI.DEFAULT_HEIGHT));
		System.out.println("called");
		
		Tile[][] tiles = game.getTiles();
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				if (tiles[i][j] != null) {
					g.drawImage(new ImageIcon(tiles[i][j].getFilename()).getImage(), Tile.SIZE * i, Tile.SIZE * j, null);
				}
			}
		}

		// int numLines = GUI.DEFAULT_HEIGHT / Game.NUM_TILES;

		// for (int i = 0; i <= Game.NUM_TILES; i++) {
		// g2.draw(new Line2D.Double(i * numLines, 0, i * numLines,
		// GUI.DEFAULT_HEIGHT));
		// g2.draw(new Line2D.Double(0, i * numLines, GUI.DEFAULT_HEIGHT, i
		// * numLines));
		// }
	}
	
	public void drawTile(Tile t, int rotation) {
		System.out.println(g);
		g.drawImage(new ImageIcon("images/0.jpg").getImage(), 0, 0, null);
	}

	public Dimension getPreferredSize() {
		return new Dimension(GUI.DEFAULT_WIDTH, GUI.DEFAULT_HEIGHT);
	}
}
