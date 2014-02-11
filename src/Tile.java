import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// TODO
// Decide whether we want to keep Tile type as a String or move to int

public class Tile {

	// Stores the current rotation of a tile as an int, we will use constants to store directional values
	// TODO
	private int rotation;
	
	//Array of neighbors
	// TODO
	private ArrayList<Tile> neighbors;
	
	// Compass directions for neighbor locations
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	// The plan here is to assign numbers to map elements
	public static final int GRASS = 0;
	public static final int ROAD = 1;
	public static final int ROAD_END = 2;
	public static final int CITY = 3;
	public static final int CLOISTER = 4;
	public static final int CREST = 5;
	
	// Grid is a two dimensional array that keeps track of the zones present in a given tile
	private int[][] grid;
	
	// The file path of the image associated with a given tile
	private String image;
		
	// Integer type of tile
	private int type;
	private String filename;
	
	// Returns the path of the tile's image
	public String getImage() {
		return image;
	}

	// Returns the tile's filename
	public String getFilename() {
		return filename;
	}
	
	public int getType() {
		return type;
	}

	public int getRotation() {
		return rotation;
	}

	public int[][] getGrid() {
		return grid;
	}
	
	public int getGridLocation(int x, int y) {
		return grid[x][y];
	}
	
	public Tile getNeighbor(int i) {
		return neighbors.get(i);
	}
	
	public ArrayList<Tile> getNeighbors() {
		return neighbors;
	}

	// Tile constructor, takes an int type
	public Tile(int type) {
		this.type = type;
		filename = "tiles/" + type;
		image = "images/" + type + ".jpg";
		grid = new int[3][3];
		
		readTile();
	}
	
	public boolean contains(int zone) {
		for (int i = 0; i < 3; i++){
	    	  for (int j = 0; j < 3; j++){
	    		  if (grid[i][j] == zone)
	    		  return true;
	    	  }
	      }
		return false;
	}
	
	public void rotateClockwise() {
		rotation = (rotation + 1) % 4; 
	    int[][] ret = new int[3][3];
	    for (int r = 0; r < 3; r++) {
	        for (int c = 0; c < 3; c++) {
	            ret[c][2-r] = grid[r][c];
	        }
	    }
	    grid = ret;
	}
	public void rotateCounterClockwise() {
		rotation = (rotation + 1) % 4; 
	    int[][] ret = new int[3][3];
	    for (int r = 0; r < 3; r++) {
	        for (int c = 0; c < 3; c++) {
	            ret[2-c][r] = grid[r][c];
	        }
	    }
	    grid = ret;
	}
	
	// Takes a string and inputs it into the tile's grid
	public void readToGrid(String text) {
		text.replaceAll("\n", "");
		int k = 0;
		for (int i = 0; i < 3; i++){
	    	  for (int j = 0; j < 3; j++){
	    		  grid[i][j] = text.charAt(k) - '0';
	    		  k++;
	    	  }
	      }
	}
	
	// Reads a tile definition file (with file not found check!)
	public void readTile() {
		String text = "";
	    Scanner inputFile = null;
		File myFile = new File(filename);
		
	    try {
			inputFile = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    while (inputFile.hasNext())
	    {
	      text += inputFile.nextLine();	    
	    }

	    readToGrid(text);
	    inputFile.close();
	   
	}
	
	// Allows for printing of a tile definition file directly from the file
	@Override
	public String toString() {
		String output = "";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				output += grid[i][j];
			}
			output += "\n";
		}
		
		return output;
	}
	
}
