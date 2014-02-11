import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	@Test
	public void legalTilePlacementTest() {
		Board board = new Board();
		Tile tile = new Tile(46);
		Tile other = new Tile(46);
		
		System.out.println(other);
		
		other.rotateClockwise();
		other.rotateClockwise();
		
		tile.addNeighbor(Tile.NORTH, other);
		assertTrue(board.legalTilePlacement(tile));
		
		other.rotateClockwise();
		tile.addNeighbor(Tile.NORTH, other);
		assertFalse(board.legalTilePlacement(tile));
	}

}
