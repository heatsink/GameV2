import greenfoot.*;
import java.util.*;

/**
 * Write a description of class NinjaFireSmoke here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SmokeFireball extends Juice
{
    /**
     * Act - do whatever the NinjaFireSmoke wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // Sprite from http://s421.photobucket.com/user/SharkD2161/media/GearHead/Explosion_Smokey_sheet.png.html
    private GreenfootImage fireSmoke1 = new GreenfootImage("FireSmoke/FireSmoke1.png");
    private GreenfootImage fireSmoke2 = new GreenfootImage("FireSmoke/FireSmoke2.png");
    private GreenfootImage fireSmoke3 = new GreenfootImage("FireSmoke/FireSmoke3.png");
    private GreenfootImage fireSmoke4 = new GreenfootImage("FireSmoke/FireSmoke4.png");
    private GreenfootImage fireSmoke5 = new GreenfootImage("FireSmoke/FireSmoke5.png");
    private GreenfootImage fireSmoke6 = new GreenfootImage("FireSmoke/FireSmoke6.png");
    private GreenfootImage fireSmoke7 = new GreenfootImage("FireSmoke/FireSmoke6.png");
    private GreenfootImage fireSmoke8 = new GreenfootImage("FireSmoke/FireSmoke6.png");
    private GreenfootImage fireSmoke9 = new GreenfootImage("FireSmoke/FireSmoke6.png");
    private GreenfootImage fireSmoke10 = new GreenfootImage("FireSmoke/FireSmoke6.png");
    private GreenfootImage fireSmoke11 = new GreenfootImage("FireSmoke/FireSmoke6.png");
    private GreenfootImage fireSmoke12 = new GreenfootImage("FireSmoke/FireSmoke6.png");
    private GreenfootImage fireSmoke13 = new GreenfootImage("FireSmoke/FireSmoke6.png");
    private GreenfootImage fireSmoke14 = new GreenfootImage("FireSmoke/FireSmoke6.png");
    private GreenfootImage fireSmoke15 = new GreenfootImage("FireSmoke/FireSmoke6.png");
    private GreenfootImage fireSmoke16 = new GreenfootImage("FireSmoke/FireSmoke6.png");
    private int frame = 0;
    public void act() 
    {
        FireSmoke();
        //detect();
    }   
    public void detect()
    {
        List<Ninja> list = getObjectsInRange(5000, Ninja.class);
        if (list.size() > 0 )
        {
            turnTowards(list.get(0).getX(), list.get(0).getY());
            double x = getRotation();
            Fireball fireball = new Fireball(1);
            getWorld().addObject(fireball, getX(), getY());
            fireball.turnTowards(list.get(0).getX(), list.get(0).getY());
        } 
    }
    public void FireSmoke()
    {
        frame ++;
        if (frame == 1)
            {
                setImage(fireSmoke1);
            }
            else if (frame == 4)
            {
                setImage(fireSmoke2);
            }
            else if (frame == 8)
            {
                setImage(fireSmoke3);
            }
            else if (frame == 12)
            {
                setImage(fireSmoke4);
            }
            else if (frame == 16)
            {
                setImage(fireSmoke5);
            }
            else if (frame == 20)
            {
                setImage(fireSmoke6);
            }
            else if (frame == 24)
            {
                setImage(fireSmoke7);
            }
            else if (frame == 28)
            {
                setImage(fireSmoke8);
            }
            else if (frame == 32)
            {
                setImage(fireSmoke9);
            }
            else if (frame == 36)
            {
                setImage(fireSmoke10);
            }
            else if (frame == 40)
            {
                setImage(fireSmoke11);
            }
            else if (frame == 44)
            {
                setImage(fireSmoke12);
            }
            
            else if (frame == 48)
            {
                setImage(fireSmoke13);
            }
            else if (frame == 52)
            {
                setImage(fireSmoke14);
            }
            else if (frame == 56)
            {
                setImage(fireSmoke15);
            }
            else if (frame == 60)
            {
                setImage(fireSmoke16);
                detect();
            }
            else if (frame >= 64)
            {
               getWorld().removeObject(this);
            }
    }
}

