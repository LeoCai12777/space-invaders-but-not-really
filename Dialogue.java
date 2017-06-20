public class Dialogue // pop up text box, offers options like Jay's problem set menus
{
    private static Random ran = new Random();
    private static Scanner sc = new Scanner(System.in);
    
    public Dialogue()
    {
    }

    public int talkAlien()
    {
        char choice;
        System.out.println("Greetings human. We have decided this planet is ours for the taking.");
        sc.nextLine();
        System.out.println("1. Isn't there a peaceful way to resolve this?");
        System.out.println("2. We'll see about that.");
        System.out.println("3. Alien scum! I'll blast you back to Andromeda!");
        do{
            choice = sc.nextLine().charAt(0); //takes first character of next sentence
        }while((int)choice<49||(int)choice>51); //forces choice to be between 1 and 3
        if(choice == '1')
        {
            System.out.println("Well, we planned to invade, but perhaps we can make a deal.");
            sc.nextLine();
            System.out.println("1. 
            System.out.println("2. Barter? You must be joking. We expect you to leave and to leave now.");
            System.out.println("3. Great! Let's talk.");
        }
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
