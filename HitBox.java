import java.util.*;

public class HitBox {
    private int x, y;
    
    public HitBox(int xPos, int yPos)
    {
        x = xPos;
        y = yPos;
    }// hitbox will extend: for Aliens, down 30 right 30, for Ship: down 15, right 10
    
    public boolean hit (int xPos, int yPos)
    {
        if(xPos >= x && xPos <= x + 30 && yPos >= y && yPos <= y+30) // 30x30 hitbox
            return true;
    }
}
