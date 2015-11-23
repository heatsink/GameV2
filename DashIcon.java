import greenfoot.*;

/**
 * Write a description of class DashIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DashIcon extends Clickables
{
    /**
     * Act - do whatever the DashIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage button;
    private int delay = 0;
    public DashIcon()
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
        if (Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("u"))
        {
            delay = 0;
            button.setTransparency(125);
        }
            setImage(button);
        }
}
