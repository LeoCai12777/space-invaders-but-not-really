import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener
import javax.swing.event.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*; // file IO
import javax.imageio.*; // allows image loading

/**
 * The last defender of earth...
 *
 * Notice how this class has methods equivalent to those in the Alien class.
 */
public class CityShip implements MouseListener, MouseMotionListener {

    public static int SHIP_HEIGHT = 25;
    public static int SHIP_WIDTH = 15;

    private int x = 0, y = 0;
    
    private Image shipImage = null;

    City city = null;

    //We are only going to allow one bullet at a time
    Bullet bullet = null;

    boolean hitState = false;

    /**
     *
     */
    public CityShip(City c) {
        city = c;
        //Dynamically work out the starting position of the ship
        x = (int)((SpaceInvaders.WIDTH/2)+(SHIP_WIDTH/2));
        y = (int)((SpaceInvaders.HEIGHT/2)+(SHIP_HEIGHT/2));
    }

    /**
     * We will use the mouse to fly our ship
     */ 
    public void mouseMoved(MouseEvent me) {
        int newX = me.getX();
        int newY = me.getY();
        if (newX > (SpaceInvaders.WIDTH-SHIP_WIDTH-10)) {
            //Stop the ship moving off the screen
            x = SpaceInvaders.WIDTH-SHIP_WIDTH-10;
        } else {
            //Set the new x position
            x = newX;
        } 
        if (newY > (SpaceInvaders.HEIGHT-SHIP_HEIGHT-10)) {
            //Stop the ship moving off the screen
            y = SpaceInvaders.HEIGHT-SHIP_HEIGHT-10;
        } else {
            //Set the new y position
            y = newY-40;
        }
    }

    /**
     * Unused
     */
    public void mouseDragged(MouseEvent me) {

    }

    /**
     * 
     */ 
    public void mouseEntered(MouseEvent me) {
    }

    /**
     * 
     */ 
    public void mouseExited(MouseEvent me) {
    }

    /**
     *
     */ 
    public void mouseReleased(MouseEvent me) {

    }

    /**
     *
     */ 
    public void mousePressed(MouseEvent me) {

    }

    /**
     * Talk to other characters
     */ 
    public void mouseClicked(MouseEvent me) {
      //talk to characters
    }

    /**
     * Draw the image of the ship
     */ 
    public void drawShip(Graphics g) {
        try {
            // load file into Image object
            shipImage = ImageIO.read (new File ("images/" + "ship.png")); 
        } catch (IOException e) {
            System.out.println ("File not found");
        }
        g.drawImage (shipImage, x, y, null); // draw block
    }
}
