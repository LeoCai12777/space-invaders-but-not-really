import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener
import javax.swing.event.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*; // file IO
import javax.imageio.*; // allows image loading
import java.awt.event.*;  // Needed for ActionListener

class SpaceInvaders extends JFrame implements KeyListener, Commons
{
    static Map map = new Map (60, 40, 10, 10); // create map, block size
    static Timer t;

    //======================================================== constructor
    public SpaceInvaders ()
    {

        // 1... Enable key listener for movement
        addKeyListener (this);
        setFocusable (true);
        setFocusTraversalKeysEnabled (false);

        // 2... Create content pane, set layout
        JPanel content = new JPanel ();        // Create a content pane

        //map.addWall (); // add a wall

        DrawArea board = new DrawArea (800, 800); // Area for map to be displayed

        content.add (board); // map display area

        // 4... Set this window's attributes.
        setContentPane (content);
        pack ();
        setTitle ("Space Invaders");
        setSize (800, 800);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo (null);           // Center window.

        board.addKeyListener (this);

        Movement randomStuff = new Movement (); // ActionListener for timer
        t = new Timer (500, randomStuff); // set up Movement to run every 500 milliseconds
        t.start (); // start the timer

    }

    public void keyTyped (KeyEvent e)
    {
        // nothing
    }

    public void keyReleased (KeyEvent e)
    {
        // nothing
    }

    public void keyPressed (KeyEvent e) // handle cursor keys and enter
    {
        int key = e.getKeyCode ();
        switch (key)
        {
            case KeyEvent.VK_UP:
            map.move (0, -1);
            break;
            case KeyEvent.VK_DOWN:
            map.move (0, 1);
            break;
            case KeyEvent.VK_LEFT:
            map.move (-1, 0);
            break;
            case KeyEvent.VK_RIGHT:
            map.move (1, 0);
            break;
            case KeyEvent.VK_ENTER:
            map.explode ();
            break;
        }
        repaint ();
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

    class Movement implements ActionListener // executed according to timer delay
    {
        public void actionPerformed (ActionEvent event)
        {
            //map.addTreasures (); // add a random treasure to map
            repaint (); // refresh
        }
    }

    //======================================================== method main
    public static void main (String[] args)
    {
        SpaceInvaders window = new SpaceInvaders ();
        window.setVisible (true);
    }
}

//-------------------------------------- Map Class ------------------------------------------------

class Map
{
    private char map[] [];
    private int width, height, posx, posy;
    private Image image;
    
    public Map (int rows, int cols, int blockwidth, int blockheight)
    {
        width = blockwidth;
        height = blockheight;
        map = new char [rows] [cols]; // define 2-d array size

        for (int row = 0 ; row < rows ; row++) {
            for (int col = 0 ; col < cols ; col++)
            {
                if (row == 0 || row == rows - 1 || col == 0 || col == cols - 1) // border
                    map [row] [col] = 'W'; // put up a wall
                else
                    map [row] [col] = ' '; // blank space
            }
        }
        //map [rows - 1] [cols / 2] = 'D'; // make a door
        //map [rows - 1] [cols / 2 + 1] = 'D';

        posx = cols / 2 - 2;
        posy = rows - 2;
    }

    public void print (Graphics g)    // displays the map on the screen
    {
        image = null;
        for (int row = 0 ; row < map.length ; row++) // number of rows
        {
            for (int col = 0 ; col < map [0].length ; col++) // length of first row
            {
                if (map [row] [col] == 'W') // wall
                    g.setColor (Color.black);
                else if (map [row] [col] == 'D') // door
                    g.setColor (Color.red);
                else if (map [row] [col] == 'T') // treasure
                    g.setColor (Color.orange);
                else if (map [row] [col] == ' ') // space will erase what was there
                    g.setColor (Color.white);
                g.fillRect (col * width + 10, row * height + 10, width, height); // draw block
            }
        }
        
        try { // draw character
            // load file into Image object
            image = ImageIO.read (new File ("Images/" + "ship.png")); 
        } catch (IOException e) {
            System.out.println ("File not found");
        }
        g.drawImage (image, posx * width + 10, posy * height + 10, null); // draw image        

    }

    public void addTreasures () // adds treasure to random location
    {
        int row = (int) (Math.random () * (map.length - 2) + 1);
        int col = (int) (Math.random () * (map [0].length - 2) + 1);
        map [row] [col] = 'T';
    }

    public void move (int dx, int dy) // moves character if possible (no obstruction)
    {
        if (map [posy + dy] [posx + dx] == ' ') // empty space
        {
            posx += dx;
            posy += dy;
        }
    }

    public void explode () // kills everything within one space of character
    {
        for (int x = -1 ; x <= 1 ; x++)
        {
            for (int y = -1 ; y <= 1 ; y++)
            {
                map [posy + y] [posx + x] = ' ';  // empty space
            }
        }
        map [posy] [posx] = 'c'; // put character back
    }
}

//first make stationary aliens
//timer for bullets
//when aliens and bullets coordiantes intersect, explode