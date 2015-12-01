import greenfoot.*;

/**
 * Write a description of class ReturnToGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReturnToGame extends Clickables
{
    /**
     * Act - do whatever the ReturnToGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage box = new GreenfootImage(55,55);
    /**
     * Act - do whatever the ShurikenIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage button;
    public ReturnToGame()
    {
        button = getImage();
        button.setTransparency(125);
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
