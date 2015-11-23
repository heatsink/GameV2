import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Lv1Melee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lv1Melee extends MeleeMinion
{
    private int imageTimer=0;
    //image cred http://getsuei-h.deviantart.com/art/Hydreigon-Overworld-Sprites-212062129
    /**
     * Act - do whatever the Lv1Melee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        imageTimer++;
        detect();
        ninjaattack();
        RMDied();
    }    
    public Lv1Melee(int RMHP, int damage){
        super(RMHP, damage);
    }
    public void whichswitch(){
        if (getRotation()>135 && getRotation() < 225){
            
            switchImage();
        }
         
        
    }
    public void whichswitch2(){
        if (getRotation()<45 || getRotation() > 315){
            
            switchImage1();
        }
    }
    public void whichswitch3(){
        if (getRotation()<135 && getRotation() > 45){
            
            switchImage2();
        }
    }
    public void whichswitch4(){
        if (getRotation()<315 && getRotation() > 225){
            
            switchImage3();
        }
    }
    
    private void switchImage() 
    {
        int span = 20; // cycles between image changes
        int imgCt = 2; // total number of images
        
        if (imageTimer == span) setImage("Images/Lv1Melee/left1.png");
        if (imageTimer == 2*span) setImage("Images/Lv1Melee/left2.png");
        if (imageTimer >= 5*span) imageTimer=0;
    }
    private void switchImage1() 
    {
        int span1 = 20; // cycles between image changes
        int imgCt = 2; // total number of images
        
        if (imageTimer == span1) setImage("Images/Lv1Melee/right1.png");
        if (imageTimer == 2*span1) setImage("Images/Lv1Melee/right2.png");
        if (imageTimer >= 5*span1) imageTimer=0;
    }
    private void switchImage2() 
    {
        int span2 = 20; // cycles between image changes
        int imgCt = 2; // total number of images
        
        if (imageTimer == span2) setImage("Images/Lv1Melee/Down1.png");
        if (imageTimer == 2*span2) setImage("Images/Lv1Melee/Down2.png");
        if (imageTimer >= 5*span2) imageTimer=0;
    }
    private void switchImage3() 
    {
        int span3 = 20; // cycles between image changes
        int imgCt = 2; // total number of images
        
        if (imageTimer == span3) setImage("Images/Lv1Melee/Up1.png");
        if (imageTimer == 2*span3) setImage("Images/Lv1Melee/Up2.png");
        if (imageTimer >= 5*span3) imageTimer=0;
    }
        public void detect()
    {
        List<Ninja> list = getObjectsInRange(200, Ninja.class);
        if (list.size()>0)
        {
            turnTowards(list.get(0).getX(), list.get(0).getY());
            move(8);
            if(getOneIntersectingObject(Fence.class)!=null)
                move(-8);
            else
                move(-7);
            whichswitch();
            whichswitch2();
            whichswitch3();
            whichswitch4();
        }
               
    }
    public void RMDied()
    {
        if (RMHP <= 0)
        {
            Trap trap = (Trap) getWorld();
            trap.getNinja().setPoints(trap.getNinja().getPoints()+1);
            getWorld().removeObject(this);
        }
    }
}
