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

	void drawTile(Tile tile, int numRotation) {
		Image img = new ImageIcon(tile.getImage()).getImage();
		image = new BufferedImage(img.getWidth(null), img.getHeight(null),
				BufferedImage.TYPE_INT_RGB);
		image.getGraphics().drawImage(img, 0, 0, null);

		if (image == null)
			return;
		AffineTransform transform = AffineTransform.getRotateInstance(
				Math.toRadians(90 * numRotation), image.getWidth() / 2,
				image.getHeight() / 2);
		AffineTransformOp op = new AffineTransformOp(transform,
				AffineTransformOp.TYPE_BICUBIC);
		filter(op);

		add(new JComponent() {
			public void paintComponent(Graphics g) {
				if (image != null)
					// g.drawImage(image,
					// Tile.SIZE / 2 - image.getWidth() / 2,
					// Tile.SIZE / 2 - image.getHeight() / 2, null);
					g.drawImage(image, 0, 0, null);
				
			}
			
		});
		repaint();
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

	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.draw(new Line2D.Double(GUI.DEFAULT_HEIGHT, 0, GUI.DEFAULT_HEIGHT,
				GUI.DEFAULT_HEIGHT));

		// int numLines = GUI.DEFAULT_HEIGHT / Game.NUM_TILES;

		// for (int i = 0; i <= Game.NUM_TILES; i++) {
		// g2.draw(new Line2D.Double(i * numLines, 0, i * numLines,
		// GUI.DEFAULT_HEIGHT));
		// g2.draw(new Line2D.Double(0, i * numLines, GUI.DEFAULT_HEIGHT, i
		// * numLines));
		// }
	}

	public Dimension getPreferredSize() {
		return new Dimension(GUI.DEFAULT_WIDTH, GUI.DEFAULT_HEIGHT);
	}
}
