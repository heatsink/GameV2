import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    private GreenfootSound heavensGate = new GreenfootSound("Diablo 3 OST - Heaven's Gate (#20).mp3");
    public InfernoBossLevel(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        prepare();
        heavensGate.setVolume(30);
        
    }
    
    private void prepare()
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
        InfernoBoss infernoboss = new InfernoBoss(10);
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
    }

    public void act()
    {
        heavensGate.playLoop();
        counterDelay++;
       //makeSmokeFireball();
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
       checkDoor();
       delay++;
       fireballDelay++;
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
    public void makeSmokeFireball()
    {
        if (delay > 100)
        {
            int randomNumber = Greenfoot.getRandomNumber(1000);
            if (randomNumber < 50)
            {
                SmokeFireball smokeFireball = new SmokeFireball();
                addObject(smokeFireball, 500, 475);
                delay = 0;
            }
            if (randomNumber >= 50 && randomNumber < 100)
            {
                SmokeFireball smokeFireball = new SmokeFireball();
                addObject(smokeFireball, 95, 661);
                delay = 0;
            }
            if (randomNumber >= 100 && randomNumber < 150)
            {
                SmokeFireball smokeFireball = new SmokeFireball();
                addObject(smokeFireball, 160, 493);
                delay = 0;
            }
            if (randomNumber >= 150 && randomNumber < 200)
            {
                SmokeFireball smokeFireball = new SmokeFireball();
                addObject(smokeFireball, 637, 423);
                delay = 0;
            }
            if (randomNumber >= 200 && randomNumber < 250)
            {
                SmokeFireball smokeFireball = new SmokeFireball();
                addObject(smokeFireball, 422, 285);
                delay = 0;
            }
        }
    }
    public void checkDoor()
    {
        if(ninja.checkInfernoDoor()==true)
        {
            heavensGate.stop();
            Greenfoot.setWorld(new Cinematic1(ninja));
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
       Greenfoot.setWorld(new InfernoBossLevel(ninja));
       heavensGate.stop();
    }
}