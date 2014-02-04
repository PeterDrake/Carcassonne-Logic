import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tile {

	private int rotation;
	private Tile[][] neighbors;
	
	/*
	 * The plan here is to assign numbers to map elements
	 */
	public static final int GRASS = 0;
	public static final int ROAD = 1;
	public static final int ROAD_END = 2;
	public static final int CITY = 3;
	public static final int CLOISTER = 4;
	
	private int[][] grid;
	
	private String image;
	private String type;
	
	public String getImage() {
		return image;
	}

	public String getType() {
		return type;
	}

	public Tile(String type) {
		this.type = "tiles/" + type;
		image = type + ".jpg";
		grid = new int[3][3];
		
		readTile();
	}
	
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
