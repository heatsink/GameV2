// Bill's entire class
import greenfoot.*;
import java.util.*;

/**
 * Functionality in this class:
 */
public class ForestBat extends MeleeMinion //RM Stands for Ranged Minion
{
    //RangedMinion redrm = new RangedMinion();
    // Sprite taken from http://www.spriters-resource.com/fullview/70851/
    private GreenfootImage batMove1 = new GreenfootImage("ForestBat/ForestBat1.png");
    private GreenfootImage batMove2 = new GreenfootImage("ForestBat/ForestBat2.png");
    private GreenfootImage batMove3 = new GreenfootImage("ForestBat/ForestBat3.png");
    private GreenfootImage batMove4 = new GreenfootImage("ForestBat/ForestBat4.png");
    private GreenfootImage batMove5 = new GreenfootImage("ForestBat/ForestBat5.png");
    private int frame = 0;
    public ForestBat(int RMHP, int damage)
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
            setImage(batMove4);
        }
        
        if (frame == 20)
        {
            setImage(batMove5);
        }
        
        if (frame == 25)
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
            if(getOneIntersectingObject(Stump.class)!=null)
                move(-12);
            else
                move(-11);
            setRotation(0);
        }
               
    }
}
