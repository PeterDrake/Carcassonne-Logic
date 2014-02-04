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
		assertEquals("3 3 3 \n1 1 1 \n0 0 0 ", tileTest);
	}

}
