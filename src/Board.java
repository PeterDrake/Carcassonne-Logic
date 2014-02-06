public class Board {

	private int numPlayers;
	
	private Player player[];

	public Board(){
		
	}
	
	
	public String getScore() {
		String score = "";
		for (int i = 0; i < numPlayers; i++) {
			score += " Player " + (i + 1) + ": " + player[i].getScore() + "   ";
		}
		return score;
	}

}
