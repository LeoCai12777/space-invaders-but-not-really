
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener
import java.util.*;  // Needed for Scanner
import java.io.*; // file IO
import javax.imageio.ImageIO;

class Map
{
    private char map [] []; //map 2D array
    private int width, height; //size of grid block

    public Map (int cols, int rows, int blockwidth, int blockheight) // set up default map
    {
        width = blockwidth;  height = blockheight;
        map = new char [rows] [cols]; // define 2-d array size

        for (int row = 0 ; row < rows ; row++)
            for (int col = 0 ; col <cols ; col++)
            
                    map [row] [col] = ' '; // blank space
    }

    public void print (Graphics g)  // displays the map on the screen
    {
        for (int row = 0 ; row < map.length; row++)// number of rows
        {
            for (int col = 0 ; col < map[0].length; col++)// length of first row
            {
                if (map [row] [col] == ' ') // 
                    g.setColor (Color.black);
                g.fillRect (col * width, row * height, width, height); // draw block
            }
        }
    }
    

    public void add(int x, int y, char item)
    //Accepts the position and item, and adds the item to correct position in array
    {
        //Calculate row and column 
        int row = y/height - 2; //subtract two for the buttons at the top
        int col = x/width;
        map [row] [col] = item; //set to item

        if ((row == 0 || row == map.length-1) && item == 'W') //when side wall is clicked, make a row/column of wall
            for (int i = 0; i < map.length; i++)
                map [i] [col] = 'W';
        if ((col == 0 || col == map[0].length-1) && item == 'W')
            for (int i = 0; i < map[0].length; i++)
                map [row] [i] = 'W';
    }

    public void save(File file)
    //Accepts file and saves the current map to file
    {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try 
        {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for (int x = 0; x < map.length; x++) //go through each row
            {
                for (int y = 0; y < map[0].length; y++) //go through each column in the row
                    bw.write(map[x] [y]); //write letter into file
                bw.write("\n"); //new line after each row
            }
        } 
        catch (IOException e) //honestly not sure what the following does, but it's needed for this to work
        {
            e.printStackTrace();
        } 
        finally 
        {
            try 
            {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } 
            catch (IOException ex) 
            {
                ex.printStackTrace();
            }
        }
    }

    public void load(File file)
    //Accepts file and loads map from file
    {
        try
        {
            Scanner sc = new Scanner (file);
            int col = sc.nextLine().length(); //find number of columns
            int row = 1; //initialize row number
            while (sc.hasNextLine()) //until no more lines
            {
                row ++; //update counter to find number of rows
                sc.nextLine();
            }

            sc = new Scanner (file); //reset scanner
            String text = ""; //initialize text
            while (sc.hasNextLine()) //until no more lines
                text = text + sc.nextLine(); //add to String
            map = new char [row] [col]; //create new map with right number of rows and columns
            for (int x = 0; x < row; x++) //go through each row
                for (int y = 0; y < col; y++) //go through each column
                    map [x] [y] = text.charAt(x*col+y); //add corresponding character of String to array
        }
        catch (FileNotFoundException ex)  
        {
            System.err.println("File not found");
            ex.printStackTrace();
            throw new InternalError();
        }
    }

    public int search(char item)
    //Accepts item character, finds number of of that item in the map
    {
        int result = 0; //initialize counter
        for (int row = 0 ; row < map.length; row++) //go through each row
        {
            for (int col = 0 ; col < map[0].length ; col++) //go through each column
            {
                if (map [row] [col] == item) //if it is the item
                    result ++; //update counter
                else if (item == 'A') //if item is A (all items)
                    if (map [row] [col] != ' ') //every non-space item
                        result ++;
            }
        }
        return result;
    }

}