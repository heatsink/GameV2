import greenfoot.*;

/**
 * Write a description of class Teleport here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teleport extends Actor
{
    /**
     * Act - do whatever the Teleport wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Teleport()
    {
        GreenfootImage image = getImage();
        image.scale(50, 50);
        setImage(image);
    }
    public void act() 
    {
        Actor projectiles = getOneIntersectingObject(Projectiles.class);
        if(projectiles!= null){
            getWorld().removeObject(projectiles);
            Actor ator = getOneIntersectingObject (Fence.class);
        }
    }        
}
