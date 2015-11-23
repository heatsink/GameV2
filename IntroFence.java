import greenfoot.*;

/**
 * Write a description of class IntroFence here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroFence extends Obstacles
{
   
    //http://documentation.flatredball.com/frb/docs/images/6/66/Rock4.png
    /**
     * Act - do whatever the IntroFence wants to do. This method is called whenever
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
