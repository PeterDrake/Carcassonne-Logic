public class Player {
	private Tile currentTile;
	private Meeple[] meeple;
	private int score;
	
	public void Player() {
		
	}

	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}
}
