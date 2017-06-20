import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener
import javax.swing.event.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*; // file IO
import javax.imageio.*; // allows image loading

/**
 *
 */
public class ABullet implements Runnable {

    private int bulletSpeed = 10;
    private int BULLET_WIDTH  = 2;
    private int BULLET_HEIGHT = 5;    

    private int x = 0;

    private int bulletHeight = 0;

    private Image aBullet = null;
    
    boolean bulletState = true;

    Ship ship = null;

    /**
     *
     */
    public ABullet(int xVal, int yVal, Ship s) {
        x = xVal;//Set the bullet direction
        bulletHeight = yVal;
        ship = s;
        Thread thread = new Thread(this);
        thread.start();
    }

    /**
     *
     */
    private boolean moveBullet() {

        //Now we need to see if the ship has been hit
        if (ship.checkBullet(x, bulletHeight)) {
            //We hit something!
            System.out.println("An alien shot the ship!");
            ship.hitByAlien();
            bulletState = false;
            return true;
        }

        bulletHeight = bulletHeight + 2;
        //We could have written this as
        //bulletHeight -= 2;

        //Now check we haven't gone off the screen
        if (bulletHeight > SpaceInvaders.HEIGHT) {
            bulletState = false;
            return true;
        }

        return false;
    }

    /**
     * Draw the image of the bullet
     */    
    public void drawBullet(Graphics g) {
        if (bulletState) {
            try {
                // load file into Image object
                aBullet = ImageIO.read (new File ("images/" + "alienLaser.png")); 
            } catch (IOException e) {
                System.out.println ("File not found");
            }
        } else {
            try {
                // load file into Image object
                aBullet = ImageIO.read (new File ("images/" + "black.png")); 
            } catch (IOException e) {
                System.out.println ("File not found");
            }
        }
        g.drawImage (aBullet, x, bulletHeight, null);
    } 

    public boolean getBulletState() {
        return bulletState;
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(bulletSpeed);
            } catch(InterruptedException ie) {
                //Ignore this exception
            }

            if (moveBullet()) {
                break;
            }

        }
    }

}