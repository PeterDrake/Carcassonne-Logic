
public class Game {
    private GUI gui;
    private Board board;
    private Scorer scorer;
    private Deck deck;
    
    public Game() {
    	deck = new Deck();
    	scorer = new Scorer();
    	gui = new GUI();
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
}
