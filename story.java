import greenfoot.*;

/**
 * Write a description of class story1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class story extends Pictures
{
    /**
     * Act - do whatever the story1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int delay=0;
    public void act() 
    {
        if (delay < 50)
        {
            delay++;
        }
        if (Greenfoot.isKeyDown("space") && delay>=30)
        {
            getWorld().removeObject(this);
        }
    }    
}
