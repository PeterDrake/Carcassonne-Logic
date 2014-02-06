import static org.junit.Assert.*;

import org.junit.Test;


public class DeckTest {

	@Test
	public void isEmptyTest() {
		Deck deck = new Deck();
		assertFalse(deck.isEmpty());
	}
	
	@Test
	public void containsTest() {
		Deck deck = new Deck();
		assertTrue(deck.contains(0));
	}

}
