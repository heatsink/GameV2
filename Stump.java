import greenfoot.*;

// Bill - Stump sprite
public class Stump extends Obstacles
{
    // Sprite from http://opengameart.org/content/lpc-plant-repack
     public void act() 
    {
        Actor projectiles = getOneIntersectingObject(Projectiles.class);
        if(projectiles!= null){
            getWorld().removeObject(projectiles);
            Actor ator = getOneIntersectingObject (Fence.class);
        }
    }    
}