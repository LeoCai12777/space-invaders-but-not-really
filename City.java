import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener
import javax.swing.event.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*; // file IO
import javax.imageio.*; // allows image loading

import java.awt.image.BufferedImage;

public class City extends JFrame implements Runnable, MouseListener, ActionListener 
{ 
    public static int WIDTH = 600;//The width of the frame
    public static int HEIGHT = 400;//The height of the frame
    
    private int gameSpeed = 100;//Try 500
    CityShip cShip = null;

    Graphics offscreen_high;
    BufferedImage offscreen;

    Image backGroundImage = null;

    public City() 
    {        
        // 1... Create/initialize components
        JButton cityBtn = new JButton ("Back to Mission");
        cityBtn.addActionListener (this);

        //2... Create content pane, set layout
        JPanel content = new JPanel ();
        content.setLayout (new BorderLayout ());
        JPanel north = new JPanel ();
        north.setLayout (new FlowLayout ());

        DrawArea map = new DrawArea (600, 400);
        content.add (map, "Center");
        
        setContentPane (content);
        pack ();
        setTitle ("Space Invaders: Home Base");
        setSize (600, 600);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo (null); // Center window

        // 3... Add the components to the input area.
        north.add (cityBtn);
        content.add (north, "North");

        content.addMouseListener(this);

        //Create the ship to fight off the invading army!
        cShip = new CityShip(this);

        //The ship will be controlled by the mouse
        content.addMouseListener(cShip);
        //We also want mouse movement not just mouse clicks
        content.addMouseMotionListener(cShip);

        //offscreen = new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_RGB);
        //offscreen_high = offscreen.createGraphics();

        content.setBackground(Color.black);
        //setSize(WIDTH, HEIGHT);
        setVisible(true);
        startGame();
    }

    class DrawArea extends JPanel
    {
        public DrawArea (int width, int height)
        {
            this.setPreferredSize (new Dimension (width, height)); // size
        }

        public void paint (Graphics g) {
            g.setColor(Color.black);
            g.fillRect(0,0, WIDTH, HEIGHT);

            cShip.drawShip(g);

            g.drawImage(offscreen,0,0,this); 
        }
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {}

    public void actionPerformed (ActionEvent e)
    {  
        if (e.getActionCommand ().equals ("City")) 
        {
            JPanel city = new JPanel ();
            city.setLayout (new BorderLayout ());

            setContentPane (city);
            pack ();
            setTitle ("Home Base");
            setSize (600, 400);
            setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo (null); // Center window
        }
    }

    public void startGame() {
        //These two lines may look confusing but basically they start the 
        //game process, i.e. update the display screen every 100ms.
        Thread thread = new Thread(this);
        thread.start();
    }


    public void update(Graphics g) {
        paint(g);
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(gameSpeed);
            } catch(InterruptedException ie) {
                //Ignore this exception
            }

            repaint();//Update the screen
        }
    }


    /**
     * This is the program entry point
     */
    public static void main(String []args) {
        SpaceInvaders invaders = new SpaceInvaders();
    }

    public static void clear () { //clears screen
        System.out.print('\u000C');
    }
}