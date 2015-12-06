// Tiffany's entire class
import greenfoot.*;
import java.util.*;

/**
 * Functionality in this class:
 */
public class Ice extends MeleeMinion  //RM Stands for Ranged Minion
{
    
    
    public Ice(int RMHP, int damage)
    {
        super(RMHP, damage);
    }
    public void act() 
    {
        detect(); 
        RMDied();
    }    
     
      public void detect()
    {
        List<Ninja> list = getObjectsInRange(200, Ninja.class);
        if (list.size()>0)
        {
            turnTowards(list.get(0).getX(), list.get(0).getY());
            move(12);
            if(getOneIntersectingObject(SnowFence.class)!=null)
                move(-12);
            else
                move(-11);
            setRotation(0);
        }
               
    }
}
