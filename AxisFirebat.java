import greenfoot.*;
import java.util.*;

/**
 * Functionality in this class:
 */
public class AxisFirebat extends MeleeMinion //RM Stands for Ranged Minion
{
    //RangedMinion redrm = new RangedMinion();
    // Sprite taken from http://www.spriters-resource.com/arcade/ghoulsnghosts/sheet/65558/
    private GreenfootImage batMove1 = new GreenfootImage("Bat/Bat1.png");
    private GreenfootImage batMove2 = new GreenfootImage("Bat/Bat2.png");
    private GreenfootImage batMove3 = new GreenfootImage("Bat/Bat3.png");
    private int frame = 0;
    int xPolarity = 1;
    int yPolarity = 1;
    public AxisFirebat(int RMHP, int damage)
    {
        super(RMHP, damage);
    }
    public void act() 
    {
       animate();
       detect();
       ninjaattack();
       RMDied();
    }    
    public void animate()
    {
        frame++;
        if (frame == 1)
        {
            setImage(batMove1);
        }
        
        if (frame == 5)
        {
            setImage(batMove2);
        }
        
        if (frame == 10)
        {
            setImage(batMove3);
        }
        
        if (frame == 15)
        {
            frame = 0;
        }
        
    }
    public void RMDied()
    {
        if (RMHP <= 0)
        {
            Trap trap = (Trap) getWorld();
            trap.getNinja().setPoints(trap.getNinja().getPoints()+1);
            SmokeFireball smokeFireball = new SmokeFireball();
            getWorld().addObject(smokeFireball, getX(), getY());
            getWorld().removeObject(this);
        }
    }
    public void detect()
    {
        List<Ninja> list = getObjectsInRange(400, Ninja.class);
        if (list.size()>0)
        {
            //setLocation(list.get(0).getX()
            int xDifference = getX() - list.get(0).getX();
            int yDifference = getY() - list.get(0).getY();
            
            if (xDifference < 0) // Then ninja is to the left
            {
                xPolarity = 1;
            }
            if (xDifference > 0) // Then ninja is to the right
            {
                xPolarity = -1;
            }
            if (yDifference < 0) // Then ninja is above
            {
                yPolarity = 1;
            }
            if (yDifference > 0) // Then ninja is below
            {
                yPolarity = -1;
            }
            if (Math.abs(xDifference) > Math.abs(yDifference))
            {
                // move in x direction
                setLocation(getX() + 1*xPolarity, getY());
            }
            else if (Math.abs(xDifference) <= Math.abs(yDifference))
            //else
            {
                setLocation(getX(), getY() + 1*yPolarity);
                // move in y direction
            }
            //turnTowards(list.get(0).getX(), list.get(0).getY());
            /*
            move(12);
            if(getOneIntersectingObject(InfernoFence.class)!=null)
                move(-12);
            else
                move(-11);
                */
        }
               
    }
}
