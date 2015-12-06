// Sean's class
import greenfoot.*;

/**
 * Write a description of class Keyboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Keyboard extends Clickables
{
    /**
     * Act - do whatever the Keyboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int value = -10;
    private int frame = 0;
    private GreenfootImage w = new GreenfootImage("Keyboards/KeyboardW.png");
    private GreenfootImage a = new GreenfootImage("Keyboards/KeyboardA.png");
    private GreenfootImage s = new GreenfootImage("Keyboards/KeyboardS.png");
    private GreenfootImage d = new GreenfootImage("Keyboards/KeyboardD.png");
    public void act() 
    {
        if (Greenfoot.isKeyDown("w"));
        {
            value++;
        }
        if (value > 1)
        {
            animateMoveKeys();
        }
        //animateMoveKeys();
    }    
    public void animateMoveKeys()
    {
        
        frame ++;
        if (frame == 1)
        {
        setImage(w);
        }
        else if (frame == 5)
        {
        setImage(a);
        }
        else if (frame == 10)
        {
        setImage(s);
        }
        else if (frame == 15)
        {
        setImage(d);
        }
        else if (frame == 20)
        {
            frame = 0;
        }
        
    }
}
