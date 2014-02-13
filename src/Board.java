import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Point;

public class Board extends JFrame {
	
	private Point last;
	private Tile[][] table;
	
	public static final int MAX_SIZE = 143;
	public static final int MIDDLE = 72;
	
	public Tile[][] getTable() {
		return table;
	}
	
	public Board() {
		table = new Tile[MAX_SIZE][MAX_SIZE];
		table[MIDDLE][MIDDLE] = new Tile(24);
	}
	
	public Tile getTileAtLocation(Point point) {
		return table[point.x][point.y];
	}

	
	public void placeTile(Tile tile, Point point) {
		if(isTileHere(new Point(point.x, point.y + 1)))
			tile.addNeighbor(0, table[point.x][point.y + 1]);
		if(isTileHere(new Point(point.x + 1, point.y)))
			tile.addNeighbor(1, table[point.x + 1][point.y]);
		if(isTileHere(new Point(point.x, point.y - 1)))
			tile.addNeighbor(2, table[point.x][point.y - 1]);
		if(isTileHere(new Point(point.x - 1, point.y)))
			tile.addNeighbor(3, table[point.x - 1][point.y]);
		
		if(legalTilePlacement(tile)) {
			table[point.x][point.y] = tile;
		} else {
			tile.removeNeighbors();
		}
	}
	
	public boolean isTileHere(Point point) {
		if(table[point.x][point.y] != null)
			return true;
		return false;
	}
	
	// takes in an x & y cordinate from a mouseclick, places meeple where
	// clicked
	public int placeMeeple(int[] location, Player player, int type) {
		Image meepleImage;
		int x, y;
		String meepleType;
		Color color = java.awt.Color.WHITE;
		x = location[0];
		y = location[1];

		if (player != null) {
			//color = player.color;
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

		// meepleImage = new ImageIcon(meepleType).getImage();

//		add(new JComponent() {
//			public void paintComponent(Graphics g) {
//				if (meepleImage != null) {
//					g.drawImage(meepleImage, x, y, null);
//				}
//			}
//		});

		// this should be fixed

		// if (player != null) {
		// player.meeple;
		// }

		return -1;
	}

	public boolean legalTilePlacement(Tile tile) {
		Tile comparison;

		//north
		comparison = tile.getNeighbor(Tile.NORTH);
		if (comparison != null)
			if(!(tile.getGridLocation(0, 1) == comparison.getGridLocation(2, 1)))
				return false;

		//east
		comparison = tile.getNeighbor(Tile.EAST);
		if (comparison != null) {
			if(!(tile.getGridLocation(1, 2) == comparison.getGridLocation(1, 0)))
				return false;
		}

		//south
		comparison = tile.getNeighbor(Tile.SOUTH);
		if (comparison != null)
			if(!(tile.getGridLocation(2, 1) == comparison.getGridLocation(0, 1)))
				return false;

		//west
		comparison = tile.getNeighbor(Tile.WEST);
		if (comparison != null)
			if(!(tile.getGridLocation(1, 0) == comparison.getGridLocation(1, 2)))
				return false;

		return true;
		
	}

	public boolean compareRows(int row1, int row2) {
		for (int i = 0; i < 3; i++) {
			if (row1 != row2) {
				return false;
			}
		}
		return true;
	}

}
