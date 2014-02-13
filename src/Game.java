
import javax.swing.JFrame;

public class Game {
	private GUI gui;
	private Scorer scorer;
	private Tile currentTile;
	private Board board;
	public static final int NUM_TILES = 72;

	private Tile[][] tiles = new Tile[NUM_TILES][NUM_TILES];

	private Deck deck;

	public Game() {
		deck = new Deck();
		scorer = new Scorer();
		board = new Board();
		run();
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setGui(GUI gui) {
		this.gui = gui;
		System.out.println("Placing first tile");
		Tile tile = deck.removeRandomTile();
		tiles[tiles.length / 2][tiles.length / 2] = tile;
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
//		return (mouseX + 45) / Tile.SIZE + 33;
		return (mouseX) / Tile.SIZE;
	}

	private int col(int mouseY) {
		return (mouseY) / Tile.SIZE;
	}

	public void mouseClicked(int mouseX, int mouseY) {
		if (inside(mouseX, mouseY)) {
			int x = row(mouseX);
			int y = col(mouseY);
			System.out.println(x + " " + y);
		}
	}

	public boolean inside(int mouseX, int mouseY) {
		return mouseX < GUI.DEFAULT_HEIGHT && mouseY < GUI.DEFAULT_HEIGHT;
	}
}
