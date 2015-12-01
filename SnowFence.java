import greenfoot.*;

// Tiffany - Mushroom Sprite
public class SnowFence extends Obstacles
{
    public void act() 
    {
        Actor projectiles = getOneIntersectingObject(Projectiles.class);
        if(projectiles!= null){
            getWorld().removeObject(projectiles);
            Actor ator = getOneIntersectingObject (Fence.class);
        }
    } 
}    

