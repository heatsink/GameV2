import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class NinjaBlood here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PurpleBlood extends Juice
{
    /**
     * Act - do whatever the NinjaBlood wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // Sprite from http://powstudios.com/content/blood-animation-pack-1
    private GreenfootImage blood1 = new GreenfootImage("PurpleBlood/Blood1.png");
    private GreenfootImage blood2 = new GreenfootImage("PurpleBlood/Blood2.png");
    private GreenfootImage blood3 = new GreenfootImage("PurpleBlood/Blood3.png");
    private GreenfootImage blood4 = new GreenfootImage("PurpleBlood/Blood4.png");
    private GreenfootImage blood5 = new GreenfootImage("PurpleBlood/Blood5.png");
    private GreenfootImage blood6 = new GreenfootImage("PurpleBlood/Blood6.png");
    private Color purple = new Color(50,50,0);
    private int frame = 1;
    public void act() 
    {
        animateBlood();
    }   
    public void animateBlood()
    {
        if (frame == 1)
            {
                setImage(blood1);
            }
            else if (frame == 4)
            {
                setImage(blood2);
            }
            else if (frame == 8)
            {
                setImage(blood3);
            }
            else if (frame == 12)
            {
                setImage(blood4);
            }
            else if (frame == 16)
            {
                setImage(blood5);
            }
            else if (frame == 20)
            {
                setImage(blood6);
            }
            else if (frame == 24)
            {
                getWorld().removeObject(this);
            }
            frame++;
    }
    public void changeColor()
    {
    }
}

