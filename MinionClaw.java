import greenfoot.*;

/**
 * Write a description of class MinionClaw here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinionClaw extends Juice
{
    
    // Sprite from http://powstudios.com/content/weapon-attack-animation-pack-1
    private GreenfootImage claw1 = new GreenfootImage("Claw/Claw1.png");
    private GreenfootImage claw2 = new GreenfootImage("Claw/Claw2.png");
    private GreenfootImage claw3 = new GreenfootImage("Claw/Claw3.png");
    private GreenfootImage claw4 = new GreenfootImage("Claw/Claw4.png");
    private GreenfootImage claw5 = new GreenfootImage("Claw/Claw5.png");
    private int frame = 1;
    public void act() 
    {
        animateBlood();
    }   
    public void animateBlood()
    {
        if (frame == 1)
            {
                setImage(claw1);
            }
            else if (frame == 4)
            {
                setImage(claw2);
            }
            else if (frame == 8)
            {
                setImage(claw3);
            }
            else if (frame == 12)
            {
                setImage(claw4);
            }
            else if (frame == 16)
            {
                setImage(claw5);
            }
            else if (frame == 20)
            {
                getWorld().removeObject(this);
            }
            frame++;
    }  
}
