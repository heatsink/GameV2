//Sean's class
import greenfoot.*; 

/**
 * Functionality in this class:
 */
public class DashDarkness extends Projectiles
{
    private int st = 0;
    private int damage;
    GreenfootSound sliceSound = new GreenfootSound("DarknessSwish.mp3");
    GreenfootImage darkness1 = new GreenfootImage("Darkness/Darkness1.png");
    GreenfootImage darkness2 = new GreenfootImage("Darkness/Darkness2.png");
    GreenfootImage darkness3 = new GreenfootImage("Darkness/Darkness3.png");
    GreenfootImage darkness4 = new GreenfootImage("Darkness/Darkness4.png");
    private double frame = 1;
    public DashDarkness(int damage)
    {
        setImage(darkness1);
        this.damage = damage;
    }

    public void act() 
    {
        if (frame == 1)
        {
            setImage(darkness1);
        }
        else if (frame == 3)
        {
            setImage(darkness2);
        }
        else if (frame == 5)
        {
            setImage(darkness3);
        }
        else if (frame == 7)
        {
            setImage(darkness4);
        }
        else if (frame == 9)
        {
            frame = 1;
            return;
        }
        frame+=0.25;

        Actor ninja = getOneIntersectingObject(Ninja.class);
        if (ninja != null){
            NinjaBlood ninjaBlood = new NinjaBlood();
            getWorld().addObject(ninjaBlood, getX(), getY());
            sliceSound.setVolume(80);
            sliceSound.play();
            getWorld().removeObject(this);
        }
        else if (atWorldEdge())
            getWorld().removeObject(this);
        st++;
        if (st >= 0 && st < 50)
        {
            move (4);
        }
        else if (st >= 50 && st < 65)
        {
            move(3);
        }
        else if (st >= 65 && st < 80)
        {
            move(2);
        }
        else if (st >= 80 && st < 95)
        {
            move(1);
        }
        else if (st >= 95 && st < 100)
        {
            move(1);
            try{
                getWorld().removeObject(this);
            }
            catch(Exception e)
            {
            }
        }
    }    

    public int getDamage()
    {
        return damage;
    }
}


