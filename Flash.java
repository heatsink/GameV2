import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Flash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flash extends Animated//Hayden
{
    /**
     * Act - do whatever the Flash wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Flash()
    {
        GreenfootImage Flash = new GreenfootImage(1000, 1000);
        //HUD.drawRect(0,0,150,750);
        Flash.setColor(Color.WHITE);
        Flash.fillRect(1,1,1000, 1000);
        setImage(Flash);
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
