/**
 * Sean - Made slight modifications to the imported counter class to function as the health bar
 */
import greenfoot.*;
import java.awt.Color;
public class HealthCounter extends Counter
{
    private Trap trap;
    private static final Color transparent = new Color(0,0,0,0);
    private int value;
    private int target;
    private String prefix;
    private double maxHealth = 1;
    private double coefficient = 1;
    private int rectangleLength = 200;
    
    public HealthCounter(Trap trap)
    {
    }
    public HealthCounter(Trap trap, String prefix)
    {
        value = 0;
        target = 0;
        this.prefix = prefix;
        this.trap = trap;
        updateImage();
    }
    public void act() 
    {
        if (trap.getNinja()!= null)
        {
        maxHealth = trap.getNinja().getArmor();
        }
        else if(trap.getBoy()!= null)
        {
            maxHealth = trap.getBoy().getArmor();
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
        coefficient =  target*(200/maxHealth);
        rectangleLength = (int) coefficient;
        GreenfootImage image = new GreenfootImage(200,40);
        GreenfootImage text = new GreenfootImage(prefix + value, 22, Color.WHITE, transparent);
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }
        image.drawRect(0,0,200,38);
        image.setColor(Color.RED);
        image.fillRect(1,1,rectangleLength, 38);
                        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
                        
        setImage(image);
    }
}
