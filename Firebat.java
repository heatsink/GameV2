import greenfoot.*;
import java.util.*;

/**
 * Functionality in this class:
 */
public class Firebat extends MeleeMinion //RM Stands for Ranged Minion
{
    //RangedMinion redrm = new RangedMinion();
    // Sprite taken from http://www.spriters-resource.com/arcade/ghoulsnghosts/sheet/65558/
    private GreenfootImage batMove1 = new GreenfootImage("Bat/Bat1.png");
    private GreenfootImage batMove2 = new GreenfootImage("Bat/Bat2.png");
    private GreenfootImage batMove3 = new GreenfootImage("Bat/Bat3.png");
    private GreenfootImage batHit = new GreenfootImage("Bat/BatHit.png");
    private int frame = 0;
    private int delay = 0;
    private boolean animating = true;
    private int animatingTimer = 0;
    public Firebat(int RMHP, int damage)
    {
        super(RMHP, damage);
    }
    public void act() 
    {
       resetAnimation();
       animate();
       detect();
       ninjaattack();
       RMDied();
    }    
    public void animate()
    {
        if (animating == true)
        {
        frame++;
        }
        if (frame == 1)
        {
            setImage(batMove1);
        }
        
        if (frame == 10)
        {
            setImage(batMove2);
        }
        
        if (frame == 20)
        {
            setImage(batMove3);
        }
        
        if (frame >= 30)
        {
            frame = 0;
        }
        
    }
    public void resetAnimation()
    {
        if (animating == false)
        {
            animatingTimer++;
        }
        if (animatingTimer >= 30)
        {
            animating = true;
            animatingTimer = 0;
        }
    }
    public void ninjaattack(){
        // if (delay >=60){         
        Shuriken shuriken =(Shuriken) getOneIntersectingObject(Shuriken.class);
        Actor lightning = getOneIntersectingObject(Lightning.class);
        if (shuriken != null && delay==0){
            Trap trap = (Trap) getWorld();
            {
                RMHP = RMHP-shuriken.getDamage();
                setImage(batHit);
                animating = false;
                delay = 11; 
            }
        }
        else if(lightning != null && delay==0)
        {
        Trap trap = (Trap) getWorld();
            if (trap.getNinja() != null)
            {
                if(trap.getNinja().getPower3())
                {
                    RMHP = RMHP-trap.getNinja().getMeleeDamage()*2;
                    delay = 11;
                    setImage(batHit);
                    animating = false;
                    trap.getNinja().setPower(trap.getNinja().getPower()-25);
                }
                else
                {
                    RMHP = RMHP-trap.getNinja().getMeleeDamage();
                    setImage(batHit);
                    animating = false;
                    delay = 11;
                }
        }
        }
        else if(delay>0){
            delay--;
        }
    }
    public void RMDied()
    {
        if (RMHP <= 0)
        {
            Trap trap = (Trap) getWorld();
            trap.getNinja().setPoints(trap.getNinja().getPoints()+1);
            SmokeFireball smokeFireball = new SmokeFireball();
            getWorld().addObject(smokeFireball, getX(), getY());
            getWorld().removeObject(this);
        }
    }
    public void detect()
    {
        List<Ninja> list = getObjectsInRange(200, Ninja.class);
        if (list.size()>0)
        {
            frame++;
            turnTowards(list.get(0).getX(), list.get(0).getY());
            move(14);
            if(getOneIntersectingObject(InfernoFence.class)!=null)
            {
                move(-14);
            }
            else
                move(-13);
            setRotation(0);
        }
               
    }
}
