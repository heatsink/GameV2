import greenfoot.*;
// Hayden - Image of Intro level obstacle
public class IntroFence extends Obstacles
{
   
    //http://documentation.flatredball.com/frb/docs/images/6/66/Rock4.png
    public void act() 
    {
        Actor projectiles = getOneIntersectingObject(Projectiles.class);
        if(projectiles!= null){
            getWorld().removeObject(projectiles);
            Actor ator = getOneIntersectingObject (Fence.class);
        }
    }    
}
