import java.awt.*;
import java.util.*;

public class Armada 
{

    //The army has 3 rows of aliens
    Alien wave1[] = new Alien[10];
    Alien wave2[] = new Alien[10];
    Alien wave3[] = new Alien[10];

    //The direction the army is moving in
    boolean movingRight = true;

    //The number of pixels to move at a time
    int moveDistance = 15;

    //A container to store details of the current alien bullets
    Vector aBullets = new Vector();    

    private Ship ship;

    private SpaceInvaders spaceInvaders;

    Image alienImage = null;

    public Armada (Ship s, SpaceInvaders si, Image ai) {
        ship = s;
        spaceInvaders = si;
        alienImage = ai;

        //	alienImage = new javax.swing.ImageIcon("alienFull.jpg").getImage();

        createArmy();
        setStartingPositions();
    }

    /**
     * In this method we initialise the 3 rows of aliens
     * that make up the army.
     */
    private void createArmy() {
        //To initialise a row we can either do
        wave1[0] = new Alien(alienImage, spaceInvaders);
        wave1[1] = new Alien(alienImage, spaceInvaders);
        wave1[2] = new Alien(alienImage, spaceInvaders);
        wave1[3] = new Alien(alienImage, spaceInvaders);
        wave1[4] = new Alien(alienImage, spaceInvaders);
        wave1[5] = new Alien(alienImage, spaceInvaders);
        wave1[6] = new Alien(alienImage, spaceInvaders);
        wave1[7] = new Alien(alienImage, spaceInvaders);
        wave1[8] = new Alien(alienImage, spaceInvaders);
        wave1[9] = new Alien(alienImage, spaceInvaders);

        //Or more efficently we could use a loop
        for (int i = 0; i < 10; i++) {
            wave2[i] = new Alien(alienImage, spaceInvaders);
            wave3[i] = new Alien(alienImage, spaceInvaders);//Finally set the third row
        }	
    }

    /**
     * Set where our alien army will start attacking from
     */
    private void setStartingPositions() {

        int rowHeight = 50;//Set the height of the top row
        int leftStart = 50;//Sets the furtherest position to the left
        for (int i = 0; i < 10; i++) {
            wave1[i].setPosition(leftStart, rowHeight);
            leftStart += 40;
        }
        rowHeight += 50;//Ready for the next row
        leftStart = 50;//Reset the left position
        for (int i = 0; i < 10; i++) {
            wave2[i].setPosition(leftStart, rowHeight);
            leftStart += 40;
        }
        rowHeight += 50;//Ready for the third row
        leftStart = 50;//Reset the left position
        for (int i = 0; i < 10; i++) {
            wave3[i].setPosition(leftStart, rowHeight);
            leftStart += 40;
        }	
    }

