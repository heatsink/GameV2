import greenfoot.*;

/**
 * Functionality in this class:
 */
public class InfernoFence extends Obstacles
{
    // Fence Object Start [Bill]
    public InfernoFence()
    {
        //GreenfootImage image = getImage();
        //image.scale(40, 40);
        //setImage(image);
    }
    // Fence Object End [Bill]
    // Fence Collision Detection Start [Tiffany]
    public void act() 
    {
        Actor projectiles = getOneIntersectingObject(Projectiles.class);
        if(projectiles!= null){
            getWorld().removeObject(projectiles);
            Actor ator = getOneIntersectingObject (Fence.class);
        }
    }    
    // Fence Collision Detection End[Bill]
}