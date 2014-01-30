import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tile {

	private int rotation;
	private Tile[][] neighbors;
	
	/*
	 * The plan here is to have a map of board characteristics to integers
	 * using string constants
	 */
	public static final int GRASS = 0;
	public static final int ROAD = 1;
	public static final int ROAD_END = 2;
	public static final int CITY = 3;
	public static final int CLOISTER = 4;
	
	private int[][] grid;
	
	private String tileImage;
	private String tileType;
	
	public Tile(String tileType) {
		this.tileType = tileType;
		tileImage = tileType + ".jpg";
		grid = new int[3][3];
		
		readTile();
	}
	
	private void readTile() {
		String text = "";
	    Scanner inputFile = null;
		File myFile = new File(tileType);
		
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

	    System.out.println(text);
	    inputFile.close();
	   
	}
	
}
