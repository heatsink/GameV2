import greenfoot.*;
/**
 * Functionality in this class:
 */
public class Text extends Inanimate
{
    public Text(String message)
    {
        GreenfootImage text = new GreenfootImage(600, 150);
        text.drawString(message, 1, 10);
        setImage(text);
    }
    public void setText(String text)
    {
        GreenfootImage img = getImage();
        img.clear();
        img.drawString(text, 1, 10);
    }
    public void act() 
    {
    }    
}
