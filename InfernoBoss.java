// Sean's entire class
import greenfoot.*;

/**
 * Write a description of class InfernoBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InfernoBoss extends Bosses
{
    /**
     * Act - do whatever the InfernoBoss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int delay2 = 11;
    public int infernoBossHealth;
    
    // http://soundbible.com/tags-fireball.html
    
    // Sprite from http://www.spriters-resource.com/pc_computer/maplestory/sheet/69039/
    GreenfootSound spawn = new GreenfootSound("Depth Charge-SoundBible.com-320539466.mp3");
    private GreenfootImage InfernoMove0 = new GreenfootImage("InfernoBoss/move_0.png");
    private GreenfootImage InfernoMove1 = new GreenfootImage("InfernoBoss/move_1.png");
    private GreenfootImage InfernoMove2 = new GreenfootImage("InfernoBoss/move_2.png");
    private GreenfootImage InfernoMove3 = new GreenfootImage("InfernoBoss/move_3.png");
    private GreenfootImage InfernoMove4 = new GreenfootImage("InfernoBoss/move_4.png");
    private GreenfootImage InfernoMove5 = new GreenfootImage("InfernoBoss/move_5.png");
    private GreenfootImage InfernoMove6 = new GreenfootImage("InfernoBoss/move_6.png");
    private GreenfootImage InfernoMove7 = new GreenfootImage("InfernoBoss/move_7.png");
    
    private GreenfootImage InfernoStand0 = new GreenfootImage("InfernoBoss/stand_0.png");
    private GreenfootImage InfernoStand1 = new GreenfootImage("InfernoBoss/stand_1.png");
    private GreenfootImage InfernoStand2 = new GreenfootImage("InfernoBoss/stand_2.png");
    private GreenfootImage InfernoStand3 = new GreenfootImage("InfernoBoss/stand_3.png");
    private GreenfootImage InfernoStand4 = new GreenfootImage("InfernoBoss/stand_4.png");
    private GreenfootImage InfernoStand5 = new GreenfootImage("InfernoBoss/stand_5.png");
    private GreenfootImage InfernoStand6 = new GreenfootImage("InfernoBoss/stand_6.png");
    private GreenfootImage InfernoStand7 = new GreenfootImage("InfernoBoss/stand_7.png");
    
    
    
    private int counter = 0;
    private int counterBuffer = 100;
    public InfernoBoss(int infernoBossHealth)
    {
        spawn.setVolume(60);
        spawn.play();
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
        animateSeven(InfernoStand0, InfernoStand1, InfernoStand2, InfernoStand3, InfernoStand4, InfernoStand5, InfernoStand6, InfernoStand7);
        counter++;
        IBDied();
    }    
    public int getHealth(){
        return infernoBossHealth;
    }
    
        public InfernoBoss getThis()
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
            InfernoDoor infernoDoor = new InfernoDoor();
            getWorld().addObject(infernoDoor, 375, 575);
            getWorld().removeObject(this);
        }
    }
}
