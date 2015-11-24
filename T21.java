import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class T21 extends Trap
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
    public T21(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        billin.setVolume(40);
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
        for(int i = 1;i<15; i++)
            for(int j = 0; j<2; j++)
            {
                Stump fence = new Stump();
                addObject(fence, 50*i+25, 25+j*(700-50));
        }
        for(int i = 0; i<12; i++)
        {
            Stump fence = new Stump();
            addObject(fence, 75+i*50, 125);
        }
        for(int i = 0; i<12; i++)
        {
            Stump fence = new Stump();
            addObject(fence, 125+i*50, 325);
        }
        for(int i = 0; i<7; i++)
        {
            ForestRange rm = new ForestRange(2, 2);
            addObject(rm, 125+i*50, 275);
        }
        for(int i = 0; i<3; i++)
        {
            ForestRange rm = new ForestRange(2, 2);
            addObject(rm, 225+i*100, 225);
        }
        for(int i = 0; i<5; i++)
        {
            ForestBat fb = new ForestBat(2, 2); // Melee Minion
            addObject(fb, 125+i*100, 475);
        }
        for(int i = 0; i<6; i++)
        {
            Stump fence = new Stump();
            addObject(fence, 75+i*100, 425);
        }
        for(int i = 0; i<6; i++)
        {
            Stump fence = new Stump();
            addObject(fence, 75+i*100, 475);
        }
        for(int i = 0; i<11; i++)
        {
            Stump fence = new Stump();
            addObject(fence, 75+i*50, 525);
        }
        instaPower instaPower1 = new instaPower();
        addObject(instaPower1, 625, 75);
        instaPower instaPower2 = new instaPower();
        addObject(instaPower2, 575, 75);
        instaPower instaPower3 = new instaPower();
        addObject(instaPower3, 425, 175);
        instaPower instaPower4 = new instaPower();
        addObject(instaPower4, 225, 175);
        instaPower instaPower5 = new instaPower();
        addObject(instaPower5, 225, 375);
        instaPower instaPower6 = new instaPower();
        addObject(instaPower6, 425, 375);
        instaPower instaPower7 = new instaPower();
        addObject(instaPower7, 75, 375);
        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        addObject(levelCounter, 950, 15);
        levelCounter.setValue(21);
        addObject(ninja, 75, 75);
        makeAllIcons();
        npcs = getObjects(NPCS.class);
        for(int i = 0; i<npcs.size(); i++)
        {
            TempText2 text = new TempText2(npcs.get(i));
            addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
        }
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
    public void act()
    {
        counterDelay++;
        if(!played)
        {
        billin.playLoop();
        played = !played;
        }
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

    public void checkDoorT21()
    {
         if(ninja.checkDoorT21()==true)
         {
            billin.stop();
             Greenfoot.setWorld(new T22(ninja));
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
       billin.stop();
       ninja.setHP(ninja.getArmor());
       Greenfoot.setWorld(new T21(ninja));
    }
}