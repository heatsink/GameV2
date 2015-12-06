// Bill's entire class
import greenfoot.*;
import java.util.*;
/**
 * Write a description of class ForestRange here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ForestRange extends RangedMinion
{ // Will find the source of the sprite soon...
    int delay = 0;
    
    public ForestRange(int RMHP, int damage)
    {
        super(RMHP, damage);
    }
    public void act() 
    {
        /*
        moveUp(up1, up2, up3);
        moveDown(down1, down2, down3);
        moveLeft(left1, left2, left3);
        moveRight(right1, right2, right3);
        */
       detect();
       ninjaattack();
       RMDied();
    }    
    public void detect()
    {
        List<Ninja> list = getObjectsInRange(600, Ninja.class);
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
        delay++;       
    }
} 

