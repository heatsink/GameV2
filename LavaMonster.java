import greenfoot.*;
import java.util.*;

/**
 * Functionality in this class:
 */
public class LavaMonster extends RangedMinion  //RM Stands for Ranged Minion
{
    int delay = 0;
    private int imageTimer;
    // Sprite taken from http://www.spriters-resource.com/snes/stoneprotectors/sheet/39048/
    private GreenfootImage walk1 = new GreenfootImage("LavaMonster/walk1.png");
    private GreenfootImage walk2 = new GreenfootImage("LavaMonster/walk2.png");
    private GreenfootImage walk3 = new GreenfootImage("LavaMonster/walk3.png");
    private GreenfootImage walk4 = new GreenfootImage("LavaMonster/walk4.png");
    private GreenfootImage walk5 = new GreenfootImage("LavaMonster/walk5.png");

    private GreenfootImage attack1 = new GreenfootImage("LavaMonster/Attack1.png");
    private GreenfootImage attack2 = new GreenfootImage("LavaMonster/Attack2.png");

    private GreenfootImage hit1 = new GreenfootImage("LavaMonster/Hit1.png");

    private GreenfootImage death1 = new GreenfootImage("LavaMonster/Death1.png");
    private GreenfootImage death2 = new GreenfootImage("LavaMonster/Death2.png");

    private int attackCounter = 0;
    private int movingCounter = 0;
    private boolean moving = true;
    private int attackCounter2 = 0;
    private int deathCounter = 0;
    private int xPos;
    private int xPos2;
    private int yPos;
    private int yPos2;
    private int movePolarity = 1;
    public LavaMonster(int RMHP, int damage, int xPos, int xPos2, int yPos, int yPos2)
    {
        super(RMHP, damage);
        this.xPos = xPos;
        this.xPos2 = xPos2;
        this.yPos = yPos;
        this.yPos2 = yPos2;
    }

    public void act() 
    {
        if (yPos == 0 && yPos2 == 0 && moving == true)
        {
            horizontalPatrol();
        }
        if (xPos == 0 && xPos2 == 0 && moving == true)
        {
            verticalPatrol();
        }
        animate();
        detect();
        detectHit();
        ninjaattack();
        RMDied();
    }    

    public void horizontalPatrol()
    {
        if (getX() >= xPos2)
        {
            movePolarity*= -1;
        }
        if (getX() <= xPos)
        {
            movePolarity*= -1;
        }
        setLocation(getX() + movePolarity, getY());
    }

    public void verticalPatrol()
    {
        if (getY() >= yPos2)
        {
            movePolarity*= -1;
        }
        if (getY() <= yPos)
        {
            movePolarity*= -1;
        }
        setLocation(getX(), getY() + movePolarity);
    }

    public void RMDied()
    {
        if (RMHP <= 0)
        {
            setImage(death1);
            deathCounter++;
            if (deathCounter >= 8)
                setImage(death2);
            if (deathCounter >= 12)
            {
                Trap trap = (Trap) getWorld();
                trap.getNinja().setPoints(trap.getNinja().getPoints()+1);
                getWorld().removeObject(this);
            }
        }
    }

    public void detectHit()
    {
        Actor shuriken = getOneIntersectingObject(Shuriken.class);
        Actor sword = getOneIntersectingObject(Lightning.class);
        if (shuriken != null)
        {
            setImage(hit1);
        }
        else if (sword != null)
        {
            setImage(hit1);
        }
    }

    public void detect()
    {
        imageTimer++;
        delay++; 
        List<Ninja> list = getObjectsInRange(175, Ninja.class);
        if (list.size()>0 )
        {
            if (delay > 200)
            {
                moving = false;
                setImage(attack1);
                turnTowards(list.get(0).getX(), list.get(0).getY());
                double x = getRotation();
                SecondFireball secondFireball= new SecondFireball(this.getDamage());
                getWorld().addObject(secondFireball, getX(), getY());
                secondFireball.turnTowards(list.get(0).getX(), list.get(0).getY());
                delay = 0;
                setRotation(0);
            }
        }
        else moving = true;

    }

    private void animate()
    {
        int span = 15;
        if(imageTimer == span && moving == true)
            setImage(walk1);
        if(imageTimer == 2*span && moving == true)
            setImage(walk2);
        if(imageTimer == 3*span && moving == true)
            setImage(walk3);
        if(imageTimer == 4*span && moving == true)
            setImage(walk4);
        if(imageTimer == 5*span && moving == true)
            setImage(walk5);
        if(imageTimer >= 6*span && moving == true)
            imageTimer = 0;
    }
}