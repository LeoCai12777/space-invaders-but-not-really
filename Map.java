
import java.awt.*;
import java.awt.event.*;  // Needed for ActionListener
import java.util.*;  // Needed for Scanner
import java.io.*; // file IO
import javax.imageio.ImageIO;

class Map implements Commons
{
    public Object map [] []; //map 2D array

    public Map () {// set up default map;
        map = new Object [MAP_HEIGHT] [MAP_WIDTH]; // define 2-d array size

        for (int row = 0 ; row < MAP_HEIGHT ; row++)
            for (int col = 0 ; col < MAP_WIDTH ; col++)
                map [row] [col] = null; // blank space
    }

    public Map (int alienR, int alienC) {
        this();
        for (int a = 0; a < alienR; a++) {
            for (int b = 0; b < alienC; b++) {
                map [a*(ALIEN_HEIGHT+5)+30][b*(ALIEN_WIDTH+5)+30] = new Alien (a*(ALIEN_HEIGHT+5)+30, b*(ALIEN_WIDTH+5)+30);
            }
        }
        //moveAliens( 500);
    }

    public void print (Graphics g)  // displays the map on the screen
    {
        for (int row = 0 ; row < map.length; row++)// number of rows
        {
            for (int col = 0 ; col < map[0].length; col++)// length of first row
            {
                if (map [row] [col] == null) {
                    g.setColor (Color.black);
                    g.fillRect (col, row, 1, 1);
                }

            }
        }
        for (int row = 0 ; row < map.length; row++)// number of rows
        {
            for (int col = 0 ; col < map[0].length; col++)// length of first row
            {
                if ((map [row][col]) instanceof Alien){
                    g.setColor (Color.green);
                    g.fillRect (col, row, 30, 30);
                }// draw block
            }
        }
    }

    public void moveAliens (int time) {
        Timer timer = new Timer ();
        timer.schedule(new Task(), 0, time);
    }
    class Task extends TimerTask {
        public void run () {
            for (int row = 0 ; row < map.length; row++) {// number of rows 
                for (int col = 0 ; col < map[0].length; col++) {// length of first row
                    if (map[row][col] instanceof Alien){
                        if (col + ALIEN_WIDTH + 5 > MAP_WIDTH) {
                            ((Alien) map[row][col]).move(0,35);
                            map[row+35][col] = map[row][col];
                            map[row][col] = null;
                        }
                        else {
                            ((Alien)map[row][col]).move(35,0);
                            map[row+35][col] = map[row][col];
                            map[row][col] = null;
                        }
                    }
                }
            }
        }
    }
}
