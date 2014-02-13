import java.awt.Point;

import javax.swing.JFrame;

public class Game {
	private GUI gui;
	private Scorer scorer;
	private Tile currentTile;
	private Board board;
	public static final int NUM_TILES = 144;

	// private Tile[][] tiles = new Tile[NUM_TILES][NUM_TILES];

	private Deck deck;

	public Game() {
		deck = new Deck();
		scorer = new Scorer();
		board = new Board();
		run();
	}

	// public Tile[][] getTiles() {
	// return tiles;
	// }

	public void setGui(GUI gui) {
		this.gui = gui;
		System.out.println("Placing first tile");
		Tile tile = deck.removeRandomTile();
		// tiles[tiles.length / 2][tiles.length / 2] = tile;
		board.placeTile(tile, new Point(NUM_TILES / 2, NUM_TILES / 2));
	}

	public Board getBoard() {
		return board;
	}

	private void run() {
		if (deck.isEmpty()) {
			this.stop();
		}
	}

	private void stop() {
		// TODO
		// will initiate endgame scoring
	}

	private int row(int mouseX) {
		return mouseX / Tile.SIZE;
		// return (2 * Game.NUM_TILES * mouseX) / ((2 * GUI.DEFAULT_HEIGHT) -
		// (Tile.SIZE * Game.NUM_TILES));
	}

	private int col(int mouseY) {
		// return (2 * Game.NUM_TILES * mouseY) / ((2 * GUI.DEFAULT_HEIGHT) -
		// (Tile.SIZE * Game.NUM_TILES));
		return mouseY / Tile.SIZE;
	}

	public void mouseClicked(int mouseX, int mouseY) {
		if (inside(mouseX, mouseY)) {
			int x = row(mouseX);
			int y = col(mouseY);
			System.out.println(x + " " +y);
			board.placeTile(deck.removeRandomTile(), new Point(x + 33, y + 33));
			gui.repaint();
		}
	}

	public boolean inside(int mouseX, int mouseY) {
		return mouseX < GUI.DEFAULT_HEIGHT && mouseY < GUI.DEFAULT_HEIGHT;
	}
}
