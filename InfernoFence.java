import greenfoot.*;
public class InfernoFence extends Obstacles
{
    // Sprite from http://www.zeldadungeon.net/wiki/images/f/f6/TMC_Boulder.png
    public InfernoFence()
    {
    }
    // Fence Collision Detection Start [Tiffany]
    public void act() 
    {
        Actor projectiles = getOneIntersectingObject(Projectiles.class);
        if(projectiles!= null){
            getWorld().removeObject(projectiles);
            Actor ator = getOneIntersectingObject (Fence.class);
        }
    }    
    // Fence Collision Detection End[Tiffany]
}