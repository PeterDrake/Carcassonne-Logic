public class Game {
    private GUI gui;
    private Board board;
    private Scorer scorer;
    private Tile currentTile;
    private static final int NUM_TILES = 72;
    private static final int BOARD_SIZE = Game.NUM_TILES * Tile.SIZE;

    public Game() {
        gui = new GUI(this);
    }

    public void mouseClicked(int x, int y) {
        if (inside(x, y)) {
            // place a tile on the board
        }
        
        // else if we are picking a tile from the pile, we set currentTile
        System.out.println("Mouse clicked: " + x + ", " + y);
    }

    public boolean inside(int x, int y) {
        return x < BOARD_SIZE && y < BOARD_SIZE;
    }
}
