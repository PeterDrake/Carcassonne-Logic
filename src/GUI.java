
<<<<<<< HEAD
public class GUI extends JFrame {
    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 600;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUI frame = new GUI(new Game());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
    
    public GUI(Game game) {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        add(new MouseComponent(game));
        pack();
    }
}
=======

import java.awt.*;
import javax.swing.*;

/**
 * This program demonstrates various image processing operations.
 * @version 1.03 2007-08-16
 * @author Cay Horstmann
 */
public class GUI
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new TileFrame(tile, 1);
               frame.setTitle("Carcassonne");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}
>>>>>>> master
