import java.util.*;

public class Bullet {
    public int xPos, yPos, vy;
    private Timer timer;
    private boolean ship = false;
    public Bullet (int x, int y, boolean s) {
        xPos = x;
        yPos = y;
        vy = 15; //speed of bullet in y direction; assuming bullet only moves up and down, vx not needed
        if (s)
            vy = -15; // if player, bullet moves up
    }

    public boolean checkHitAlien (HitBox box) {
        if(box.hit(xPos, yPos))
            return true;
    }
}
