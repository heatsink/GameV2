// Sean's entire class
import greenfoot.*;

/**
 * Write a description of class TrainingDummy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrainingDummy extends MeleeMinion
{
    // http://www.spriters-resource.com/pc_computer/maplestory/sheet/21738/
    /**
     * Act - do whatever the TrainingDummy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage trainingDummy = new GreenfootImage("TrainingDummy.png");
    GreenfootImage hitTrainingDummy = new GreenfootImage("HitTrainingDummy.png");
    public TrainingDummy(int RMHP, int damage)
    {
        super(RMHP, damage);
        setImage(trainingDummy);
    }
    public void act() 
    {
        ninjaattack();
       RMDied();
    }    
    public void RMDied()
    {
        if (RMHP <= 0)
        {
            Trap trap = (Trap) getWorld();
            if (trap.getBoy() != null)
            {
            trap.getBoy().setPoints(trap.getBoy().getPoints()+1);
            }
            getWorld().removeObject(this);
        }
    }
}
