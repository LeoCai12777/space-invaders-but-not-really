import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.util.Random;
public class Dialogue // pop up text box, offers options like Jay's problem set menus
{
    private static Random ran = new Random();
    private static Scanner sc = new Scanner(System.in);
    
    public Dialogue()
    {
    }

    public int talkAlien(TextBox textBox) //returns a difficulty level from 1-3, 1->easy, 3->hard
    {
        char choice;
        int difficulty=2;
        textBox.displayLine("General Zorp-Gorp: Greetings human. We have decided this planet is ours for the taking.");
        sc.nextLine();
        textBox.displayLine("1. Isn't there a peaceful way to resolve this?");
        textBox.displayLine("2. We'll see about that.");
        textBox.displayLine("3. Alien scum! I'll blast you back to Andromeda!");
        do{
            choice = sc.nextLine().charAt(0); //takes first character of next sentence
        }while((int)choice<49||(int)choice>51); //forces choice to be between 1 and 3
        if(choice == '1')
        {
            textBox.displayLine("General Zorp-Gorp: Well, we planned to invade, but perhaps we can make a deal.");
            sc.nextLine();
            textBox.displayLine("1. I'll have to ask my superiors. Could you wait a few hours?");
            textBox.displayLine("2. Barter? You must be joking. We expect you to leave and to leave now.");
            textBox.displayLine("3. Great! Let's talk. What would you like?");
            do{
            choice = sc.nextLine().charAt(0); //takes first character of next sentence
            }while((int)choice<49||(int)choice>51); //forces choice to be between 1 and 3
            if(choice == '1')
                textBox.displayLine("General Zorp-Gorp: I'm afraid that will take too long.");
            else if(choice == '2')
            {
                textBox.displayLine("General Zorp-Gorp: You do not respect us enough to trade?");
                difficulty = 3;
            }
            else if(choice == '3')
            {
                textBox.displayLine("General Zorp-Gorp: We have come to harvest the human species. \nOur race thrives on cuisine and human is said to taste great.");
                sc.nextLine();
                textBox.displayLine("1. Want to try hunting? I think it would be more fun if you had less ships.");
                textBox.displayLine("2. That's disgusting. How could you eat another sentient being?");
                do{
                choice = sc.nextLine().charAt(0); //takes first character of next sentence
                }while((int)choice<49||(int)choice>51); //forces choice to be between 1 and 3
                if(choice == '1')
                {
                    textBox.displayLine("General Zorp-Gorp: That sounds like great fun!");
                    difficulty = 1;
                }
                else if(choice == '2')
                {
                    System.out.println("General Zorp-Gorp: Hah! I pity your existence.");
                    difficulty = 3;
                }
            }
        }
        else if(choice == '3')
        {
            System.out.println("General Zorp-Gorp: Tiny minded xenophobe, I will show you the wrath of the Zorp-Gorp.");
            difficulty = 3;
        }
        System.out.println("General Zorp-Gorp: To the battlefield!");
        sc.nextLine();
        return difficulty;
    }
    
    public void talkCitizen()
    {
        int msg = ran.nextInt(5);
        if (msg == 0)
            System.out.println("Thanks for defending us sir!");
        else if (msg == 1)
            System.out.println("You're my hero!");
        else if (msg == 2)
            System.out.println("Go out and save the world!");
        else if (msg == 3)
            System.out.println("Those aliens can't get past you!");
        else if (msg == 4)
            System.out.println("Bless you mister.");
        sc.nextLine();
    }
    
    public int run(String character) { // returns difficulty after dialogue with alien, or just displays message from citizen
        //Create and set up the window.
        JFrame frame = new JFrame("TextBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add contents to the window.
        frame.add(new TextBox());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        if(character.equals("Alien"))
        {
            return talkAlien();
        }
        else if(character.equals("Citizen"))
        {
            talkCitizen();
            return 0; // just to fulfill the return int requirement, the 0 is not meant for anything
        }
    }
}


 
class TextBox extends JPanel{
//     protected JTextField textField;
    protected JTextArea textArea;
//     private final static String newline = "\n";
 
    public TextBox() {
        super(new GridBagLayout());
 
//         textField = new JTextField(20);
//         textField.addActionListener(this);
 
        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
 
        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
 
        c.fill = GridBagConstraints.HORIZONTAL;
//         add(textField, c);
 
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
    }
    public void displayLine(String msg)
    {
        textArea.append(msg+"\n");
    }
//     public void actionPerformed(ActionEvent evt) {
//         String text = textField.getText();
//         textArea.append(text + newline);
//         textField.selectAll();
 
//         //Make sure the new text is visible, even if there
//         //was a selection in the text area.
//         textArea.setCaretPosition(textArea.getDocument().getLength());
//     }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TextBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add contents to the window.
        frame.add(new TextBox());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
//     public static void main(String[] args) {
//         //Schedule a job for the event dispatch thread:
//         //creating and showing this application's GUI.
//         javax.swing.SwingUtilities.invokeLater(new Runnable() {
//             public void run() {
//                 createAndShowGUI();
//             }
//         });
//     }
}
