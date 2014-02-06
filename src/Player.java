import java.awt.Color;

public class Player {
    private Tile currentTile;
    private Meeple[] meeple;
    private Color color;
    
	public Meeple[] getMeeple() {
		return meeple;
	}
	public void setMeeple(Meeple[] meeple) {
		this.meeple = meeple;
	}
	public Tile getCurrentTile() {
		return currentTile;
	}
	public Color getColor() {
		return color;
	}
}
