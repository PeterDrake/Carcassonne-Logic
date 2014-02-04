import java.util.ArrayList;

public class Deck {

	ArrayList<Tile> tiles;

	int size;

	/** a new deck has 72 tiles. */
	static final int DECK_SIZE = 72;

	public Deck() {
		tiles = new ArrayList<Tile>();
	}

	private ArrayList<Tile> createDeck() {

		for (int i = 0; i < 4; i++) {
			addTile(0);
			addTile(22);
		}

		for (int i = 0; i < 2; i++) {
			addTile(1);
			addTile(6);
			addTile(8);
			addTile(10);
			addTile(12);
			addTile(13);

		}

		for (int i = 0; i < 3; i++) {
			addTile(3);
			addTile(7);
			addTile(9);
			addTile(14);
			addTile(16);
			addTile(17);
			addTile(18);
			addTile(19);

		}

		for (int i = 0; i < 5; i++) {
			addTile(15);
		}

		for (int i = 0; i < 8; i++) {
			addTile(20);
		}

		for (int i = 0; i < 9; i++) {
			addTile(21);
		}

		addTile(2);
		addTile(4);
		addTile(5);
		addTile(11);
		addTile(23);

		return tiles;

	}

	private boolean isEmpty() {
		return tiles.isEmpty();
	}

	private int getSize() {
		return tiles.size();
	}

	private Tile removeTile(int i) {
		return tiles.remove(i);
	}

	private Tile removeRandomTile() {
		int r = (int) (getSize() * Math.random());
		return tiles.remove(r);
	}

	private void addTile(int i) {
		tiles.add(new Tile("" + i));
	}

}
