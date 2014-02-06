
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Board extends JFrame {
	Image meepleImage;
	int x, y, numPlayers;
	private Player player[];

	public void Board(){
		
	}

	// takes in an x & y cordinate from a mouseclick, places meeple where
	// clicked
	public int placeMeeple(int[] location, Player player, int type) {
		String meepleType;
		String color = "translucent";
		x = location[0];
		y = location[1];
		
		if (player != null) {
			color = player.color;
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
		meepleImage = new ImageIcon(meepleType).getImage();

		add(new JComponent() {
			public void paintComponent(Graphics g) {
				if (meepleImage != null) {
					g.drawImage(meepleImage, x, y, null);
				}
			}
		});

		// this should be fixed
		if (player != null) {
			player.meeple--;
		}

		return -1;
	}
	
	public String getScore() {
		String score = "";
		for (int i = 0; i < numPlayers; i++) {
			score += " Player " + (i + 1) + ": " + player[i].getScore() + "   ";
		}
		return score;
	}

}
