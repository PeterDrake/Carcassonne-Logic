
public class Graph {
	private int[][] grid;
	private Tile[][] table;
	
	public Graph(Tile[][] table) {
		this.table = table;
		grid = new int[Board.MAX_SIZE * 3][Board.MAX_SIZE * 3];
	}
	
	public void buildGrid() {
		int[][] tileGrid;
		Tile tile;
		
		for (int row = 0; row < Board.MAX_SIZE * 3; row++) {
			for (int column = 0; column < Board.MAX_SIZE * 3; column++) {
				if (table[row][column] != null) {
					tile = table[row][column];
					tileGrid = tile.getGrid();
					for(int innerRow = 0; innerRow < 3; innerRow++) {
						
					}
				}
			}
		}
	}
	
}
