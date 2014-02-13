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
		// meepleImage = new ImageIcon(meepleType).getImage();

		add(new JComponent() {
			public void paintComponent(Graphics g) {
				if (meepleImage != null) {
					g.drawImage(meepleImage, x, y, null);
				}
			}
		});

		// this should be fixed
		// if (player != null) {
		// player.meeple;
		// }

		return -1;
	}

	public boolean legalTilePlacement(Tile tile) {
		int[][] grid = tile.getGrid();
		Tile comparison;
		int[][] comparisonGrid;

		// for(int i = Tile.NORTH; i <= Tile.WEST; i++) {
		comparison = tile.getNeighbor(Tile.NORTH);
		if (comparison != null) {
			comparisonGrid = comparison.getGrid();
			// System.out.println(comparison);
			if (!compareRows(grid[0], comparisonGrid[2]))
				return false;
		}

		comparison = tile.getNeighbor(Tile.EAST);
		if (comparison != null) {
			comparisonGrid = comparison.getGrid();
			// System.out.println(comparison);
			tile.rotateClockwise();
			comparison.rotateClockwise();
			if (!compareRows(grid[0], comparisonGrid[2])) {
				tile.rotateCounterClockwise();
				return false;
			} else
				tile.rotateCounterClockwise();
		}

		comparison = tile.getNeighbor(Tile.SOUTH);
		if (comparison != null) {
			comparisonGrid = comparison.getGrid();
			// System.out.println(comparison);
			if (!compareRows(grid[2], comparisonGrid[0]))
				return false;
		}

		comparison = tile.getNeighbor(Tile.WEST);
		if (comparison != null) {
			comparisonGrid = comparison.getGrid();
			// System.out.println(comparison);
			tile.rotateClockwise();
			comparison.rotateClockwise();
			if (!compareRows(grid[2], comparisonGrid[0])) {
				tile.rotateCounterClockwise();
				return false;
			} else
				tile.rotateCounterClockwise();
		}
		// }
		return true;

	}

	public boolean compareRows(int[] row1, int[] row2) {
		for (int i = 0; i < 3; i++) {
			// System.out.println("row1[" + i + "]:" + row1[i] + " / row2[" + i
			// + "]:" + row2[i]);
			if (row1[i] != row2[i]) {
				return false;
			}
		}
		return true;
	}

}
