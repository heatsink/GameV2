// Sean's class
import greenfoot.*;

/**
 * Write a description of class UpgradeIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeIcon extends Clickables
{
    /**
     * Act - do whatever the UpgradeIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // http://www.moodlenews.com/wp-content/uploads/upgrade-icon.png
    GreenfootImage button;
    private int delay = 0;
    public UpgradeIcon()
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
        if (Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("h"))
        {
            delay = 0;
            button.setTransparency(125);
        }
            setImage(button);
    }     
}
