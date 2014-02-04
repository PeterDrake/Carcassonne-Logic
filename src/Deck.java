
public class Deck {

	Tile[] tiles;
	
	int size;
	
	public Deck() {
		tiles = createDeck();
	}

	private Tile[] createDeck() {
	
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
		return getSize() == 0;
	}
	
	private int getSize() {
		return  size;
	}

	private Tile removeTile(int i) {
		size--;
		return null;
	}
	
	private Tile removeTile() {
//		Tile 
//		size--;
		return null;
		
	}

	private void addTile(int i) {
		tiles[size++] = new Tile("" + i);
	}
	
	private void shuffleDeck() {
		
	}
	
	
	
}

