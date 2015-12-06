// Sean's class
import greenfoot.*;

/**
 * Write a description of class StealthIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StealthIcon extends Clickables
{
    /**
     * Act - do whatever the StealthIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // http://wow.zamimg.com/images/wow/icons/large/ability_stealth.jpg
    GreenfootImage button;
    private int delay = 0;
    public StealthIcon()
    {
        button = getImage();
    }
    public void act() 
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (delay <= 60)
        {
            delay ++;
        }
        if (delay > 60)
        {
            button.setTransparency(255);
        }
        if (Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("o"))
        {
            delay = 0;
            button.setTransparency(125);
        }
            setImage(button);
    }    
}
