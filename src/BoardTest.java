import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class BoardTest {

	@Test
	public void legalTilePlacementTest() {
		Board board = new Board();
		Tile tile = new Tile(46);
		Tile other = new Tile(46);
		other.rotateClockwise();
		other.rotateClockwise();
		tile.addNeighbor(Tile.NORTH, other);
		assertTrue(board.legalTilePlacement(tile));
	
		other.rotateClockwise();
		tile.addNeighbor(Tile.NORTH, other);
		assertFalse(board.legalTilePlacement(tile));
	}
	
	@Test
	public void legalTilePlacementTest2() {
		Board board = new Board();
		Tile tile = new Tile(0) ;
		Tile other = new Tile(8) ;
		tile.addNeighbor(Tile.EAST, other);
		assertFalse(board.legalTilePlacement(tile));
	}
	
	@Test
	public void placeTileTest() {
		Board board = new Board();
		Tile test = new Tile(17);
		Point point = new Point(71, 72);
		board.placeTile(test, new Point(71, 72));
		assertTrue(board.isTileHere(point));
		assertEquals(test, board.getTileAtLocation(point));
	}
}
