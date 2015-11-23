import greenfoot.*;
import java.util.*;

/**
 * Functionality in this class:
 */
public class Firebat extends MeleeMinion //RM Stands for Ranged Minion
{
    //RangedMinion redrm = new RangedMinion();
    // Sprite taken from http://www.spriters-resource.com/arcade/ghoulsnghosts/sheet/65558/
    private GreenfootImage batMove1 = new GreenfootImage("Bat/Bat1.png");
    private GreenfootImage batMove2 = new GreenfootImage("Bat/Bat2.png");
    private GreenfootImage batMove3 = new GreenfootImage("Bat/Bat3.png");
    private int frame = 0;
    public Firebat(int RMHP, int damage)
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
        List<Ninja> list = getObjectsInRange(200, Ninja.class);
        if (list.size()>0)
        {
            turnTowards(list.get(0).getX(), list.get(0).getY());
            move(12);
            if(getOneIntersectingObject(InfernoFence.class)!=null)
                move(-12);
            else
                move(-11);
            setRotation(0);
        }
               
    }
}
