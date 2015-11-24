import greenfoot.*; 

/**
 * Functionality in this class:
 */
public class Fireball extends Projectiles
{
    private int st = 0;
    private int damage;
    GreenfootSound sliceSound = new GreenfootSound("DarknessSwish.mp3");
    
    //Sprite taken from http://void-project-1.googlecode.com/svn/trunk/Game%20Engines/rpgMakerVX/Graphics/Characters/
    // (it's under fireball.png)
    // http://soundbible.com/1356-Flame-Arrow.html
    GreenfootSound fireballSound = new GreenfootSound("Flame Arrow-SoundBible.com-618067908.mp3");
    GreenfootImage fireball1 = new GreenfootImage("Fireball/Fireball1.png");
    GreenfootImage fireball2 = new GreenfootImage("Fireball/Fireball2.png");
    GreenfootImage fireball3 = new GreenfootImage("Fireball/Fireball3.png");
    private double frame = 1;
    public Fireball(int damage)
    {
        setImage(fireball1);
        this.damage = damage;
        
    }
    public void act() 
    {
        if (frame == 1)
        {
            setImage(fireball1);
        }
        else if (frame == 3)
        {
            setImage(fireball2);
        }
        else if (frame == 5)
        {
            setImage(fireball3);
        }
        else if (frame == 7)
        {
            frame = 1;
            return;
        }
        frame+=0.25;
        
        Actor ninja = getOneIntersectingObject(Ninja.class);
            if (ninja != null){
                fireballSound.setVolume(35);
                fireballSound.play();
                getWorld().removeObject(this);
            }
            else if (atWorldEdge())
            getWorld().removeObject(this);
         st++;
         if (st >= 0 && st < 12)
         {
             move (6);
         }
         else if (st >= 12 && st < 24)
         {
             move(5);
         }
         else if (st >= 24 && st < 36)
         {
             move(4);
         }
         else if (st >= 36 && st < 48)
         {
             move(3);
         }
         else if (st >= 48 && st < 54)
         {
             move(2);
            // if (this != null)
             {
                // getWorld().removeObject(this);
             }
         }
         else if (st == 54)
         {
             getWorld().removeObject(this);
            }
         
    }    
    public int getDamage()
    {
        return damage;
    }
}