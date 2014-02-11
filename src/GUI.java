

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
               JFrame frame = new JFrame();
               frame.setSize(900, 600);
               frame.setTitle("Carcassonne");
               JPanel panel = new JPanel(new BorderLayout());
               Container contentPane = frame.getContentPane();
               contentPane.setLayout(new BorderLayout());
               Tile tile = new Tile(0);
               Tile tile2 = new Tile(13);
               panel.add(new TileComponent(tile, tile.EAST, 0, 0), BorderLayout.CENTER);
               panel.add(new TileComponent(tile2, tile.WEST, 0, 0), BorderLayout.CENTER);
               frame.add(panel);
               //frame.pack();
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}