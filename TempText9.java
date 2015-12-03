import greenfoot.*;
import java.awt.Color;
/**
 * Functionality in this class:
 */
public class TempText9 extends Actor
{
    private NPCS npcs;
    public TempText9(NPCS npcs) 
    {
        this.npcs = npcs;
    }    
    
    public void updateImage(String text)
    {
        setImage(new GreenfootImage(text, 18, Color.black, new Color(0,0,0,0)));
    }
    
    public void act()
    {
        try{
            setLocation(npcs.getX(), npcs.getY()-30);
        }catch(IllegalStateException e){}
        if(npcs!=null)
          updateImage(Integer.toString(npcs.getHealth()));
        if(npcs.getHealth()<1)
            getWorld().removeObject(this);
    }
}