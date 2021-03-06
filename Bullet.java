import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener
import javax.swing.event.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*; // file IO
import javax.imageio.*; // allows image loading

public class Bullet implements Runnable {
    private int bulletSpeed = 10;

    private final int BULLET_WIDTH = 2;
    private final int BULLET_HEIGHT = 5; 

    private int x = 0;

    private int bulletHeight = 0;

    private Image bulletImage = null;
    
    boolean bulletState = true;

    Armada armada = null;

    /**
     *
     */
    public Bullet(int xVal, int yVal, Armada aa) {
        x = xVal;//Set the bullet direction
        bulletHeight = yVal;
        armada = aa;
        Thread thread = new Thread(this);
        thread.start();
    }

    /**
     *
     */
    private boolean moveBullet() {

        //Now we need to see if we've hit anything!
        if (armada.checkBullet(x, bulletHeight)) {
            //We hit something!
            System.out.println("We shot an alien!");
            bulletState = false;
            return true;
        }

        bulletHeight = bulletHeight - 2;

        //Now check we haven't gone off the screen
        if (bulletHeight < 0) {
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
                bulletImage = ImageIO.read (new File ("images/" + "shipLaser.png")); 
            } catch (IOException e) {
                System.out.println ("File not found");
            }
        } else {
            try {
                // load file into Image object
                bulletImage = ImageIO.read (new File ("images/" + "black.png")); 
            } catch (IOException e) {
                System.out.println ("File not found");
            }
        }
        g.drawImage (bulletImage, x, bulletHeight, null);
    }

    public boolean getBulletState() {
        return bulletState;
    }

    /**
     * The thread that moves the bullet 
     */ 
    public void run() {
        while(true) {
            try {
                Thread.sleep(bulletSpeed);
            } catch(InterruptedException ie) {
                //Ignore this exception
            }

            //Use this line for super bullets
            //
            //moveBullet()
            //
            //or this for normal bullets
            //
            //if (moveShot()) {
            // break;
            //}

            if (moveBullet()) {
                break;
            }
        }
    }

}