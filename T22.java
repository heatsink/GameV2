import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class T22 extends Trap
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
    public T22(Ninja ninja)
    {
        super();
        billin.setVolume(40);
        this.ninja = ninja;
        prepare();
    }

    private void prepare()
    {
        doorT21 doort21 = new doorT21();
        addObject(doort21, 625, 125);
        for(int i = 0; i<15; i++)
            for(int j = 0; j<2; j++)
            {
                Stump fence = new Stump();
                addObject(fence, 25+j*700, 50*i+25);
        }
        for(int i = 1;i<15; i++)
            for(int j = 0; j<2; j++)
            {
                Stump fence = new Stump();
                addObject(fence, 50*i+25, 25+j*(700-25));
        }
        for(int i = 1; i<13; i++)
        {
            Teleport teleport = new Teleport();
            addObject(teleport, 50*i+25, 575);
        }
        for(int i = 1; i<13; i++)
        {
            ForestRange bluerm = new ForestRange(2, 2);
            addObject(bluerm, 50*i+25, 525);
        }
        for(int i = 2; i<14; i++)
        {
            Stump fence = new Stump();
            addObject(fence, 50*i+25, 325);
        }
        ForestBat blackmm1 = new ForestBat(2, 2);
        addObject(blackmm1,475, 75);
        ForestBat blackmm2 = new ForestBat(2, 2);
        addObject(blackmm2, 475, 275); 
        Teleport teleport1 = new Teleport();
        Teleport teleport2 = new Teleport();
        Teleport teleport3 = new Teleport();
        Teleport teleport4 = new Teleport();
        instaPower instaPower1 = new instaPower();
        instaPower instaPower2 = new instaPower();
        instaPower instaPower3 = new instaPower();
        addObject(instaPower1, 525, 675);
        addObject(instaPower2, 375, 425);
        addObject(teleport1, 75, 475);
        addObject(teleport2, 225, 425);
        addObject(teleport3, 375, 375);
        addObject(teleport4, 525, 425);
        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        addObject(levelCounter, 950, 15);
        levelCounter.setValue(22);
        addObject(ninja, 75, 675);
        npcs = getObjects(NPCS.class);
        for(int i = 0; i<npcs.size(); i++)
        {
            TempText2 text = new TempText2(npcs.get(i));
            addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
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
        checkTeleport();
        if (Greenfoot.isKeyDown("h")&&delay>10) 
        {
            Menu menu = new Menu(getThisWorld());
            Greenfoot.setWorld(menu);
            delay = 0;

        }
        if(getObjects(Ninja.class).size() != 0 && counterDelay >= 10)
        {
            checkDoorT21();
            healthCounter.setValue(ninja.getNINJAHP());
            shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
            powerCounter.setValue(ninja.getPOWERBAR());
            counterDelay-= 10;
            /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 

            /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
        }
        delay++;
    }

   public void checkDoorT21()
    {
         if(ninja.checkDoorT21()==true)
         {
             billin.stop();
            Greenfoot.setWorld(new T23(ninja));
        }
   }
    public void checkTeleport(){
        if(ninja.checkTeleport())
        {
            ninja.setLocation(75, 675);
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
       Greenfoot.setWorld(new T22(ninja));
    }
}