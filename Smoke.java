import greenfoot.*;

/**
 * Functionality in this class:
 */
public class Smoke extends Objects
{
    // Sprite taken from http://www.flamesofwar.com/hobby.aspx?art_id=2876
    private int speed;
    public Smoke(int speed)
    {
        this.speed = speed;
    }
    public void act() 
    {
        move(speed);
        RemoveCloud();
    }    

    public void RemoveCloud()
    {
        if (getX() >= 1000)
        {
            getWorld().removeObject(this);
        }
    }
}
