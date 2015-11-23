import greenfoot.*;
import java.awt.Color;
/**
 * Functionality in this class:
 */
public class TempText3 extends Actor
{
    private DashBoss dashboss;
    public TempText3(DashBoss dashboss) 
    {
        this.dashboss = dashboss;
    }    
    
    public void updateImage(String text)
    {
        setImage(new GreenfootImage(text, 18, Color.black, new Color(0,0,0,0)));
    }
    
    public void act()
    {
        try{
            setLocation(dashboss.getX(), dashboss.getY()-20);
        }catch(IllegalStateException e){}
        if(dashboss!=null)
          updateImage(Integer.toString(dashboss.getHealth()));
        if(dashboss.getHealth()<1)
            getWorld().removeObject(this);
    }
}
