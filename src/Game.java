
import javax.swing.JFrame;

public class Game {
	private GUI gui;
	private Scorer scorer;
	private Tile currentTile;
	private Board board;
	public static final int NUM_TILES = 72;

	private Tile[][] tiles = new Tile[NUM_TILES][NUM_TILES];

	private int tileCount;

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

	public void mouseClicked(int mouseX, int mouseY) {
		int x = mouseX * Game.NUM_TILES / GUI.DEFAULT_HEIGHT;
		int y = mouseY * Game.NUM_TILES / GUI.DEFAULT_HEIGHT;

		if (inside(x, y)) {
			System.out.println("Placing a tile at (" + x + ", " + y + ")");
		} else {
			if (tileCount == 0) {
				System.out.println("Placing first tile");
				Tile tile = deck.removeRandomTile();
				System.out.println(tile);
				tiles[tiles.length / 2][tiles.length / 2] = tile;
				tileCount++; 
			}
		}
		gui.repaint();
	}

	public boolean inside(int x, int y) {
		return x < NUM_TILES && y < NUM_TILES;
	}
}
