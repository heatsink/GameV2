// Sean's entire class
import greenfoot.*;
import java.util.*;
/**
 * Sean's Level
 */
public class InfernoBossLevel extends Trap
{
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    private List<NPCS> npcs;
    private List<Bosses> infernoboss;
    Ninja ninja;
    private int delay = 11;
    private int fireballDelay = 11;
    private int counterDelay = 0;
    private int appleRespawn = 0;
    static boolean played = false;
    private GreenfootSound heavensGate = new GreenfootSound("Diablo 3 OST - Heaven's Gate (#20).mp3");
    public InfernoBossLevel(Ninja ninja)//Sean
    {
        super();
        this.ninja = ninja;
        prepare();
        heavensGate.setVolume(30);
        
    }
    
    private void prepare()//Sean
    {
        for(int i = 0; i<14; i++)
            for(int j = 0; j<2; j++)
            {
                InfernoFence inferoFence = new InfernoFence();
                addObject(inferoFence, 25+j*700, 50*i+25);
        }
        for(int i = 1;i<15; i++)
            for(int j = 0; j<2; j++)
            {
                InfernoFence inferoFence = new InfernoFence();
                addObject(inferoFence, 50*i+25, 25+j*650);
        }
        InfernoBoss infernoboss = new InfernoBoss(50);
        addObject(infernoboss, getWidth()/2 , getHeight()/2);

        InfernoFence infernofence = new InfernoFence();
        addObject(infernofence, 148, 119);
        InfernoFence infernofence2 = new InfernoFence();
        addObject(infernofence2, 630, 139);
        InfernoFence infernofence3 = new InfernoFence();
        addObject(infernofence3, 622, 601);
        InfernoFence infernofence4 = new InfernoFence();
        addObject(infernofence4, 162, 563);
        infernofence4.setLocation(160, 538);
        infernofence3.setLocation(596, 521);
        infernofence2.setLocation(582, 145);
        infernofence.setLocation(120, 114);
        infernofence4.setLocation(137, 530);
        infernofence4.setLocation(129, 531);
        infernofence3.setLocation(618, 530);
        infernofence3.setLocation(647, 568);
        infernofence4.setLocation(109, 565);
        infernofence4.setLocation(141, 499);
        infernofence2.setLocation(599, 179);
        infernofence.setLocation(152, 145);
        ArmPool armpool = new ArmPool(true);
        addObject(armpool, 347, 434);
        armpool.setLocation(155, 468);
        armpool.setLocation(150, 492);
        ArmPool armpool2 = new ArmPool(true);
        addObject(armpool2, 219, 101);
        ArmPool armpool3 = new ArmPool(true);
        addObject(armpool3, 616, 234);
        ArmPool armpool4 = new ArmPool(true);
        addObject(armpool4, 584, 542);
        armpool4.setLocation(579, 536);
        armpool3.setLocation(629, 213);
        armpool2.setLocation(213, 122);
        armpool.setLocation(206, 504);
        infernofence2.setLocation(608, 126);
        armpool3.setLocation(619, 185);
        infernofence3.setLocation(607, 560);
        armpool4.setLocation(551, 566);

        HealthGlobe healthglobe = new HealthGlobe();
        addObject(healthglobe, 670, 622);
        HealthGlobe healthglobe2 = new HealthGlobe();
        addObject(healthglobe2, 84, 79);
        addShuriken addshuriken = new addShuriken();
        addObject(addshuriken, 85, 624);
        instaPower instapower = new instaPower();
        addObject(instapower, 682, 73);

        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        addObject(levelCounter, 950, 15);
        levelCounter.setValue(5);
        addObject(ninja, 100, 100);
        ninja.setLocation(100, 75);

        makeAllIcons();

        npcs = getObjects(NPCS.class);
        for(int i = 0; i<npcs.size(); i++)
        {
            TempText2 text = new TempText2(npcs.get(i));
            addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
        }

        TempText4 text = new TempText4(infernoboss);
        addObject(text, infernoboss.getX(), infernoboss.getY()-20);
        AxisFirebat axisfirebat = new AxisFirebat(1, 1);
        addObject(axisfirebat, 211, 137);
        AxisFirebat axisfirebat2 = new AxisFirebat(1, 1);
        addObject(axisfirebat2, 618, 207);
        AxisFirebat axisfirebat3 = new AxisFirebat(1, 1);
        addObject(axisfirebat3, 546, 578);
        AxisFirebat axisfirebat4 = new AxisFirebat(1, 1);
        addObject(axisfirebat4, 202, 521);
    }

