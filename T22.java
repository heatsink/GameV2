import greenfoot.*;
import java.util.*;//bill
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
    public T22(Ninja ninja)//bill
    {
        super();
        billin.setVolume(40);
        this.ninja = ninja;
        prepare();
    }

    private void prepare()//bill
    {
        doorT21 doort21 = new doorT21();
        addObject(doort21, 625, 125);
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
        addObject(instaPower1, 525, 675-50);
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
        addObject(ninja, 75, 675-50);
        makeAllIcons();
        npcs = getObjects(NPCS.class);
        for(int i = 0; i<npcs.size(); i++)
        {
            TempText9 text = new TempText9(npcs.get(i));
            addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
        }
            HealthGlobe healthglobe = new HealthGlobe();
        addObject(healthglobe, 674, 578);
        healthglobe.setLocation(674, 569);
        HealthGlobe healthglobe2 = new HealthGlobe();
        addObject(healthglobe2, 72, 319);
        healthglobe2.setLocation(71, 325);
        HealthGlobe healthglobe3 = new HealthGlobe();
        addObject(healthglobe3, 228, 365);
        healthglobe3.setLocation(224, 370);
}

    public void act()//bill
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
    public void makeAllIcons()//sean
    {
        SwordIcon swordicon = new SwordIcon();
        addObject(swordicon, 889, 360);
        ShurikenIcon shurikenicon = new ShurikenIcon();
        addObject(shurikenicon, 838, 360);
        DashIcon dashicon = new DashIcon();
        addObject(dashicon, 819, 308);
    }
   public void checkDoorT21()//bill
    {
         if(ninja.checkDoorT21()==true)
         {
             billin.stop();
            Greenfoot.setWorld(new T23(ninja));
        }
   }
    public void checkTeleport(){//bill
        if(ninja.checkTeleport())
        {
            ninja.setLocation(75, 625);
        }
    }
    public Ninja getNinja()//bill
    {
        return ninja;
    }

    public Trap getThisWorld()//bill
    {
        return this;
    }
       public void gameover(){//Hayden
       ninja.setHP(ninja.getArmor());
       Greenfoot.setWorld(new T22(ninja));
    }
}