import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class DeckTest {

	Deck deck;

	@Before
	public void setup() {
		deck = new Deck();
	}

	@Test
	public void deckSizeTest() {
		assertEquals(deck.getSize(), 71);
	}

	@Test
	public void removeAllTilesTest() {
		for (int i = 0; i < 71; i++) {
			deck.removeRandomTile();
		}

		assertTrue(deck.isEmpty());
	}

	@Test
	public void containsEachTileTest() {
		for (int i = 0; i < 24; i++) {
			assertTrue(deck.contains(i));
		}
	}

	@Test
	public void removeSpecificTileTest() {
		Tile tile = new Tile(2);
		assertTrue(deck.contains(2));
		assertEquals(tile.getType(), deck.removeTile(2).getType());
		assertFalse(deck.contains(2));
	}

	@Test
	public void distributionTest() {
		assertEquals(2, deck.removeTile(2).getType());
		assertEquals(4, deck.removeTile(4).getType());
		assertEquals(5, deck.removeTile(5).getType());
		assertEquals(11, deck.removeTile(11).getType());
		assertEquals(23, deck.removeTile(23).getType());
		
		for (int i = 0; i < 2; i++){
			assertEquals(1, deck.removeTile(1).getType());
			assertEquals(6, deck.removeTile(6).getType());
			assertEquals(8, deck.removeTile(8).getType());
			assertEquals(10, deck.removeTile(10).getType());
			assertEquals(12, deck.removeTile(12).getType());
			assertEquals(13, deck.removeTile(13).getType());
		}
		
		for (int i = 0; i < 3; i++){
			assertEquals(3, deck.removeTile(3).getType());
			assertEquals(7, deck.removeTile(7).getType());
			assertEquals(9, deck.removeTile(9).getType());
			assertEquals(14, deck.removeTile(14).getType());
			assertEquals(16, deck.removeTile(16).getType());
			assertEquals(17, deck.removeTile(17).getType());
			assertEquals(18, deck.removeTile(18).getType());
			assertEquals(19, deck.removeTile(19).getType());
		}
		
		for (int i = 0; i < 4; i++){
			assertEquals(0, deck.removeTile(0).getType());
			assertEquals(22, deck.removeTile(22).getType());
			
		}
		
		for (int i = 0; i < 5; i++){
			assertEquals(15, deck.removeTile(15).getType());
		}
		for (int i = 0; i < 8; i++){
			assertEquals(20, deck.removeTile(20).getType());
		}
		for (int i = 0; i < 9; i++){
			assertEquals(21, deck.removeTile(21).getType());
		}	

		for (int i = 0; i < 24; i++){
		assertFalse(deck.contains(i));
		}
	}
}
