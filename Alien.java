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
    private boolean dead = false;
    private final String alienImg = "src/images/alien.png";

    public Alien (int x, int y) {
        xPos = x;
        yPos = y;
        ImageIcon im = new ImageIcon(alienImg);
    }

    public void move (int dx, int dy) {
        xPos+=dx;
        yPos+=dy;
    }

    public void die() {
        dead = true;
    }
    
    public void shoot() {
        bullet = new Bullet (xPos, yPos, false);
        bullet.shoot();
    }
}

