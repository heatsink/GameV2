import greenfoot.*;

/**
 * Write a description of class SwordSwing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SwordSwing extends Juice
{
    
    // Sprite from http://powstudios.com/content/weapon-attack-animation-pack-1
    private GreenfootImage slice1 = new GreenfootImage("Slice/Slice1.png");
    private GreenfootImage slice2 = new GreenfootImage("Slice/Slice2.png");
    private GreenfootImage slice3 = new GreenfootImage("Slice/Slice3.png");
    private GreenfootImage slice4 = new GreenfootImage("Slice/Slice4.png");
    private GreenfootImage slice5 = new GreenfootImage("Slice/Slice5.png");
    private int frame = 1;
    
    public SwordSwing(int swordRotation)
    {
        setRotation(swordRotation);
    }
    public void act() 
    {
        animateBlood();
    }   
    public void animateBlood()
    {
        if (frame == 1)
            {
                setImage(slice1);
            }
            else if (frame == 2)
            {
                setImage(slice2);
            }
            else if (frame == 4)
            {
                setImage(slice3);
            }
            else if (frame == 6)
            {
                setImage(slice4);
            }
            else if (frame == 8)
            {
                setImage(slice5);
            }
            else if (frame == 10)
            {
                getWorld().removeObject(this);
            }
            frame++;
    }
}