    /**
     * In this method we move the alien army.
     */
    public void moveArmy() {

        if (movingRight) {
            //We are moving right

            //First step: Check if the alien furthest to the right has hit the edge
            for (int i = 9; i >= 0; i--) {//Notice how this loop counts down
                if (!wave1[i].hasBeenHit()) {

                    //If the alien has not been hit - then it is the edge
                    //Now check if the alien if at the edge
                    if (wave1[i].getXPos() > (SpaceInvaders.WIDTH-Alien.ALIEN_WIDTH-15)) {
                        //Change direction
                        movingRight = false;

                        //Set the new lower y positions
                        for (int y = 0; y < 10; y++) {
                            wave1[y].setPosition(wave1[y].getXPos(), wave1[y].getYPos()+moveDistance);
                            wave2[y].setPosition(wave2[y].getXPos(), wave2[y].getYPos()+moveDistance);
                            wave3[y].setPosition(wave3[y].getXPos(), wave3[y].getYPos()+moveDistance);
                        }

                        return;//Return from this method, don't bother checking the rest.

                    }
                }
                if (!wave2[i].hasBeenHit()) {

                    //If the alien has not been hit - then it is the edge
                    //Now check if the alien if at the edge
                    if (wave2[i].getXPos() > (SpaceInvaders.WIDTH-Alien.ALIEN_WIDTH-15)) {
                        //Change direction
                        movingRight = false;

                        //Set the new lower y positions
                        for (int y = 0; y < 10; y++) {
                            wave1[y].setPosition(wave1[y].getXPos(), wave1[y].getYPos()+moveDistance);
                            wave2[y].setPosition(wave2[y].getXPos(), wave2[y].getYPos()+moveDistance);
                            wave3[y].setPosition(wave3[y].getXPos(), wave3[y].getYPos()+moveDistance);
                        }

                        return;//Return from this method, don't bother checking the rest.

                    }		   

                }
                if (!wave3[i].hasBeenHit()) {

                    //If the alien has not been hit - then it is the edge
                    //Now check if the alien if at the edge
                    if (wave3[i].getXPos() > (SpaceInvaders.WIDTH-Alien.ALIEN_WIDTH-15)) {
                        //Change direction
                        movingRight = false;

                        //Set the new lower y positions
                        for (int y = 0; y < 10; y++) {
                            wave1[y].setPosition(wave1[y].getXPos(), wave1[y].getYPos()+moveDistance);
                            wave2[y].setPosition(wave2[y].getXPos(), wave2[y].getYPos()+moveDistance);
                            wave3[y].setPosition(wave3[y].getXPos(), wave3[y].getYPos()+moveDistance);
                        }

                        return;//Return from this method, don't bother checking the rest.

                    }		  

                }		
            }	    

            //Second step: Move everyone to the right
            for (int i = 0; i < 10; i++) {
                wave1[i].setPosition(wave1[i].getXPos()+moveDistance, wave1[i].getYPos());
                wave2[i].setPosition(wave2[i].getXPos()+moveDistance, wave2[i].getYPos());
                wave3[i].setPosition(wave3[i].getXPos()+moveDistance, wave3[i].getYPos());
            } 	

	    
        } else {
            //We are moving left

            //First step: Check if the alien furthest to the left has hit the edge
            for (int i = 0; i < 10; i++) {//Notice how this loop counts down
                if (!wave1[i].hasBeenHit()) {

                    //If the alien has not been hit - then it is the edge
                    //Now check if the alien if at the edge
                    if (wave1[i].getXPos() < Alien.ALIEN_WIDTH) {
                        //Change direction
                        movingRight = true;

                        //Set the new lower y positions
                        for (int y = 0; y < 10; y++) {
                            wave1[y].setPosition(wave1[y].getXPos(), wave1[y].getYPos()+moveDistance);
                            wave2[y].setPosition(wave2[y].getXPos(), wave2[y].getYPos()+moveDistance);
                            wave3[y].setPosition(wave3[y].getXPos(), wave3[y].getYPos()+moveDistance);
                        }

                        return;//Return from this method, don't bother checking the rest.		
                    }

                }
                if (!wave2[i].hasBeenHit()) {

                    //If the alien has not been hit - then it is the edge
                    //Now check if the alien if at the edge
                    if (wave2[i].getXPos() < Alien.ALIEN_WIDTH) {
                        //Change direction
                        movingRight = true;

                        //Set the new lower y positions
                        for (int y = 0; y < 10; y++) {
                            wave1[y].setPosition(wave1[y].getXPos(), wave1[y].getYPos()+moveDistance);
                            wave2[y].setPosition(wave2[y].getXPos(), wave2[y].getYPos()+moveDistance);
                            wave3[y].setPosition(wave3[y].getXPos(), wave3[y].getYPos()+moveDistance);
                        }

                        return;//Return from this method, don't bother checking the rest.		
                    }		    

                }
                if (!wave3[i].hasBeenHit()) {

                    //If the alien has not been hit - then it is the edge
                    //Now check if the alien if at the edge
                    if (wave3[i].getXPos() < Alien.ALIEN_WIDTH) {
                        //Change direction
                        movingRight = true;

                        //Set the new lower y positions
                        for (int y = 0; y < 10; y++) {
                            wave1[y].setPosition(wave1[y].getXPos(), wave1[y].getYPos()+moveDistance);
                            wave2[y].setPosition(wave2[y].getXPos(), wave2[y].getYPos()+moveDistance);
                            wave3[y].setPosition(wave3[y].getXPos(), wave3[y].getYPos()+moveDistance);
                        }

                        return;//Return from this method, don't bother checking the rest.		
                    }	

                }		
            }

            //Second step: Move everyone to the left
            for (int i = 0; i < 10; i++) {
                wave1[i].setPosition(wave1[i].getXPos()-moveDistance, wave1[i].getYPos());
                wave2[i].setPosition(wave2[i].getXPos()-moveDistance, wave2[i].getYPos());
                wave3[i].setPosition(wave3[i].getXPos()-moveDistance, wave3[i].getYPos());
            }	    

        }
        //Start some random alien firing!
        Random generator = new Random();
        int rnd1 = generator.nextInt(10);
        int rnd2 = generator.nextInt(10);
        int rnd3 = generator.nextInt(10);
        if (!wave1[rnd1].hasBeenHit()) {
            ABullet as = new ABullet(wave1[rnd1].getXPos()+(int)(Alien.ALIEN_WIDTH/2), wave1[rnd1].getYPos(), ship);
            aBullets.addElement(as);
        }
        if (!wave1[rnd2].hasBeenHit()) {	
            ABullet as = new ABullet(wave2[rnd2].getXPos()+(int)(Alien.ALIEN_WIDTH/2), wave2[rnd2].getYPos(), ship);
            aBullets.addElement(as);
        }
        if (!wave1[rnd3].hasBeenHit()) {	
            ABullet as = new ABullet(wave3[rnd3].getXPos()+(int)(Alien.ALIEN_WIDTH/2), wave3[rnd3].getYPos(), ship);
            aBullets.addElement(as);
        }
    }

    /**
     *
     */
    public void drawArmy(Graphics g) {
        //Draw the first row
        for (int i = 0; i < 10; i++) {
            wave1[i].drawAlien(g);//Draw the first row
            wave2[i].drawAlien(g);//Draw the second row
            wave3[i].drawAlien(g);//Draw the third row
        } 
        //Now we need to draw any of the bullets the aliens have fired
        Vector tmp = new Vector();
        for (int i = 0; i < aBullets.size(); i++) {
            ABullet as = (ABullet)aBullets.elementAt(i);
            //Need to remove old bullets at this point!
            if (as.getBulletState()) {
                //This is NOT an old bullet
                tmp.addElement(as);
            }

            as.drawBullet(g);

        }
        aBullets = tmp;
    }

    /**
     * This is where the collision detection takes place
     */
    public boolean checkBullet(int x, int y) {
        for (int i = 0; i < 10; i++) {
            if (wave1[i].hitAlien(x, y)) {
                spaceInvaders.hitAlienScore();
                return true;
            }
            if (wave2[i].hitAlien(x, y)) {
                spaceInvaders.hitAlienScore();		    
                return true;
            }
            if (wave3[i].hitAlien(x, y)) {
                spaceInvaders.hitAlienScore();		    
                return true;
            }	    
        }
        return false;
    }
}