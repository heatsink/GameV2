// Sean's class
import greenfoot.*; 

/**
 * Functionality in this class:
 */
public class SecondFireball extends Projectiles
{
    private int st = 0;
    private int damage;
    GreenfootSound sliceSound = new GreenfootSound("DarknessSwish.mp3");

    //Sprite taken from http://www.spriters-resource.com/snes/stoneprotectors/sheet/39048/
    // (it's part of the lava monster sprite sheet)
    GreenfootSound fireballSound = new GreenfootSound("Flame Arrow-SoundBible.com-618067908.mp3");

    GreenfootImage fireball1 = new GreenfootImage("SecondFireball/SecondFireball1.png");
    GreenfootImage fireball2 = new GreenfootImage("SecondFireball/SecondFireball2.png");
    private double frame = 1;
    public SecondFireball(int damage)
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