import java.awt.Color;


public class Player {
    private Meeple[] meeple;
    private Color color;
    
    public void Player() {
    	this.color = Color.BLACK;
    }

	public Color getColor()
	{
		return color;
	}
    
}
