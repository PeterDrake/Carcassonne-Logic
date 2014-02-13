import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

import javax.swing.*;

/**
 * This frame has a menu to load an image and to specify various
 * transformations, and a component to show the resulting image.
 */
public class TileComponent extends JComponent {
	private static final int DEFAULT_WIDTH = 90;
	private static final int DEFAULT_HEIGHT = 90;

	private BufferedImage image;
	private int rotation;
	private Image img;
	private int width, height;
	private int x, y;

	public TileComponent(Tile tile, int rotation, int x, int y) {
		width = DEFAULT_WIDTH;
		height = DEFAULT_HEIGHT;

		img = new ImageIcon(tile.getImage()).getImage();
		image = new BufferedImage(img.getWidth(null), img.getHeight(null),
				BufferedImage.TYPE_INT_RGB);

		this.rotation = rotation;
		this.x = x;
		this.y = y;
	}

	public void paintComponent(Graphics g) {
		if (image == null)
			return;

		// draw the image in the upper-left corner
		image.getGraphics().drawImage(img, 0, 0, null);

		if (image == null)
			return;
		AffineTransform transform = AffineTransform.getRotateInstance(
				Math.toRadians(90 * rotation), image.getWidth() / 2,
				image.getHeight() / 2);
		AffineTransformOp op = new AffineTransformOp(transform,
				AffineTransformOp.TYPE_BICUBIC);
		filter(op);

		g.drawImage(image, x, y, null);
	}

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

}
