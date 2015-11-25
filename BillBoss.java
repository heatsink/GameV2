import greenfoot.*;
import java.util.*;
/**
 * Write a description of class BillBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BillBoss extends NPCS
{
    int delay = 0;
    int delay2 = 0;
    
    private GreenfootImage InfernoMove0 = new GreenfootImage("ForestGhost/Ghost1.png");
    private GreenfootImage InfernoMove1 = new GreenfootImage("ForestGhost/Ghost2.png");
    private GreenfootImage InfernoMove2 = new GreenfootImage("ForestGhost/Ghost3.png");
    private GreenfootImage InfernoMove3 = new GreenfootImage("ForestGhost/Ghost4.png");
    private GreenfootImage InfernoMove4 = new GreenfootImage("ForestGhost/Ghost5.png");
    private GreenfootImage InfernoMove5 = new GreenfootImage("ForestGhost/Ghost6.png");
    
    private int frame = 0;
    public BillBoss(int RMHP, int damage)
    {
        super(RMHP, damage);
    }

    public void act() 
    {
        animateSix(InfernoMove0, InfernoMove1, InfernoMove2, InfernoMove3, InfernoMove4, InfernoMove5);
        if(delay<80)
        {
            List<Ninja> list = getObjectsInRange(5000, Ninja.class);
            if (list.size()>0&&delay2>100)
            {
                turnTowards(list.get(0).getX(), list.get(0).getY());
                double x = getRotation();
                DashDarkness darkness = new DashDarkness(Greenfoot.getRandomNumber(10)+5);
                getWorld().addObject(darkness, getX(), getY());
                darkness.turnTowards(list.get(0).getX(), list.get(0).getY());
                delay2 = 0;
                setRotation(0);
            }
            delay2++;  
            ninjaattack();
            getImage().setTransparency(250);
            move(5);
            setRotation(0);
            delay++;
        }
        if(delay>=80&&delay<160)
        {
            getImage().setTransparency(100);
            setRotation(90);
            move(5);
            setRotation(0);
            delay++;
        }
        if(delay>=160&&delay<240)
        {
            List<Ninja> list = getObjectsInRange(5000, Ninja.class);
            if (list.size()>0&&delay2>100)
            {
                turnTowards(list.get(0).getX(), list.get(0).getY());
                double x = getRotation();
                DashDarkness darkness = new DashDarkness(Greenfoot.getRandomNumber(10)+5);
                getWorld().addObject(darkness, getX(), getY());
                darkness.turnTowards(list.get(0).getX(), list.get(0).getY());
                delay2 = 0;
                setRotation(180);
            }
            setRotation(180);
            delay++;  
            ninjaattack();
            getImage().setTransparency(250);
            setRotation(180);
            move(5);
            setRotation(0);
            delay2++;
        }
        if(delay>=240&&delay<320)
        {
            getImage().setTransparency(100);
            setRotation(270);
            move(5);
            setRotation(0);
            delay++;
        }
        if(delay>=320)
        {
            delay = 0;
        }
        RMDied();
    }    
    public void animateSix(GreenfootImage move0, GreenfootImage move1, GreenfootImage move2, GreenfootImage move3, GreenfootImage move4, GreenfootImage move5)
    {
        frame ++;
        if (frame == 1)
            {
                setImage(move0);
            }
            else if (frame == 4)
            {
                setImage(move1);
            }
            else if (frame == 8)
            {
                setImage(move2);
            }
            else if (frame == 12)
            {
                setImage(move3);
            }
            else if (frame == 16)
            {
                setImage(move4);
            }
            else if (frame == 20)
            {
                setImage(move5);
            }
            else if (frame == 24)
            {
                frame = 0;
                return;
            }
    }
}