    public void act()//Sean
    {
        heavensGate.playLoop();
        counterDelay++;
        appleRespawn();
       //makeSmokeFireball();
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
        checkDoor();
        /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       
       /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       }
       delay++;
       fireballDelay++;
    }
    public void makeAllIcons()//Sean
    {
        SwordIcon swordicon = new SwordIcon();
        addObject(swordicon, 889, 360);
        ShurikenIcon shurikenicon = new ShurikenIcon();
        addObject(shurikenicon, 838, 360);
        StealthIcon stealthicon = new StealthIcon();
        addObject(stealthicon, 871, 308);
        DashIcon dashicon = new DashIcon();
        addObject(dashicon, 819, 308);
        //DoubleDamageIcon doubledamageicon = new DoubleDamageIcon();
        //addObject(doubledamageicon, 871, 308);
    }
    public void makeSmokeFireball()//Sean
    {
        if (delay > 100)
        {
            int randomNumber = Greenfoot.getRandomNumber(1000);
            if (randomNumber < 50)
            {
                SmokeFireball smokeFireball = new SmokeFireball();
                addObject(smokeFireball, 500, 475);
                delay = 0;
                Firebat firebat4 = new Firebat(1, 1);
                addObject(firebat4, 500, 475);
            }
            if (randomNumber >= 50 && randomNumber < 100)
            {
                SmokeFireball smokeFireball = new SmokeFireball();
                addObject(smokeFireball, 95, 661);
                delay = 0;
                Firebat firebat4 = new Firebat(1, 1);
                addObject(firebat4, 95, 661);
            }
            if (randomNumber >= 100 && randomNumber < 150)
            {
                SmokeFireball smokeFireball = new SmokeFireball();
                addObject(smokeFireball, 160, 493);
                delay = 0;
                Firebat firebat4 = new Firebat(1, 1);
                addObject(firebat4, 160, 493);
            }
            if (randomNumber >= 150 && randomNumber < 200)
            {
                SmokeFireball smokeFireball = new SmokeFireball();
                addObject(smokeFireball, 637, 423);
                delay = 0;
                Firebat firebat4 = new Firebat(1, 1);
                addObject(firebat4, 637, 423);
            }
            if (randomNumber >= 200 && randomNumber < 250)
            {
                SmokeFireball smokeFireball = new SmokeFireball();
                addObject(smokeFireball, 422, 285);
                delay = 0;
                Firebat firebat4 = new Firebat(1, 1);
                addObject(firebat4, 422, 285);
            }
        }
    }
    public void checkDoor()//Hayden
    {
        if(ninja.checkInfernoDoor()==true)
        {
            heavensGate.stop();
            Greenfoot.setWorld(new Cinematic1(ninja));
        }
    }
   public Ninja getNinja()//Bill
   {
       return ninja;
   }
   public Trap getThisWorld()//Bill
   {
       return this;
   }
   public void gameover(){//Hayden
       ninja.setHP(ninja.getArmor());
       Greenfoot.setWorld(new InfernoBossLevel(ninja));
       heavensGate.stop();
    }
    public void appleRespawn()
    {
        appleRespawn++;
        if (appleRespawn >= 3000)
        {
            appleRespawn = 0;
            HealthGlobe healthglobe = new HealthGlobe();
            addObject(healthglobe, 670, 622);
            HealthGlobe healthglobe2 = new HealthGlobe();
            addObject(healthglobe2, 84, 79);
            addShuriken addshuriken = new addShuriken();
            addObject(addshuriken, 85, 624);
            instaPower instapower = new instaPower();
            addObject(instapower, 682, 73);
        }
    }
}