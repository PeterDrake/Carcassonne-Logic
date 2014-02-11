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
		tileTest.rotateCW();
		tileTest.rotateCW();
		tileTest.rotateCW();
		tileTest.rotateCW();
		tileTest.rotateCW();
		assertEquals(tileTest.getRotation(), 1);
	}

}
