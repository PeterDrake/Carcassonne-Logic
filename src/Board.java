public class Board {

	private int numPlayers;
	
	private Player player[];

	public Board(){
		
	}
	
	
	public String getScore() {
		String score = "";
		for (int i = 0; i < numPlayers; i++)
			score += " Player " + i + " " + player[i].getScore() + "";
//			score += " Player " + i + " " + 0;
		return score;
	}

}
