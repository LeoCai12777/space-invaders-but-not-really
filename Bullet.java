import java.util.*;

public class Bullet {
    private int xPos, yPos;
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
        timer.schedule(new ShootTask(this),0, 30);
    }
    class ShootTask extends TimerTask {
        Bullet bullet;
        ShootTask (Bullet b) {
            bullet = b;
        }
        public void run () {
            if (bullet.ship)
                bullet.yPos += 1;
            else
                bullet.yPos -= 1;
                
        }
    }
}