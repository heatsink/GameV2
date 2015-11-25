import greenfoot.*;
import java.util.*;

/**
 * Functionality in this class:
 */
public class TrainingDummyRM extends RangedMinion  //RM Stands for Ranged Minion
{
    int delay = 0;
    private int imageTimer;
    
    public TrainingDummyRM(int RMHP, int damage)
    {
        super(RMHP, damage);
    }
    public void act() 
    {
       detect();
       ninjaattack();
       RMDied();
    }    
    public void detect()
    {
        List<Ninja> list = getObjectsInRange(5000, Ninja.class);
        if (list.size()>0&&delay>100)
        {
            turnTowards(list.get(0).getX(), list.get(0).getY());
            double x = getRotation();
            Darkness darkness = new Darkness(this.getDamage());
            getWorld().addObject(darkness, getX(), getY());
            darkness.turnTowards(list.get(0).getX(), list.get(0).getY());
            delay = 0;
            setRotation(0);
        }
        List<Boy> list2 = getObjectsInRange(5000, Boy.class);
        if (list2.size()>0&&delay>100)
        {
            turnTowards(list2.get(0).getX(), list2.get(0).getY());
            double x = getRotation();
            BoyDarkness darkness2 = new BoyDarkness(this.getDamage());
            getWorld().addObject(darkness2, getX(), getY());
            darkness2.turnTowards(list2.get(0).getX(), list2.get(0).getY());
            
            BoyDarkness darkness3 = new BoyDarkness(this.getDamage());
            getWorld().addObject(darkness3, getX(), getY());
            darkness3.turnTowards(list2.get(0).getX()-50, list2.get(0).getY()-50);
            
            BoyDarkness darkness4 = new BoyDarkness(this.getDamage());
            getWorld().addObject(darkness4, getX(), getY());
            darkness4.turnTowards(list2.get(0).getX()+50, list2.get(0).getY()+50);
            delay = 0;
            setRotation(0);
        }
        delay++;       
    }
}