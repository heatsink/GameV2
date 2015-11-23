import greenfoot.*;

/**
 * Write a description of class Pictures here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pictures extends Actor
{
    /**
     * Act - do whatever the Pictures wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // Portal Sprite from http://spritefx.blogspot.com/2013/04/sprite-portals.html
    private GreenfootImage portal1 = new GreenfootImage("Portal/Portal1.png");
    private GreenfootImage portal2 = new GreenfootImage("Portal/Portal2.png");
    private GreenfootImage portal3 = new GreenfootImage("Portal/Portal3.png");
    private GreenfootImage portal4 = new GreenfootImage("Portal/Portal4.png");
    private int frame = 3;
    
    public void act() 
    {
        animatePortal();
    }    
    public void animatePortal()
    {
        if (frame == 3)
            {
                setImage(portal1);
            }
            else if (frame == 6)
            {
                setImage(portal2);
            }
            else if (frame == 9)
            {
                setImage(portal3);
            }
            else if (frame == 12)
            {
                setImage(portal4);
            }
            else if (frame == 15)
            {
                frame = 3;
            }
            frame++;
    }
}
