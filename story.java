import greenfoot.*;
public class story extends Pictures
{
    int delay=0;
    public void act() //Duy + Sean
    {
        if (delay < 50)
        {
            delay++;
        }
        if (Greenfoot.isKeyDown("space") && delay>=30)
        {
            getWorld().removeObject(this);
        }
    }    
}