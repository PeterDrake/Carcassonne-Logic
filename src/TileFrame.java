
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;

/**
 * This frame has a menu to load an image and to specify various
 * transformations, and a component to show the resulting image.
 */
public class TileFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 90;
	private static final int DEFAULT_HEIGHT = 90;
	private String tileName;
	private int numRotation;

	private BufferedImage image;

	public TileFrame(Tile tile, int numRotation) {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		tileName = tile.getImage();
		this.numRotation = numRotation;

		Image img = new ImageIcon(tileName).getImage();
		image = new BufferedImage(img.getWidth(null), img.getHeight(null),
				BufferedImage.TYPE_INT_RGB);
		image.getGraphics().drawImage(img, 0, 0, null);

		for (int i = 0; i < numRotation; i++) {
			if (image == null)
				return;
			AffineTransform transform = AffineTransform.getRotateInstance(
					Math.toRadians(90), image.getWidth() / 2,
					image.getHeight() / 2);
			AffineTransformOp op = new AffineTransformOp(transform,
					AffineTransformOp.TYPE_BICUBIC);
			filter(op);
		}
		
		add(new JComponent() {
			public void paintComponent(Graphics g) {
				if (image != null)
					g.drawImage(image,
							DEFAULT_WIDTH / 2 - image.getWidth() / 2,
							DEFAULT_HEIGHT / 2 - image.getHeight() / 2, null);
			}
		});
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
