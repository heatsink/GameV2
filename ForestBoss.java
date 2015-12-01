import greenfoot.*;

/**
 * Write a description of class InfernoBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ForestBoss extends Bosses
{
    /**
     * Act - do whatever the InfernoBoss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int delay2 = 11;
    public int infernoBossHealth;
    
    // Sprite from http://www.spriters-resource.com/pc_computer/maplestory/sheet/69039/
    private GreenfootImage InfernoMove0 = new GreenfootImage("ForestGhost/Ghost1.png");
    private GreenfootImage InfernoMove1 = new GreenfootImage("ForestGhost/Ghost2.png");
    private GreenfootImage InfernoMove2 = new GreenfootImage("ForestGhost/Ghost3.png");
    private GreenfootImage InfernoMove3 = new GreenfootImage("ForestGhost/Ghost4.png");
    private GreenfootImage InfernoMove4 = new GreenfootImage("ForestGhost/Ghost5.png");
    private GreenfootImage InfernoMove5 = new GreenfootImage("ForestGhost/Ghost6.png");
    
    
    int delay = 0;
    private int counter = 0;
    private int counterBuffer = 100;
    public ForestBoss(int infernoBossHealth)
    {
        this.infernoBossHealth = infernoBossHealth;
    }

    public void act() 
    {
        getHealth();
        ninjaattack();
        
        if(delay<60)
        {
            getImage().setTransparency(250);
            move(5);
            setRotation(0);
            delay++;
        }
        if(delay>=60&&delay<120)
        {
            getImage().setTransparency(100);
            setRotation(90);
            move(5);
            setRotation(0);
            delay++;
        }
        if(delay>=120&&delay<180)
        {
            getImage().setTransparency(250);
            setRotation(180);
            move(5);
            setRotation(0);
            delay++;
        }
        if(delay>=180&&delay<240)
        {
            getImage().setTransparency(100);
            setRotation(270);
            move(5);
            setRotation(0);
            delay++;
        }
        if(delay>=240)
        delay = 0;
        animateSix(InfernoMove0, InfernoMove1, InfernoMove2, InfernoMove3, InfernoMove4, InfernoMove5);
        counter++;
        IBDied();
    }    
    public int getHealth(){
        return infernoBossHealth;
    }
    
        public ForestBoss getThis()
    {
        return this;
    }
    public void ninjaattack(){
       // if (delay2 >=60){         
            Actor shuriken = getOneIntersectingObject(Shuriken.class);
            Actor lightning = getOneIntersectingObject(Lightning.class);
            if (shuriken != null && delay2==0){
             Trap trap = (Trap) getWorld();
             infernoBossHealth = infernoBossHealth-trap.getNinja().getRangeDamage();
             PurpleBlood purpleBlood = new PurpleBlood();
             getWorld().addObject(purpleBlood, getX(), getY());
             delay2 = 11;
            }
            else if(lightning != null && delay2==0)
            {
                Trap trap = (Trap) getWorld();
                infernoBossHealth = infernoBossHealth-trap.getNinja().getMeleeDamage();
                PurpleBlood purpleBlood = new PurpleBlood();
                getWorld().addObject(purpleBlood, getX(), getY());
                delay2 = 11;
            }
            else if(delay2>0){
           delay2--;
           }
        
    }
    public void IBDied()
    {
        if (infernoBossHealth <= 0)
        {
            Trap trap = (Trap) getWorld();
            trap.getNinja().setPoints(trap.getNinja().getPoints()+5);
            doorT21 door = new doorT21();
            getWorld().addObject(door, 375, 650);
            getWorld().removeObject(this);
        }
    }
}
