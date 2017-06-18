import java.util.*;

public class Bullet {
    public int xPos, yPos;
    private Timer timer;
    private boolean ship = false;
    public Bullet (int x, int y, boolean s) {
        xPos = x;
        yPos = y;
        if (s)
            ship = true;
    }

    public void shoot () {
        timer = new Timer ();
        timer.schedule(new ShootTask(),0, 30);
    }
    class ShootTask extends TimerTask {
        public void run () {
            if (ship)
                yPos += 1;
            else
                yPos -= 1;
        }
    }
}