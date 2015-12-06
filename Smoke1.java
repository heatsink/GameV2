import greenfoot.*;

/**
 * Write a description of class Smoke1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Smoke1 extends Objects//ALL HADYEN
{
    private int timec2=0;
    /**
     * Act - do whatever the Smoke1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        timec2++;
        if (timec2 > 200 && getX() >699){
                getWorld().removeObject(this);
        }
        if (timec2 > 250 && getX() >639){
                getWorld().removeObject(this);
        }
                if (timec2 > 300 && getX() >519){
                getWorld().removeObject(this);
        }
                if (timec2 > 350 && getX() >399){
                getWorld().removeObject(this);
        }
                if (timec2 > 400 && getX() >269){
                getWorld().removeObject(this);
        }
                if (timec2 > 450 && getX() >149){
                getWorld().removeObject(this);
        }
                if (timec2 > 500 && getX() >29){
                getWorld().removeObject(this);
        }
        
    }    
    
}
