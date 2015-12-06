// Sean's class
import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class HUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUD extends Clickables
{
    /**
     * Act - do whatever the HUD wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public HUD()
    {
        GreenfootImage HUD = new GreenfootImage(305, 775);
        //HUD.drawRect(0,0,150,750);
        HUD.setColor(Color.BLACK);
        HUD.fillRect(1,1,305, 775);
        setImage(HUD);
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
