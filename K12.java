import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class K12 extends Trap
{
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    private List<Bosses> dashboss;
    Ninja ninja;
    int delay = 11;
    static boolean played = false;
    private int counterDelay = 0;
    GreenfootSound finalmusic = new GreenfootSound("lowdowninstramental.mp3");
    public K12(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        prepare();
    }

    private void prepare()
    {
        for(int i = 0; i<15; i++)
            for(int j = 0; j<2; j++)
            {
            Fence fence = new Fence();
            addObject(fence, 25+j*700, 50*i+25);
            }
        for(int i = 1;i<15; i++)
            for(int j = 0; j<2; j++)
            {
                Fence fence = new Fence();
                addObject(fence, 50*i+25, 25+j*(700-50));
            }
        
        
       addObject(ninja, 375, 375);
            
       
        DashBoss dashboss = new DashBoss(20);
        addObject(dashboss, 200, 200);
        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        addObject(levelCounter, 950, 15);
        levelCounter.setValue(1);
        
        Fence fence77 = new Fence();
        addObject(fence77, 335, 384);
        Fence fence78 = new Fence();
        addObject(fence78, 436, 384);
        
        HealthGlobe hg = new HealthGlobe();
        addObject(hg, 90, 90);
                HealthGlobe hg1 = new HealthGlobe();
        addObject(hg1, 660, 660-50);
        
        
        makeAllIcons();
       
           TempText3 text = new TempText3(dashboss);
           addObject(text, dashboss.getX(), dashboss.getY()-20);
       
    }
    public void act()
    {
        
        createdoor();
        counterDelay++;
        if (!played){
            finalmusic.playLoop();
            played = !played;
        }
       if (Greenfoot.isKeyDown("h")&&delay>10) 
       {
           Menu menu = new Menu(getThisWorld());
           Greenfoot.setWorld(menu);
           delay = 0;
           
       }
        if(getObjects(Ninja.class).size() != 0&& counterDelay >= 10)
        {
        checkDoor();
        healthCounter.setValue(ninja.getNINJAHP());
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
        powerCounter.setValue(ninja.getPOWERBAR());
        counterDelay-= 10;
        /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       
       /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       }
       delay++;
    }
    public void checkDoor()
    {
        if(ninja.checkDoor()==true){
            
            Greenfoot.setWorld(new Kyobashi1(ninja));}
    }
   public Ninja getNinja()
   {
       return ninja;
   }
   public Trap getThisWorld()
   {
       return this;
   }
       public void gameover(){
       ninja.setHP(ninja.getArmor());
       Greenfoot.setWorld(new K12(ninja));
    }
    public boolean isbossthere(){
        List<Bosses> list = getObjects(DashBoss.class);
        if (list.size() >0){
            return true;
        }
        else{
            return false;
        }
    }
        
    public void createdoor(){
        if(isbossthere() == false){
            finalmusic.stop();
        doorT10 doort10 = new doorT10();
        addObject(doort10, 375, 660);
        if(ninja.getProgress()==0)
        ninja.setProgress(1);
         finalmusic.stop();
        }
    }
   }

