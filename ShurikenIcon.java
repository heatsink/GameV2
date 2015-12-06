// Sean's class
import greenfoot.*;

/**
 * Write a description of class ShurikenIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

// http://db4sgowjqfwig.cloudfront.net/assets/258394/trefoil-shuriken.png
// http://img.font.downloadatoz.com/download/imgs/d/i/a/diablo-heavy-lower.png

public class ShurikenIcon extends Clickables
{
     private GreenfootImage box = new GreenfootImage(55,55);
    /**
     * Act - do whatever the ShurikenIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage button;
    private int delay = 0;
    public ShurikenIcon()
    {
        button = getImage();
    }
    public void act() 
    {
       MouseInfo mi = Greenfoot.getMouseInfo();
        if (delay <= 25)
        {
            delay ++;
        }
        if (delay > 25)
        {
            button.setTransparency(255);
        }
        if (Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("j"))
        {
            delay = 0;
            button.setTransparency(125);
        }
            setImage(button);
    }    
}
