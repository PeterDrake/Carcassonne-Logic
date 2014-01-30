import java.awt.Image;

import javax.swing.ImageIcon;


public class Tile {
    public static enum Zone {ROAD, GRASS, CITY, CLOISTER, ROAD_ENDPOINT}

	public Image getImage() {
		Image image = new ImageIcon("kitten.jpg").getImage();
		return image;
	};
}
