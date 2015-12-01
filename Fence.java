import greenfoot.*;

// Fence Image
public class Fence extends Obstacles
{
    // Sprite from http://www.androidappsgame.com/uk-co-hitech-puzzle-moveboxes-android
    public Fence()
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
    // Fence Collision Detection End[Bill]
}