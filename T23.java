import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class T23 extends Trap
{
    static boolean played = false;
    GreenfootSound billin = new GreenfootSound("billin.mp3");
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    private List<NPCS> npcs;
    private int counterDelay = 0;
    Ninja ninja;
    int delay = 11;
    public T23(Ninja ninja)
    {
        super();
        billin.setVolume(40);
        this.ninja = ninja;
        prepare();
    }

    private void prepare()
    {
        doorT21 doort21 = new doorT21();
        addObject(doort21, 125-25, 625-25);
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
        for(int i = 1; i<7; i++)
        {
            Teleport teleport = new Teleport();
            addObject(teleport, 100*i+25, 100*i+25);
        }
        for(int i = 1; i<6; i++)
        {
            ForestRange bluerm = new ForestRange(2, 2);
            addObject(bluerm, 100*i+75, 100*i+75);
        }
        for(int i = 1; i<8; i++)
        {
            Stump fence = new Stump();
            addObject(fence, 50*i+25, 50*i+225); 
        }
        for(int i = 2; i<11; i++)
        {
            Stump fence = new Stump();
            addObject(fence, 50*i+175, 50*i+25);
        }
        instaPower instaPower1 = new instaPower();
        addObject(instaPower1, 325, 425);
        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        addObject(levelCounter, 950, 15);
        levelCounter.setValue(23);
        addObject(ninja, 675, 75);
        makeAllIcons();
        npcs = getObjects(NPCS.class);
        for(int i = 0; i<npcs.size(); i++)
        {
            TempText9 text = new TempText9(npcs.get(i));
            addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
        }
        HealthGlobe healthglobe = new HealthGlobe();
        addObject(healthglobe, 142, 268);
        healthglobe.setLocation(132, 267);
        HealthGlobe healthglobe2 = new HealthGlobe();
        addObject(healthglobe2, 381, 517);
        healthglobe2.setLocation(382, 520);
        addShuriken addshuriken = new addShuriken();
        addObject(addshuriken, 336, 125);
        addshuriken.setLocation(326, 127);
    }

    public void act()
    {
        counterDelay++;
         if(!played)
        {
        billin.playLoop();
        played = !played;
        }
        checkTeleport();
        if (Greenfoot.isKeyDown("h")&&delay>10) 
        {
            clickSound.play();
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
            ninja.setLocation(625, 75);
        }
    }
    public void checkDoorT21()
    {
         if(ninja.checkDoorT21()==true)
         {
            billin.stop();
             Greenfoot.setWorld(new T24(ninja));
            
        }
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
       Greenfoot.setWorld(new T23(ninja));
    }
}