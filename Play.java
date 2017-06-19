import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener
import java.util.*;  // Needed for Scanner
import java.io.*; // file IO

public class Play extends JFrame
{
    Map map = new Map (5,9);
    public JLabel score;
    //======================================================== constructor
    public Play ()
    {
        // 1... Create/initialize components
        score = new JLabel ("Score: ");

        // 2... Create content pane, set layout
        JPanel content = new JPanel ();        // Create a content pane
        content.setLayout (new BorderLayout ()); // Use BorderLayout for panel
        JPanel north = new JPanel (); // where the buttons, etc. will be
        north.setLayout (new FlowLayout ()); // Use FlowLayout for input area

        DrawArea board = new DrawArea (600, 600); 

        // 3... Add the components to the input area.
        north.add (score);
        content.add (north, "North"); // Input area
        content.add (board, "Center"); 

        // 4... Set this window's attributes.
        setContentPane (content);
        pack ();
        setTitle ("Map Demo");
        setSize (900, 600);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo (null);           // Center window.
        
        //create Armada
        Armada fleet = new Armada(15,15)
        
//         public void shoot () {
//         timer = new Timer ();
//         timer.schedule(new ShootTask(),0, 30);
//         }
//         class ShootTask extends TimerTask {
//             public void run () {
//                 if (ship)
//                     yPos += 1;
//                 else
//                     yPos -= 1;
//             }
//         }
        
    }

  
    class DrawArea extends JPanel
    {
        public DrawArea (int width, int height)
        {
            this.setPreferredSize (new Dimension (width, height)); // size
        }

        public void paintComponent (Graphics g)
        {
            map.print (g);
        }
    }


    //======================================================== method main
    public static void main (String[] args)
    {
        Play window = new Play ();
        window.setVisible (true);
    }
}
