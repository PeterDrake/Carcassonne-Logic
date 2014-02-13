import java.awt.*;

import javax.swing.*;

public class GUI extends JFrame {
	public static final int DEFAULT_WIDTH = 720;
	public static final int DEFAULT_HEIGHT = 576;
	public final GridComponent gridComponent;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Game game = new Game();
				GUI gui = new GUI(game);
				gui.setTitle("Carcassonne");
				gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gui.setVisible(true);
				game.setGui(gui);
			}
		});
	}

	public GUI(Game game) {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		gridComponent = new GridComponent(game);
		add(gridComponent);		
		pack();
	}
}