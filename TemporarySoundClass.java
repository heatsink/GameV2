import greenfoot.*;
/**
 * Functionality in this class:
 */

// This class was made to experiment with time
public class TemporarySoundClass extends Actor
{
    private double virtualTime = 0;
    private boolean isThemeSong = false;
    private boolean isThemeSong2 = false;
    
    public void act() 
    {
        virtualTime+= 1;
        if (isThemeSong == false && virtualTime >= 25)
        {
            isThemeSong = true;
            Greenfoot.playSound("Fable Theme.mp3");
        }
    }    
}