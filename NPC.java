public class NPC
{
    private String name;
    private Image sprite;
    private int direction;

    public NPC()
    {
        name = "Bob";
       // sprite = //bob sprite
    }

    public NPC (String name, int direction)
    {
        if (name.equals("Bob"))
        {
          //  sprite = //pulls image from image file
        }
    }
    
    public void idle() //NPC randomly turns around
    // method requires repaint
    {
        direction = ran.nextInt(24);// 7/8 of the time, NPC stands still
        if (direction == 0)
            sprite = //image of facing down
        else if (direction == 1)
            sprite = //image of facing left
        else if (direction == 2)
            sprite = //image of facing up
        else if (direction == 3)
            sprite = //mirror image of direction 1
    }
}
