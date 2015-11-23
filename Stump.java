import greenfoot.*;

/**
 * Write a description of class Stump here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stump extends Obstacles
{
    /**
     * Act - do whatever the Stump wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //http://opengameart.org/content/lpc-plant-repack
     public void act() 
    {
        Actor projectiles = getOneIntersectingObject(Projectiles.class);
        if(projectiles!= null){
            getWorld().removeObject(projectiles);
            Actor ator = getOneIntersectingObject (Fence.class);
        }
    }    
}