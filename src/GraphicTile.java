import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

import javax.swing.JFrame;

public class GraphicTile extends JFrame {

	private int orientation;
	
	public GraphicTile(Tile tile, int orientation) {
		this.orientation = orientation; 
		JFrame frame = new JFrame();
		Image image;
		image = tile.getImage();
	}
	
//    if (image == null) return;
//    AffineTransform transform = AffineTransform.getRotateInstance(Math.toRadians(90),
//          image.getWidth() / 2, image.getHeight() / 2);
//    AffineTransformOp op = new AffineTransformOp(transform,
//          AffineTransformOp.TYPE_BICUBIC);
//    filter(op);
}