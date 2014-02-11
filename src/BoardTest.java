import static org.junit.Assert.*;

import org.junit.Test;


public class BoardTest {

	@Test
	public void legalTilePlacementTest() {
		Board board = new Board();
		Tile tile = new Tile(0);
		tile.addNeighbor(Tile.NORTH, new Tile(0));
		assertTrue(board.legalTilePlacement(tile));
	}

}
