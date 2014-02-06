public class Game {
    private GUI gui;
    private Board board;
    private Scorer scorer;
    private Tile currentTile;
    public static final int NUM_TILES = 72;
    private static final int BOARD_SIZE = Game.NUM_TILES * Tile.SIZE;

    public Game() {
        gui = new GUI(this);
    }

    public void mouseClicked(int mouseX, int mouseY) {
        int x = mouseX * Game.NUM_TILES / GUI.DEFAULT_HEIGHT;
        int y = mouseY * Game.NUM_TILES / GUI.DEFAULT_HEIGHT;

        if (inside(x, y)) {
            // place a tile on the board
            System.out.println("Place tile: " + x + ", " + y);
        } else {
            // we are picking a tile from the pile, we set currentTile
            System.out.println("Pick up a tile.");
        }
    }

    public boolean inside(int x, int y) {
        return x < NUM_TILES && y < NUM_TILES;
    }
}
