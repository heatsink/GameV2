import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inferno3 extends Trap
{
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    GreenfootSound burningSteppes = new GreenfootSound("Music of Cataclysm - Burning Steppes.mp3");
    
    private List<NPCS> npcs;
    Ninja ninja;
    int delay = 11;
    private int counterDelay = 0;
    public Inferno3(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        addObject(ninja, 75, 75);
        ninja.addPowerUp(4);
        prepare();
        burningSteppes.setVolume(40);
    }

    private void prepare()
    {
        for(int i = 0; i<15; i++)
            for(int j = 0; j<2; j++)
            {
                InfernoFence inferoFence = new InfernoFence();
                addObject(inferoFence, 25+j*700, 50*i+25);
        }
        for(int i = 1;i<15; i++)
            for(int j = 0; j<2; j++)
            {
                InfernoFence inferoFence = new InfernoFence();
                addObject(inferoFence, 50*i+25, 25+j*700);
        }
        for(int i = 0; i<15; i++)
            for(int j = 0; j<2; j++)
            {
                InfernoFence inferoFence = new InfernoFence();
                addObject(inferoFence, 25+j*700, 50*i+25);
        }
        for(int i = 1;i<15; i++)
            for(int j = 0; j<2; j++)
            {
                InfernoFence inferoFence = new InfernoFence();
                addObject(inferoFence, 50*i+25, 25+j*700);
        }
        for(int i = 0; i<3; i++)
        {
            InfernoFence infernoFence = new InfernoFence();
            addObject(infernoFence, 50*i+25, 125);
        }
        for(int i = 0; i<5; i++)
        {
            InfernoFence infernoFence = new InfernoFence();
            addObject(infernoFence, 50*i+25, /*175*/ 500+ -50*i);
        }
        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        addObject(levelCounter, 950, 15);
        levelCounter.setValue(3);

        InfernoDoor infernodoor = new InfernoDoor();
        addObject(infernodoor, 71+50, 646-50);
        Firebat firebat = new Firebat(8, 4);
        addObject(firebat, 68+20, 324);
        Firebat firebat2 = new Firebat(8, 4);
        addObject(firebat2, 185+50, 609);
        Firebat firebat3 = new Firebat(8, 4);
        addObject(firebat3, 279, 458);
        Firebat firebat4 = new Firebat(8, 4);
        addObject(firebat4, 459, 569);
        npcs = getObjects(NPCS.class);
        for(int i = 0; i<npcs.size(); i++)
        {
            TempText2 text = new TempText2(npcs.get(i));
            addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
        }
        HealthGlobe healthglobe = new HealthGlobe();
        addObject(healthglobe, 80, 392);
        healthglobe.setLocation(76, 383);
        addShuriken addshuriken = new addShuriken();
        addObject(addshuriken, 677, 85);
        addshuriken.setLocation(676, 78);
        instaPower instapower = new instaPower();
        addObject(instapower, 277, 302);
        instapower.setLocation(275, 296);
        instaPower instapower2 = new instaPower();
        addObject(instapower2, 677, 647);
        LavaMonster lavamonster = new LavaMonster(5, 2, 275, 650, 0, 0);
        addObject(lavamonster, 279, 375);
        LavaMonster lavamonster3 = new LavaMonster(5, 2, 275, 650, 0, 0);
        addObject(lavamonster3, 649, 169);
        makeAllIcons();
    }

    public void act()
    {
        burningSteppes.playLoop();
        counterDelay++;
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
        /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       
       /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       }
       delay++;
       checkDoor();
    }
    public void makeAllIcons()
    {
        SwordIcon swordicon = new SwordIcon();
        addObject(swordicon, 889, 360);
        ShurikenIcon shurikenicon = new ShurikenIcon();
        addObject(shurikenicon, 838, 360);
        StealthIcon stealthicon = new StealthIcon();
        addObject(stealthicon, 923, 308);
        DashIcon dashicon = new DashIcon();
        addObject(dashicon, 819, 308);
        DoubleDamageIcon doubledamageicon = new DoubleDamageIcon();
        addObject(doubledamageicon, 871, 308);
    }
    public void checkDoor()
    {
        if(ninja.checkInfernoDoor()==true)
        {
            burningSteppes.stop();
            Greenfoot.setWorld(new Inferno4(ninja));
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
       burningSteppes.stop();
       Greenfoot.setWorld(new Inferno3(ninja));
    }
}