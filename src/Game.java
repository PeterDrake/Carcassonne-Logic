
public class Game {
    private GUI gui;
    private Board board;
    private Scorer scorer;
    private Tile currentTile;
    
    public Game() {
        gui = new GUI(this);
    }
    
    public void mouseClicked(int x, int y) {
        System.out.println("Mouse clicked: " + x + ", " + y);
    }
}
