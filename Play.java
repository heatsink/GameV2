// Sean's class (originally hayden's and changed almost completely)
import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Clickables
{
    /**
     * Act - do whatever the Play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound mainMenuTheme;
    //http://soundbible.com/tags-bounce.html
    GreenfootSound clickSound = new GreenfootSound("Bounce-SoundBible.com-12678623.mp3");
    GreenfootImage button;
    public Play(GreenfootSound mainMenuTheme)
    {
        button = getImage();
        this.mainMenuTheme = mainMenuTheme;
    }
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)){
            mainMenuTheme.stop();
            clickSound.play();
            button.setTransparency(125);
            setImage(button);
            Greenfoot.delay(80);
            Greenfoot.setWorld(new Cinematic(new Kyobashi(new Ninja())));
            
        }
        checkMouse();
            if (checkMouse() == true)
            {
                button.setTransparency(200);
            }
            else
            {
                button.setTransparency(255);
            }
            setImage(button);
    }    
    public boolean checkMouse()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null)
        {
            if (mi.getX() >= 374-(317/2)+125 && mi.getX() <= 374+(317/2)+125 && mi.getY() >= 469-(124/2) && mi.getY() <= 469+(124/2))
            {
                return true;
                
            }
        }
        return false;
    }
}
