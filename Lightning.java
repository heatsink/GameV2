import greenfoot.*;
//Bill's class
/**
 * Functionality in this class:
 */
public class Lightning extends Projectiles
{
    private double creationTime;
    private int xDifference;
    private int yDifference;
    private int swordRotation;
    boolean created = false;
    boolean real;
    private GreenfootImage sword = new GreenfootImage("Sword.png");
    int delay = 10001;
    public Lightning(int swordRotation)
    {
        creationTime = System.currentTimeMillis();
        setImage(sword);
        this.swordRotation = swordRotation;
        sword.rotate(swordRotation - 45);
    }
    
    public void creation()
    {
            Trap trap = (Trap) getWorld();
            if (trap.getNinja() != null)
            {
            xDifference = trap.getNinja().getX()-this.getX();
            yDifference = trap.getNinja().getY()-this.getY();
        }
            if (trap.getBoy() != null)
            {
                xDifference = trap.getBoy().getX()-this.getX();
            yDifference = trap.getBoy().getY()-this.getY();
            }
            created = true;
            real = true;
    }
    
    public void act() 
    {
        if(!created)
            creation();
        Actor NPCS = getOneIntersectingObject(NPCS.class);
            if (NPCS!=null&&delay>10000){
                getWorld().removeObject(this);
                real = false;
                delay = 0;
            }
        if(real)
        {
            Trap trap2 = (Trap) getWorld();
            if (trap2.getNinja() != null)
            {
            setLocation(trap2.getNinja().getX()-xDifference,trap2.getNinja().getY()-yDifference);
        }
            if (trap2.getBoy() != null)
            {
                setLocation(trap2.getBoy().getX()-xDifference,trap2.getBoy().getY()-yDifference);
            }
            if((System.currentTimeMillis()-creationTime)>100)
                getWorld().removeObject(this);
        }
        delay++;
    }    
}