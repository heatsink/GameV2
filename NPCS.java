// Sean + Bill + Hayden wrote this class
import greenfoot.*;
/**
 * Functionality in this class:
 */
public class NPCS extends Actor
{
    public int RMHP;
    private int delay = 0;
    private int damage;
    private boolean doubleDamage = false;
    public NPCS(int RMHP, int damage)
    {
        this.RMHP = RMHP;
        this.damage = damage;
    }

    public NPCS()
    {

    }

    public void act() 
    {
        ninjaattack();
        RMDied();
        delay++;
    }    

    public void ninjaattack(){
        // if (delay >=60){         
        Shuriken shuriken =(Shuriken) getOneIntersectingObject(Shuriken.class);
        Actor lightning = getOneIntersectingObject(Lightning.class);
        Trap trap = (Trap) getWorld();
        if (shuriken != null && delay==0){
            
            {
                if (trap.getNinja()!= null){
                trap.getNinja().powerUpThreeFalse();}
                RMHP = RMHP-shuriken.getDamage();
                delay = 11; 
                PurpleBlood purpleBlood = new PurpleBlood();
                getWorld().addObject(purpleBlood, getX(), getY());
            }
        }
        else if(lightning != null && delay==0)
        {
        
            if (trap.getNinja() != null)
            {
                if(trap.getNinja().getPower3() )
                {
                    RMHP = RMHP-trap.getNinja().getMeleeDamage()*2;
                    delay = 11;
                    PurpleBlood purpleBlood = new PurpleBlood();
                    getWorld().addObject(purpleBlood, getX(), getY());
                }
                else
                {
                    trap.getNinja().powerUpThreeFalse();
                    RMHP = RMHP-trap.getNinja().getMeleeDamage();
                    delay = 11;
                    PurpleBlood purpleBlood = new PurpleBlood();
                    getWorld().addObject(purpleBlood, getX(), getY());
                }
        }
        
        
        
        
        
            if (trap.getBoy() != null)
        {
            if(trap.getBoy().getPower3())
            {
                RMHP = RMHP-trap.getBoy().getMeleeDamage()*2;
                delay = 11;
                //trap.getBoy().setPower(trap.getBoy().getPower()-25);
                PurpleBlood purpleBlood = new PurpleBlood();
                getWorld().addObject(purpleBlood, getX(), getY());
            }
            else
            {
                RMHP = RMHP-trap.getBoy().getMeleeDamage();
                delay = 11;
                PurpleBlood purpleBlood = new PurpleBlood();
                getWorld().addObject(purpleBlood, getX(), getY());
            }
        }
        
        
        
        
        }
        else if(delay>0){
            delay--;
        }

       }
    

    public void RMDied()
    {
        if (RMHP <= 0)
        {
            Trap trap = (Trap) getWorld();
            if (trap.getNinja() != null)
            {
            trap.getNinja().setPoints(trap.getNinja().getPoints()+1);
            }
            getWorld().removeObject(this);
        }
    }

    public int getDamage()
    {
        return damage;
    }

    public int getHealth()
    {
        return RMHP;
    }

    public NPCS getThis()
    {
        return this;
    }
}