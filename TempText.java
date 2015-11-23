import greenfoot.*;
import java.awt.Color;
/**
 * Functionality in this class:
 */
public class TempText extends Actor
{
    public TempText(String text) 
    {
        updateImage(text);
    }    
    
    public void updateImage(String text)
    {
        setImage(new GreenfootImage(text, 18, Color.black, new Color(0,0,0,0)));
    }
}
