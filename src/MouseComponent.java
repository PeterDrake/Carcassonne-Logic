
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;

import javax.swing.*;

/**
 * A component with mouse operations for adding and removing squares.
 */
public class MouseComponent extends JComponent {
    private Game game;
    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 600;

    public MouseComponent(Game game) {
        this.game = game;
        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    private class MouseHandler extends MouseAdapter {
        public void mousePressed(MouseEvent event) {
            // add a new square if the cursor isn't inside a square
            Point2D point = event.getPoint();
            int x = (int) point.getX();
            int y = (int) point.getY();
            game.mouseClicked(x, y);
        }

        public void mouseClicked(MouseEvent event) {
            // remove the current square if double clicked
            Point2D point = event.getPoint();
            int x = (int) point.getX();
            int y = (int) point.getY();
            game.mouseClicked(x, y);
        }
    }

    private class MouseMotionHandler implements MouseMotionListener {
        public void mouseMoved(MouseEvent event) {
        }

        public void mouseDragged(MouseEvent event) {
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
