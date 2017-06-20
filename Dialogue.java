public class Dialogue // pop up text box, offers options like Jay's problem set menus
{
    private static Random ran = new Random();
    private static Scanner sc = new Scanner(System.in);
    
    public Dialogue()
    {
    }

    public int talkAlien() //returns a difficulty level from 1-3, 1->easy, 3->hard
    {
        char choice;
        int difficulty=2;
        System.out.println("General Zorp-Gorp: Greetings human. We have decided this planet is ours for the taking.");
        sc.nextLine();
        System.out.println("1. Isn't there a peaceful way to resolve this?");
        System.out.println("2. We'll see about that.");
        System.out.println("3. Alien scum! I'll blast you back to Andromeda!");
        do{
            choice = sc.nextLine().charAt(0); //takes first character of next sentence
        }while((int)choice<49||(int)choice>51); //forces choice to be between 1 and 3
        if(choice == '1')
        {
            System.out.println("General Zorp-Gorp: Well, we planned to invade, but perhaps we can make a deal.");
            sc.nextLine();
            System.out.println("1. I'll have to ask my superiors. Could you wait a few hours?")
            System.out.println("2. Barter? You must be joking. We expect you to leave and to leave now.");
            System.out.println("3. Great! Let's talk. What would you like?");
            do{
            choice = sc.nextLine().charAt(0); //takes first character of next sentence
            }while((int)choice<49||(int)choice>51); //forces choice to be between 1 and 3
            if(choice == '1')
                System.out.println("General Zorp-Gorp: I'm afraid that will take too long.");
            else if(choice == '2')
            {
                System.out.println("General Zorp-Gorp: You do not respect us enough to trade?");
                difficulty = 3;
            }
            else if(choice == '3')
            {
                System.out.println("General Zorp-Gorp: We have come to harvest the human species. \nOur race thrives on cuisine and human is said to taste great.");
                sc.nextLine();
                System.out.println("1. Want to try hunting? I think it would be more fun if you had less ships.");
                System.out.println("2. That's disgusting. How could you eat another sentient being?");
                do{
                choice = sc.nextLine().charAt(0); //takes first character of next sentence
                }while((int)choice<49||(int)choice>51); //forces choice to be between 1 and 3
                if(choice == '1')
                {
                    System.out.println("General Zorp-Gorp: That sounds like great fun!");
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
    }
}
