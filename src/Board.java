
public class Board {
	
	// takes in an x & y cordinate from a mouseclick, places meeple where clicked
	public int placeMeeple(int[] location, Player player, int type) {
		switch(type) {
		case 0: 
			System.out.println("farmer");
			
		case 1:
			System.out.println("thief");
		case 3:
			System.out.println("knight");
		case 4:
			System.out.println("monk");
		}
//		draw meeple using information from specific case and coordinates taken in
		
//		this should be fixed
		player.meeple--;
		
		return -1;
	}

}
