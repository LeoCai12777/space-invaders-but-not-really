import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener
import javax.swing.event.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*; // file IO
import javax.imageio.*; // allows image loading
import java.awt.event.*;  // Needed for ActionListener

public class Alien {
    private int xPos, yPos; //top left
    private Bullet bullet;
    private final String alienImg = "src/images/alien.png";

    public Alien (int x, int y) {
        xPos = x;
        yPos = y;
        ImageIcon im = new ImageIcon(alienImg);
        setImage(im.getImage());
    }

    public void move (int dx, int dy) {
        xPos+=dx;
        yPos+=dy;
    }

    public void die() {
        xPos = null;
        yPos = null;
    }
    
    public void shoot() {
        bullet = new Bullet (xPos, yPos, false);
        bullet.shoot();
    }
}

class Movement implements ActionListener { // executed according to timer delay

    public void actionPerformed (ActionEvent event) {
        repaint (); // refresh 
    }
}
