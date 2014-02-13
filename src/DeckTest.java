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
		assertTrue(deck.removeTile(2));
		assertFalse(deck.contains(2));
	}

	@Test
	public void distributionTest() {
		deck.removeTile(2);

		assertFalse(deck.contains(23));
	}
}
