import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inferno4 extends Trap
{
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    private List<NPCS> npcs;
    Ninja ninja;
    int delay = 11;
    private int counterDelay = 0;
    public Inferno4(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        ninja.addPowerUp(4);
        prepare();
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
        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        addObject(levelCounter, 950, 15);
        levelCounter.setValue(4);
        addObject(ninja, 75, 75);
        for(int i = 0; i<7; i++)
        {
            InfernoFence infernoFence = new InfernoFence();
            addObject(infernoFence, 50*i+25, 125);
        }
        for(int i = 0; i<4; i++)
        {
            InfernoFence infernoFence = new InfernoFence();
            addObject(infernoFence, 100+50*i+25+50, /*175*/ 375+ -50*i-50);
        }
        for(int i = 0; i<3; i++)
        {
            InfernoFence infernoFence = new InfernoFence();
            addObject(infernoFence, 400+50*i+25, /*175*/ 700+ -50*i);
        }
        InfernoDoor infernodoor = new InfernoDoor();
        addObject(infernodoor, 76+50+25, 226);
        addShuriken addshuriken = new addShuriken();
        addObject(addshuriken, 574, 678-35);
        instaPower instapower = new instaPower();
        addObject(instapower, 396, 188);
        Firebat firebat = new Firebat(8, 4);
        addObject(firebat, 61+15+25, 421+30-75);

        Firebat firebat2 = new Firebat(8, 4);
        addObject(firebat2, 402, 389);

        Firebat firebat4 = new Firebat(8, 4);
        addObject(firebat4, 704-40, 198);

        npcs = getObjects(NPCS.class);
        for(int i = 0; i<npcs.size(); i++)
        {
            TempText2 text = new TempText2(npcs.get(i));
            addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
        }
        addShuriken addshuriken2 = new addShuriken();
        addObject(addshuriken2, 113, 321);
        addshuriken2.setLocation(105, 317);
        HealthGlobe healthglobe = new HealthGlobe();
        addObject(healthglobe, 238, 335);
        healthglobe.setLocation(232, 328);
        instaPower instapower2 = new instaPower();
        addObject(instapower2, 681, 646);
        instapower2.setLocation(672, 641);
        instaPower instapower3 = new instaPower();
        addObject(instapower3, 226, 495);
        instapower3.setLocation(78, 649);
        HealthGlobe healthglobe2 = new HealthGlobe();
        addObject(healthglobe2, 678, 81);
        healthglobe2.setLocation(673, 80);
        LavaMonster lavamonster = new LavaMonster(5, 2, 75, 400, 0, 0);
        addObject(lavamonster, 85, 483);
        LavaMonster lavamonster2 = new LavaMonster(5, 2, 400, 675, 0, 0);
        addObject(lavamonster2, 401, 527);
        LavaMonster lavamonster3 = new LavaMonster(5, 2, 325, 675, 0, 0);
        addObject(lavamonster3, 326, 303);
        makeAllIcons();
    }

    public void act()
    {
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
            Greenfoot.setWorld(new InfernoBossLevel(ninja));
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
       Greenfoot.setWorld(new Inferno4(ninja));
    }
}