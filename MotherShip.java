import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener
import javax.swing.event.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*; // file IO
import javax.imageio.*; // allows image loading
import java.awt.event.*;  // Needed for ActionListener

public class MotherShip extends Alien
{
    private int bomb;
    
    public MotherShip () {
        super();
        lives = 5;
        bullets = 2;
        bomb = 4;
    }
    
    
}
