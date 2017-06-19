import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener
import javax.swing.event.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*; // file IO
import javax.imageio.*; // allows image loading
import java.awt.event.*;  // Needed for ActionListener

public class Ship implements Commons, KeyListener
{
    private int lives, xPos, yPos, width;
    private Bullet bullet;
    private final String playerImg = "src/images/player.png";
    private ImageIcon im;

    public Ship (int l, int x, int y) {
        lives = l;
        xPos = x;
        yPos = y;
        im = new ImageIcon (playerImg);
        width = im.getImage().getWidth(null);
    }

    public void shoot () {
        bullet = new Bullet (xPos, yPos, false);
        bullet.shoot(); bullet = new Bullet (xPos, yPos, false);
        bullet.shoot();
    }

    public void move (int dx, int dy) {
        xPos += dx;
        if (xPos <= 5) 
            xPos = 5;
        if (xPos >= BOARD_WIDTH - 2 * width) 
            xPos = BOARD_WIDTH - 2 * width;
    }    

    public void keyPressed (KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) 
            move(-5,0);
        if (key == KeyEvent.VK_RIGHT)
            move(5,0);
        if (key == KeyEvent.VK_UP)
            move(0,5);
        if (key == KeyEvent.VK_DOWN)
            move (-5,0);
        if (key == KeyEvent.VK_SPACE)
            shoot();
    }	
    public void keyReleased (KeyEvent e) {}
    public void keyTyped (KeyEvent e) {}

    // public void upgrade (String part)
    // {
    // if (part.equals"Cannon")
    // //upgrade cannon in some way
    // //rest ofthe parts can also be upgraded this way
    // }
}
