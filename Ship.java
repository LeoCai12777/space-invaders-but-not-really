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
public class Ship implements MouseListener, MouseMotionListener {

    public static int SHIP_HEIGHT = 25;
    public static int SHIP_WIDTH = 15;

    private int x = 0;
    private int heightPosition = 0;

    private Image shipImage = null;
    
    SpaceInvaders spaceInvaders = null;

    //We are only going to allow one bullet at a time
    Bullet bullet = null;

    boolean hitState = false;

    /**
     *
     */
    public Ship(SpaceInvaders si) {
        spaceInvaders = si;
        //Dynamically work out the starting position of the ship
        x = (int)((SpaceInvaders.WIDTH/2)+(SHIP_WIDTH/2));
        heightPosition = SpaceInvaders.HEIGHT-SHIP_HEIGHT-20;
    }

    /**
     * We will use the mouse to fly our ship
     */ 
    public void mouseMoved(MouseEvent me) {
        int newX = me.getX();
        if (newX > (SpaceInvaders.WIDTH-SHIP_WIDTH-10)) {
            //Stop the ship moving off the screen
            x = SpaceInvaders.WIDTH-SHIP_WIDTH-10;
        } else {
            //Set the new x position
            x = newX;
        } 
    }

    /**
     * Unused
     */
    public void mouseDragged(MouseEvent me) {

    }

    /**
     * Restart the game as we put the mouse back over the screen
     */ 
    public void mouseEntered(MouseEvent me) {
        spaceInvaders.pauseGame(false);
    }

    /**
     * Pause the game as we move the mouse off the screen
     */ 
    public void mouseExited(MouseEvent me) {
        spaceInvaders.pauseGame(true);
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
     * Fire a bullet at the aliens - mouse click
     */ 
    public void mouseClicked(MouseEvent me) {
        Armada army = spaceInvaders.getArmada();
        bullet = new Bullet(x+(int)(SHIP_WIDTH/2), heightPosition, army);
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
        g.drawImage (shipImage, x, heightPosition, null); // draw block
        //If the bullet is still alive, i.e. still on the screen
        if ((bullet != null) && (bullet.getBulletState())) {
            bullet.drawBullet(g);
        }
    }

    /**
     * Check if a bullet fired by an alien hit the ship
     */
    public boolean checkBullet(int xBullet, int yBullet) {

        //Is the ship currently alive?
        //if (hitState) {
        //If it's alreay been bullet then return false;
        // return false;
        //}

        //First lets check the X range
        if ((xBullet >= x) && (xBullet <= (x+SHIP_WIDTH))) {
            //X is ok, now lets check the Y range
            if ((yBullet >= heightPosition) && (yBullet <= (heightPosition+SHIP_HEIGHT))) {
                //The ship was hit!
                hitState = true;
                return true;
            }
        } 
        return false;
    }

    public void hitByAlien() {
        spaceInvaders.bulletShip();
    }

}