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
        
        if (counter >= 0 && counter < 75) // 1 unit +50 + 25
        {
            setLocation(getX(), getY() + 1);
        }
        if (counter >= 75 && counter < 150) // 1 unit + 50 + 25
        {
            setLocation(getX() - 1, getY());
        }
        if (counter >= 150 && counter < 300) //2 units + 100 + 50
        {
            setLocation(getX(), getY() - 1);
        }
        if (counter >= 300 && counter < 450) //2 units + 100 + 50
        {
            setLocation(getX() + 1, getY());
        }
        if (counter >= 450 && counter < 675) //3 units + 150 + 75
        {
            setLocation(getX(), getY() + 1);
        }
        if (counter >= 675 && counter < 900) //3 units + 150 + 75
        {
            setLocation(getX() - 1, getY());
        }
        if (counter >= 900 && counter < 1200) //4 units + 200 + 100
        {
            setLocation(getX(), getY() - 1);
        }
        if (counter >= 1200 && counter < 1500) //4 units + 200 + 100
        {
            setLocation(getX() + 1, getY());
        }
        if (counter >= 1500 && counter < 1650) //2 units + 100 + 50
        {
            setLocation(getX(), getY() + 1);
        }
        if (counter >= 1650 && counter < 1800) //2 units + 100 + 50
        {
            setLocation(getX() - 1, getY());
        }
        if (counter == 1800)
        {
            counter = 0;
        }
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
             delay2 = 11;
            }
            else if(lightning != null && delay2==0)
            {
                Trap trap = (Trap) getWorld();
                infernoBossHealth = infernoBossHealth-trap.getNinja().getMeleeDamage();
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
