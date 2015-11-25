import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inferno2 extends Trap
{
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    private List<NPCS> npcs;
    GreenfootSound burningSteppes = new GreenfootSound("Music of Cataclysm - Burning Steppes.mp3");
    
    Ninja ninja;
    int delay = 11;
    private int counterDelay = 0;
    public Inferno2(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        ninja.addPowerUp(4);
        prepare();
        burningSteppes.setVolume(40);
    }

    private void prepare()
    {
        for(int i = 0; i<14; i++)
            for(int j = 0; j<2; j++)
            {
                InfernoFence inferoFence = new InfernoFence();
                addObject(inferoFence, 25+j*700, 50*i+25);
        }
        for(int i = 1;i<14; i++)
            for(int j = 0; j<2; j++)
            {
                InfernoFence inferoFence = new InfernoFence();
                addObject(inferoFence, 50*i+25, j*650+25);
        }

        addObject(ninja, 75, 75);

        npcs = getObjects(NPCS.class);
        for(int i = 0; i<npcs.size(); i++)
        {
            TempText2 text = new TempText2(npcs.get(i));
            addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
        }

        for(int i = 0; i<7; i++)
        {
            InfernoFence infernoFence = new InfernoFence();
            addObject(infernoFence, 50*i+25, 175);
        }

        for(int i = 0; i<4; i++)
        {
            InfernoFence infernoFence = new InfernoFence();
            addObject(infernoFence, 500+50*i+25, /*175*/ 350 -50*i+25);
        }
        for(int i = 0; i<5; i++)
        {
            InfernoFence infernoFence = new InfernoFence();
            addObject(infernoFence, 50*i+25, /*175*/ 300+ 50*i+25);
        }
        InfernoDoor infernoDoor = new InfernoDoor();
        addObject(infernoDoor, 687-50, 687-100);

        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        addObject(levelCounter, 950, 15);
        levelCounter.setValue(2);
        Firebat firebat2 = new Firebat(8, 4);
        addObject(firebat2, 216, 350);
        Firebat firebat4 = new Firebat(8, 4);
        addObject(firebat4, 594-50, 617-50);
        Firebat firebat5 = new Firebat(8, 4);
        addObject(firebat5, 80, 515);
        Firebat firebat6 = new Firebat(8, 4);
        addObject(firebat6, 632, 145);

        
        LavaMonster lavamonster = new LavaMonster(5, 2, 0, 0, 600, 300);
        addObject(lavamonster, 443, 594);
        HealthGlobe healthglobe = new HealthGlobe();
        addObject(healthglobe, 79, 440);
        healthglobe.setLocation(75, 431);
        instaPower instapower = new instaPower();
        addObject(instapower, 78, 183+50);
        addShuriken addshuriken = new addShuriken();
        addObject(addshuriken, 681, 297);
        addshuriken.setLocation(676, 296);
        instaPower instapower2 = new instaPower();
        addObject(instapower2, 682, 80);
        makeAllIcons();
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
        burningSteppes.playLoop();
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
            Greenfoot.setWorld(new Inferno3(ninja));
            burningSteppes.stop();
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
       burningSteppes.stop();
       ninja.setHP(ninja.getArmor());
       Greenfoot.setWorld(new Inferno2(ninja));
       
    }
}