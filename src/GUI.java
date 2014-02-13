import java.awt.*;

import javax.swing.*;

public class GUI extends JFrame {
	public static final int DEFAULT_WIDTH = 720;
	public static final int DEFAULT_HEIGHT = 576;
	public final GridComponent gridComponent;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				GUI frame = new GUI(new Game());
				frame.setTitle("Carcassonne");
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