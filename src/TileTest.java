import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TileTest {

	@Before
	public void setup() {
	}
	
	@Test
	public void readTileTest() {
		Tile tileTest = new Tile("test");
		assertEquals("333\n111\n000\n", tileTest.toString());
	}
	
	@Test
	public void containsTest() {
		Tile tileTest = new Tile("test");
		assertTrue(tileTest.contains(0));
		assertFalse(tileTest.contains(4));
	}

}
