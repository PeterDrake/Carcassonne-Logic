import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.*;

/**
 * A component with mouse operations for adding and removing squares.
 */
public class GridComponent extends JComponent {
	private Game game;

	public GridComponent(Game game) {
		this.game = game;
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
	}

	private class MouseHandler extends MouseAdapter {
		public void mousePressed(MouseEvent event) {
			Point2D point = event.getPoint();
			int x = (int) point.getX();
			int y = (int) point.getY();
			game.mouseClicked(x, y);
		}

		public void mouseClicked(MouseEvent event) {
		}
	}

	private class MouseMotionHandler implements MouseMotionListener {
		public void mouseMoved(MouseEvent event) {
		}

		public void mouseDragged(MouseEvent event) {
		}
	}

	public void paintComponent(Graphics g) {
		
//		Graphics2D g2 = (Graphics2D) g;
//		int numLines = GUI.DEFAULT_HEIGHT / Game.NUM_TILES;
		
//		for (int i = 0; i <= Game.NUM_TILES; i++) {
//			g2.draw(new Line2D.Double(i * numLines, 0, i * numLines,
//					GUI.DEFAULT_HEIGHT));
//			g2.draw(new Line2D.Double(0, i * numLines, GUI.DEFAULT_HEIGHT, i
//					* numLines));
//		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(GUI.DEFAULT_WIDTH, GUI.DEFAULT_HEIGHT);
	}
}
