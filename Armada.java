public class Armada
{
    private Alien[][] fleet; //alien fleet
    private int direction = 1;

    public Armada(int xPos, int yPos)
    {
        if(level == 1)
        {
            fleet = new Alien[level][5];
            int y = yPos, x;
            for(Alien[] row: fleet)
            {
                x = xPos;
                for(Alien ship: row)
                {
                    ship = new Alien(x,y);
                    x+=45;
                }
                y+=45;
            }
        }
//         else if(level == 2)
//         {
//             //same as above, increase difficulty through health and number of ships
//         }
//         else if(level == 3)
//         {
//         }
//         else if(level == 4)
//         {
//         }
//         else if(level == 5)
//         {
//         }
    }
    
    public void move () //timer can be in main, timer could become faster as more units are destroyed
                        //repaint after moving
    {
        if (fleet[fleet.length][fleet[0].length].x()==900||fleet[fleet.length][fleet[0].length].x()==0) // armada is at edge of screen
        {
            for(Alien[] row: fleet)
            {
                for(Alien ship: row)
                {
                    ship.move(0,5);
                }
            }
            direction *= -1;
        }
        else
        {
            for(Alien[] row: fleet)
            {
                for(Alien ship: row)
                {
                    ship.move(5*direction,0);
                }
            }
        }
    }
    
    public boolean checkDestroyed()
    {
        for(Alien[] row: fleet)
        {
            for(Alien ship: row)
            {
                if (ship!=null)
                    return false;
            }
        }
        return true;
    }
}
