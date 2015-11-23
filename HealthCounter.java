/**
 * THIS IS THE IMPORTED COUNTER CLASS
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
        //this(new String());
    }

    /**
     * Create a new counter, initialised to 0.
     */
    public HealthCounter(Trap trap, String prefix)
    {
        value = 0;
        target = 0;
        this.prefix = prefix;
        this.trap = trap;
        updateImage();
    }
    
    /**
     * Animate the display to count up (or down) to the current target value.
     */
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

    /**
     * Add a new score to the current counter value.  This will animate
     * the counter over consecutive frames until it reaches the new value.
     */
    public void add(int score)
    {
        target += score;
    }

    /**
     * Return the current counter value.
     */
    public int getValue()
    {
        return target;
    }

    /**
     * Set a new counter value.  This will not animate the counter.
     */
    public void setValue(int newValue)
    {
        target = newValue;
        value = newValue;
        updateImage();
    }
    
    /**
     * Sets a text prefix that should be displayed before
     * the counter value (e.g. "Score: ").
     */
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
        updateImage();
    }

    /**
     * Update the image on screen to show the current value.
     */
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
