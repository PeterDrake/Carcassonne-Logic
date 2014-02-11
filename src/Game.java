public class Game {
	private GUI gui;
	private Scorer scorer;
	private Tile currentTile;
	private Board board;
	public static final int NUM_TILES = 72;

	private Tile[][] tiles = new Tile[NUM_TILES][NUM_TILES];

	private int tileCount;

	// private static final int BOARD_SIZE = Game.NUM_TILES * Tile.SIZE;

    private Deck deck;
    
    public Game() {
    	deck = new Deck();
    	scorer = new Scorer();
    	gui = new GUI(this);
    	board = new Board();
    	run();
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
			// place a tile on the board
			System.out.println("Place tile: " + x + ", " + y);
		} else {
			if (tileCount == 0) {
				Tile tile = deck.removeRandomTile();
				tiles[tiles.length/2][tiles.length/2] = tile;
				tileCount++;
//				gui.gridComponent.drawTile(tile, 0);
				gui.add(new TileComponent(tile, 0));
				gui.repaint();
			}
			// we are picking a tile from the pile, we set currentTile
			System.out.println("Pick up a tile.");
		}
	}

	public boolean inside(int x, int y) {
		return x < NUM_TILES && y < NUM_TILES;
	}
}
