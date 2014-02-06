import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// TODO
// Decide whether we want to keep Tile type as a String or move to int

public class Tile {

	// Stores the current rotation of a tile as an int, we will use constants to store directional values
	// TODO
	private int rotation;
	
	//Two dimensional array of neighbors
	// TODO
	private Tile[][] neighbors;
	
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
	
	// Integer value assigned to a tile
	private String type;
	
	// Returns the path of the tile's image
	public String getImage() {
		return image;
	}

	// Returns the tile's type (which is really just a number)
	public String getType() {
		return type;
	}

	// Tile constructor, takes a String (which is really just a number)
	public Tile(String type) {
		this.type = "tiles/" + type;
		image = "images/" + type + ".jpg";
		grid = new int[3][3];
		
		readTile();
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
	private void readTile() {
		String text = "";
	    Scanner inputFile = null;
		File myFile = new File(type);
		
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
