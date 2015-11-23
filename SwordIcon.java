import greenfoot.*;

/**
 * Write a description of class SwordIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

// http://icons.iconarchive.com/icons/icons8/ios7/512/Military-Sword-icon.png
// http://img.font.downloadatoz.com/download/imgs/d/i/a/diablo-heavy-lower.png
public class SwordIcon extends Clickables
{
    /**
     * Act - do whatever the SwordIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage button;
    private int delay = 0;
    public SwordIcon()
    {
        button = getImage();
    }
    public void act() 
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (delay <= 35)
        {
            delay ++;
        }
        if (delay > 35)
        {
            button.setTransparency(255);
        }
        if (Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("k"))
        {
            delay = 0;
            button.setTransparency(125);
        }
            setImage(button);
        }
         
}
