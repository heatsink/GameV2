import greenfoot.*;
import java.awt.Color;
/**
 * Functionality in this class:
 */
public class TempText6 extends Actor
{
    private Ninja ninja;
    int delay = 0;
    int damage;
    public TempText6(Ninja ninja, int damage) 
    {
        this.ninja = ninja;
        this.damage = damage;
    }    
    
    public void updateImage(int text)
    {
        setImage(new GreenfootImage("-" +text, 26, Color.red, new Color(0,0,0,0)));
    }
    
    public void act()
    {
        try{
            setLocation(ninja.getX(), ninja.getY()-40);
        }catch(IllegalStateException e){}
        if(ninja!=null)
          updateImage(damage);
        if(ninja.getHP()<1)
            getWorld().removeObject(this);
        else if(delay>25)
        getWorld().removeObject(this);
        delay++;
    }
}