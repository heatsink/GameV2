// Hayden's entire class
import greenfoot.*;
import java.util.*;

/**
 * Write a description of class DashBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DashBoss extends Bosses
{
    public int dashtimer = 0;
    public int DBHP;
    
    int delay = 0;
    int delay2 =0;
    private int imageTimer;
    
    
    
    //http://finalfantasy.wikia.com/wiki/Ghost_(Final_Fantasy_VI_Character)(GBA FINAL FANTASY)
    public DashBoss(int DBHP){
               this.DBHP = DBHP;
        //this.damage = damage;
        
    }
    /**
     * Act - do whatever the DashBoss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        DBHPreturn();
        ninjaattack();
        dashtimer++;
        enact();
        detect();
        switchImage();
        DBDied();
        
    }    
       public void detect()
    {
        List<Ninja> list = getObjectsInRange(5000, Ninja.class);
        if (list.size()>0&&delay>100)
        {
            turnTowards(list.get(0).getX(), list.get(0).getY());
            double x = getRotation();
            DashDarkness darkness = new DashDarkness(Greenfoot.getRandomNumber(5)+2);
            getWorld().addObject(darkness, getX(), getY());
            darkness.turnTowards(list.get(0).getX(), list.get(0).getY());
            delay = 0;
            setRotation(0);
            setImage("Images/DashBoss/TP1.png");
        }
        delay++;  
    }
    
    public void dashAround(){
        dashtimer++;
        if (dashtimer >= 200){
            setRotation(dashturn());
            move(400);
            dashtimer =0;
            }
        
        
        }
        
    public int dashturn(){
            if(getX()>=375 && getY()>=375){
            if (Greenfoot.getRandomNumber(100) >= 50){
                return(180);
            }else{
                return(-90);
            }
        }
        
            if(getX()< 375 && getY()>=375){
            if (Greenfoot.getRandomNumber(100) >= 50){
                return(0);
            }else{
                return(-90);
            }
        }
        
            if(getX()< 375 && getY()<375){
            if (Greenfoot.getRandomNumber(100) >= 50){
                return(0);
            }else{
                return(90);
            }
        }
        
            if(getX()>=375 && getY()< 375){
            if (Greenfoot.getRandomNumber(100) >= 50){
                return(180);
            }else{
                return(90);
            }
        }
        
        else{
            return(-90);
        }
    }
    
    public void dashmove(){
            if(getX()>=375 && getY()>=375){
            if (Greenfoot.getRandomNumber(100) >= 50){
                setLocation(200, 550);
            }else{
                setLocation(550, 200);
            }
        }
        
            else if(getX()<= 375 && getY()>=375){
            if (Greenfoot.getRandomNumber(100) >= 50){
                setLocation(550, 550);
            }else{
                setLocation(200, 200);
            }
        }
        
          else  if(getX()<= 375 && getY()<=375){
            if (Greenfoot.getRandomNumber(100) >= 50){
                setLocation(200, 550);
            }else{
                setLocation(550, 200);
            }
        }
        
           else if(getX()>=375 && getY()<=375){
            if (Greenfoot.getRandomNumber(100) >= 50){
                setLocation(550,550);
            }else{
                setLocation(200, 200);
            }
        }
    }
    public void enact(){
        
        //if (dashtimer >195 && dashtimer <199){
            //setImage("Image/DashBoss/Port.png");
        //}
        if (dashtimer>=200){
            dashmove();
            
            dashtimer=0;
        }
    }
    
        private void switchImage() 
    {
        int span = 20; // cycles between image changes
        int imgCt = 4; // total number of images
        imageTimer++; // increment timer
        if (imageTimer == span) setImage("Images/Frame1.png");
        if (imageTimer == 2*span) setImage("Images/DashBoss/Frame2.png");
        if (imageTimer == 3*span) setImage("Images/Frame1.png");
        if (imageTimer == 4*span) setImage("Images/DashBoss/Frame4.png");
        if (imageTimer == 5*span) imageTimer=0;;
    }
    public void ninjaattack(){
       // if (delay2 >=60){         
            Actor shuriken = getOneIntersectingObject(Shuriken.class);
            Actor lightning = getOneIntersectingObject(Lightning.class);
            if (shuriken != null && delay2==0){
             Trap trap = (Trap) getWorld();
             DBHP = DBHP-trap.getNinja().getRangeDamage();
             PurpleBlood purpleBlood = new PurpleBlood();
             getWorld().addObject(purpleBlood, getX(), getY());
             delay2 = 11;
            }
            else if(lightning != null && delay2==0)
            {
                Trap trap = (Trap) getWorld();
                DBHP = DBHP-trap.getNinja().getMeleeDamage();
                delay2 = 11;
            }
            else if(delay2>0){
           delay2--;
           }
        
    }
    public void DBDied()
    {
        if (DBHP <= 0)
        {
            Trap trap = (Trap) getWorld();
            trap.getNinja().setPoints(trap.getNinja().getPoints()+5);
            doorT10 door = new doorT10();
            getWorld().addObject(door, 375, 660);
            getWorld().removeObject(this);
        }
    }
    /*public int getDamage()
    {
        return damage;
    }
    public int getHealth()
    {
        return DBHP;
    }
    /*public DBCS getThis()
    {
        return this;
    }
    */
   public int DBHPreturn(){
       return DBHP;
    }
    
    public int getHealth(){
        return DBHP;
    }
    
        public DashBoss getThis()
    {
        return this;
    }
}
