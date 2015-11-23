import greenfoot.*;

/**
 * Write a description of class InfernoBoss1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InfernoBoss1 extends Animated
{
    private int shaketime = 0;
    private int CountShake = 0;
    /**
     * Act - do whatever the InfernoBoss1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        CountShake++;
        switchImage();
        
    }    
    private void switchImage() 
    {
        
        int span = 7; // cycles between image changes
        int imgCt = 4;
        if (CountShake > 201){
        shaketime++;
        
        if (shaketime == span) setImage("Images/CinBos1.png");
        if (shaketime == 2*span) setImage("Images/stand_0.png");
        if (shaketime == 3*span) setImage("Images/CinBos2.png");
        if (shaketime == 4*span) setImage("Images/stand_0.png");
        if (shaketime == 5*span) shaketime=0;
       }
    }
}

