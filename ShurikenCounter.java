// Sean's class
/**
 * Sean - Made slight modifications to the imported counter class to function as the shuriken bar
 */
import greenfoot.*;
import java.awt.Color;
public class ShurikenCounter extends Counter
{
    private Trap trap;
    private static final Color transparent = new Color(0,0,0,0);
    private int value;
    private int target;
    private String prefix;
    private double maxShurikens = 1;
    private double coefficient = 1;
    private int rectangleLength = 200;
    
    public ShurikenCounter(Trap trap)
    {
    }
    public ShurikenCounter(Trap trap, String prefix)
    {
        value = 0;
        target = 0;
        this.prefix = prefix;
        this.trap = trap;
        updateImage();
    }
    public void act() 
    {
        if (trap.getNinja() != null)
        {
        maxShurikens = trap.getNinja().getMaxShurikens();
        }
        else if (trap.getBoy() != null)
        {
            maxShurikens = trap.getBoy().getMaxShurikens();
        }
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
        coefficient =  target*(200/maxShurikens);
        rectangleLength = (int) coefficient;
        GreenfootImage image = new GreenfootImage(200, 40);
        GreenfootImage text = new GreenfootImage(prefix + value, 22, Color.WHITE, transparent);
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }
        image.drawRect(0,0,200,38);
        image.setColor(Color.BLACK);
        image.fillRect(1,1,rectangleLength, 38);
                        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
                        
        setImage(image);
    }
}
