import greenfoot.*;

/**
 * Write a description of class SnowFence here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnowFence extends Obstacles
{
    /**
     * Act - do whatever the SnowFence wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act() 
    {
        Actor projectiles = getOneIntersectingObject(Projectiles.class);
        if(projectiles!= null){
            getWorld().removeObject(projectiles);
            Actor ator = getOneIntersectingObject (Fence.class);
        }
    } 
}    

