import greenfoot.*;
import java.awt.Color;
/**
 * Functionality in this class:
 */
public class TempText4 extends Actor
{
    private InfernoBoss infernoboss;
    public TempText4(InfernoBoss infernoboss) 
    {
        this.infernoboss = infernoboss;
    }    
    
    public void updateImage(String text)
    {
        setImage(new GreenfootImage(text, 18, Color.white, new Color(0,0,0,0)));
    }
    
    public void act()
    {
        try{
            setLocation(infernoboss.getX(), infernoboss.getY()-50);
        }catch(IllegalStateException e){}
        if(infernoboss!=null)
          updateImage(Integer.toString(infernoboss.getHealth()));
        if(infernoboss.getHealth()<1)
            getWorld().removeObject(this);
    }
}

