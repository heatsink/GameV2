// Sean's class
import greenfoot.*;

/**
 * Write a description of class ArmPool here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArmPool extends Juice
{
    /**
     * Act - do whatever the ArmPool wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // Sprite from http://www.spriters-resource.com/pc_computer/maplestory/sheet/69039/
    // Note: Part of the same sprite zip file from the Inferno boss
    private GreenfootImage armPool0 = new GreenfootImage("ArmPool/ArmPool0.png");
    private GreenfootImage armPool1 = new GreenfootImage("ArmPool/ArmPool1.png");
    private GreenfootImage armPool2 = new GreenfootImage("ArmPool/ArmPool2.png");
    private GreenfootImage armPool3 = new GreenfootImage("ArmPool/ArmPool3.png");
    
    private int frame = 0;
    private boolean spawned = false;
    private boolean shootFireball;
    private int delay = 500;
    public ArmPool(boolean shootFireball)
    {
        this.shootFireball = shootFireball;
        setImage(armPool0);
    }
    public void act() 
    {
        if (spawned == false)
        {
            spawnPool();
            spawned = true;
        }
        else
        {
            animatePool();
        }
        if (Greenfoot.getRandomNumber(1000) < 4 && shootFireball == true)
        {
            SmokeFireball smokeFireball = new SmokeFireball();
            getWorld().addObject(smokeFireball, getX(), getY());
        }
        
    }    
    public void spawnPool()
    {
        frame ++;
        if (frame == 1)
        {
            setImage(armPool0);
        }
        if (frame == 15)
        {
            setImage(armPool1);
        }
        if (frame == 30)
        {
            setImage(armPool2);
        }
    }
    public void animatePool()
    {
        frame++;
        if (frame == 1)
        {
            setImage(armPool3);
        }
        else if (frame == 7)
        {
            setImage(armPool2);
        }
        else if (frame == 14)
        {
            frame = 0;
        }
    }
}
