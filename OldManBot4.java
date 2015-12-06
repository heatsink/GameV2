import greenfoot.*;
import java.util.*;

/**
 * Write a description of class OldManBot4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OldManBot4 extends Animated//ALL HAYDEN
{
    public int omb4hp=1;
    private int delay = 0;
    private List<InfernoDoor> infernodoor;
    /**
     * Act - do whatever the OldManBot4 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        ninjaattack();
        OMB4Died();
    }    
    public void ninjaattack(){
        // if (delay >=60){         
        Shuriken shuriken =(Shuriken) getOneIntersectingObject(Shuriken.class);
        Actor lightning = getOneIntersectingObject(Lightning.class);
        if (shuriken != null && delay==0){
            Trap trap = (Trap) getWorld();
            {
                omb4hp = omb4hp-shuriken.getDamage();
                delay = 11; 
            }
        }
        else if(lightning != null && delay==0)
        {
            Trap trap = (Trap) getWorld();
            if(trap.getNinja().getPower3())
            {
                omb4hp = omb4hp-trap.getNinja().getMeleeDamage()*2;
                delay = 11;
                trap.getNinja().setPower(trap.getNinja().getPower()-25);
            }
            else
            {
                omb4hp = omb4hp-trap.getNinja().getMeleeDamage();
                delay = 11;
            }
        }
        else if(delay>0){
            delay--;
        }
        
    }
    public void OMB4Died(){
        if (omb4hp <= 0)
        {
            Trap trap = (Trap) getWorld();
            trap.getNinja().setPoints(trap.getNinja().getPoints()+50);
            
            InfernoDoor1 door1 = new InfernoDoor1();
            getWorld().addObject(door1, 800, 375);
            EndStoryKyo3 esk3= new EndStoryKyo3();
            
            infernodoor = getWorld().getObjects(InfernoDoor.class);
            if (infernodoor.size()>0){
                getWorld().removeObject(infernodoor.get(0));
                getWorld().removeObject(infernodoor.get(1));
                getWorld().removeObject(infernodoor.get(2));
                getWorld().removeObject(infernodoor.get(3));
                getWorld().removeObject(infernodoor.get(4));
                getWorld().removeObject(infernodoor.get(5));
                getWorld().removeObject(infernodoor.get(6));
                getWorld().removeObject(infernodoor.get(7));
                getWorld().removeObject(infernodoor.get(8));
                
                
            }
            
            getWorld().addObject(esk3, 620, 200);
            getWorld().removeObject(this);
            
        }
    }
}
