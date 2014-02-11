import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Board extends JFrame {
	Image meepleImage;
	int x, y;

	// takes in an x & y cordinate from a mouseclick, places meeple where
	// clicked
	public int placeMeeple(int[] location, Player player, int type) {
		String meepleType;
		Color color = java.awt.Color.WHITE;
		x = location[0];
		y = location[1];
		
		if (player != null) {
			color = player.getColor();
		}
		switch (type) {
		case 0:
			meepleType = color + "Farmer.png";
		case 1:
			meepleType = color + "Thief.png";
		case 3:
			meepleType = color + "Knight.png";
		case 4:
			meepleType = color + "Monk.png";
		}
		// draw meeple using information from specific case and coordinates
		// taken in
//		meepleImage = new ImageIcon(meepleType).getImage();

		add(new JComponent() {
			public void paintComponent(Graphics g) {
				if (meepleImage != null) {
					g.drawImage(meepleImage, x, y, null);
				}
			}
		});

		// this should be fixed
//		if (player != null) {
//			player.meeple;
//		}

		return -1;
	}

}
