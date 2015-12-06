// Sean's class
/**
 * Sean - Made slight modifications to the imported counter class to function as the power bar
 */
import greenfoot.*;
import java.awt.Color;
public class PowerCounter extends Counter
{
    public static final Color transparent = new Color(0,0,0,0);
    
    public int value;
    public int target;
    public String prefix;
    
    public PowerCounter()
    {
        this(new String());
    }
    public PowerCounter(String prefix)
    {
        value = 0;
        target = 0;
        this.prefix = prefix;
        updateImage();
    }
    public void act() 
    {
        if (value < target) {
            value++;
            updateImage();
        }
        else if (value > target) {
            value--;
            updateImage();
        }
    }
    public void add(int score)
    {
        target += score;
    }
    public int getValue()
    {
        return target;
    }
    public void setValue(int newValue)
    {
        target = newValue;
        value = newValue;
        updateImage();
    }
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
        updateImage();
    }
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(200,40);
        GreenfootImage text = new GreenfootImage(prefix + value, 22, Color.WHITE, transparent);
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }
        image.drawRect(0,0,200,38);
        image.setColor(Color.BLUE);
        image.fillRect(1,1,target*2, 38);
                        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, (image.getHeight()-text.getHeight())/2);
                        
        setImage(image);
    }
}
