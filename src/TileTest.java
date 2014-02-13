import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TileTest {

	@Before
	public void setup() {
	}
	
	@Test
	public void readTileTest() {
		Tile tileTest = new Tile(46);
		assertEquals("333\n111\n000\n", tileTest.toString());
	}
	
	@Test
	public void containsTest() {
		Tile tileTest = new Tile(46);
		assertTrue(tileTest.contains(0));
		assertFalse(tileTest.contains(4));
	}
	
	@Test
	public void rotateTest() {
		Tile tileTest = new Tile(46);
		tileTest.rotateClockwise();
		tileTest.rotateClockwise();
		tileTest.rotateClockwise();
		tileTest.rotateClockwise();
		tileTest.rotateClockwise();
		assertEquals(tileTest.getRotation(), 1);
		assertEquals("013\n013\n013\n", tileTest.toString());
	}
	
	@Test
	public void counterRotateTest() {
		Tile tileTest = new Tile(46);
		assertEquals(tileTest.getRotation(), 0);
		tileTest.rotateCounterClockwise();
		assertEquals(tileTest.getRotation(), 1);
		assertEquals("310\n310\n310\n", tileTest.toString());
		tileTest.rotateClockwise();
		tileTest.rotateClockwise();
		tileTest.rotateClockwise();
		tileTest.rotateClockwise();
		assertEquals(tileTest.getRotation(), 1);
	}

}
