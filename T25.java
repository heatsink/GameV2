import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class T25 extends Trap
{
    static boolean played = false;
    GreenfootSound billin = new GreenfootSound("billin.mp3");
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    private List<NPCS> npcs;
    private int counterDelay = 0;
    private boolean createdDoor = false;
    Ninja ninja;
    int delay = 11;
    public T25(Ninja ninja)
    {
        super();
        billin.setVolume(40);
        this.ninja = ninja;
        prepare();
    }

    private void prepare()
    {
        for(int i = 0; i<14; i++)
            for(int j = 0; j<2; j++)
            {
                Stump fence = new Stump();
                addObject(fence, 25+j*700, 50*i+25);
        }
        for(int i = 1;i<14; i++)
            for(int j = 0; j<2; j++)
            {
                Stump fence = new Stump();
                addObject(fence, 50*i+25, 25+j*(700-50));
        }
        BillBoss kyle = new BillBoss(5,25);
        addObject(kyle, 150, 150);
        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        addObject(levelCounter, 950, 15);
        levelCounter.setValue(25);
        addObject(ninja, 325, 325);
        makeAllIcons();
        npcs = getObjects(NPCS.class);
        for(int i = 0; i<npcs.size(); i++)
        {
            TempText5 text = new TempText5(npcs.get(i));
            addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-50);
        }
    }

    public void act()
    {
        counterDelay++;
         if(!played)
        {
        billin.playLoop();
        played = !played;
        }
        createdoor();
        checkTeleport();
        if (Greenfoot.isKeyDown("h")&&delay>10) 
        {
            Menu menu = new Menu(getThisWorld());
            Greenfoot.setWorld(menu);
            delay = 0;

        }
        if(getObjects(Ninja.class).size() != 0 && counterDelay >= 10)
        {
            healthCounter.setValue(ninja.getNINJAHP());
            shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
            powerCounter.setValue(ninja.getPOWERBAR());
            counterDelay-= 10;
            checkDoorT21();
            /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 

            /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
        }
        delay++;
    }
    public void makeAllIcons()
    {
        SwordIcon swordicon = new SwordIcon();
        addObject(swordicon, 889, 360);
        ShurikenIcon shurikenicon = new ShurikenIcon();
        addObject(shurikenicon, 838, 360);
        DashIcon dashicon = new DashIcon();
        addObject(dashicon, 819, 308);
    }
    public void checkTeleport(){
        if(ninja.checkTeleport())
        {
            ninja.setLocation(325, 325);
        }
    }

    public void checkDoor()
    {
    }

    public Ninja getNinja()
    {
        return ninja;
    }
    
    public void checkDoorT21()
    {
         if(ninja.checkDoorT21()==true)
         {
             billin.stop();
            Greenfoot.setWorld(new Kyobashi3(ninja));
        }
    }
    public Trap getThisWorld()
    {
        return this;
    }
       public void gameover(){
       ninja.setHP(ninja.getArmor());
       Greenfoot.setWorld(new T25(ninja));
    }
     public boolean isbossthere(){
        List<Bosses> list = getObjects(BillBoss.class);
        if (list.size() >0){
            return true;
        }
        else{
            return false;
        }
    }
     public void createdoor(){
        if(isbossthere() == false &&  createdDoor == false){
        doorT21 doort21 = new doorT21();
        addObject(doort21, 375, 660-50);
        if(ninja.getProgress()==1)
        ninja.setProgress(2);
        createdDoor = true;
        }
    }
}