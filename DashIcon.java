// Sean's class
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
    
    // http://hydra-media.cursecdn.com/pathofexile.gamepedia.com/c/cf/Flame_Dash_skill_icon.png?version=887e633f7d0e26624519211d5488d345
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
