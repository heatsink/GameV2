import greenfoot.*; 

/**
 * Functionality in this class:
 */
public class Shuriken extends Projectiles
{
    private int st = 0;
    int damage;
    // Sprite drawn by Edward, Sean's Roommate
    // http://soundbible.com/1898-Spin-Jump.html
    GreenfootSound sliceSound = new GreenfootSound("slice.mp3");
    GreenfootSound constructorSound = new GreenfootSound("spin_jump-Brandino480-2020916281.mp3");
    public void act() 
    {
        NPCS();
        //DASHBOSS();
    }    
    public Shuriken(int damage)
    {
        //constructorSound.play();
        this.damage = damage;
    }
    public void NPCS(){
                Actor NPCS = getOneIntersectingObject(NPCS.class);
            if (NPCS != null){
                getWorld().removeObject(this);
                sliceSound.setVolume(15);
                sliceSound.play();
            }
            else if (atWorldEdge())
            getWorld().removeObject(this);
         st++;
         if (st >= 0 && st < 12)
         {
             move (8);
         }
         else if (st >= 12 && st < 24)
         {
             move(7);
         }
         else if (st >= 24 && st < 36)
         {
             move(6);
         }
         else if (st >= 36 && st < 48)
         {
             move(5);
         }
         else if (st >= 48 && st < 54)
         {
             move(4);
         }
         else if (st >= 60 && st < 72)
         {
             move(3);
             if (this != null)
             {
                 getWorld().removeObject(this);
             }
         }
         else if(st>72)
            getWorld().removeObject(this);
    }
    /*
    public void DASHBOSS(){
            Actor DashBoss = getOneIntersectingObject(DashBoss.class);
            if (DashBoss != null){
                sliceSound.setVolume(15);
                sliceSound.play();
                if (this != null)
                {
                getWorld().removeObject(this);
                }
            }
    }
    */
    public int getDamage()
    {
        return damage;
    }
}