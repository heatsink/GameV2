import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Intro1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewIntro1 extends Trap
{
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    private List<NPCS> npcs;
    private GreenfootSound bloodBourne = new GreenfootSound("Bloodborne - Celestial Emissary.mp3");
    private int counterDelay = 0;
    Boy boy;
    int delay = 0;
    /**
     * Constructor for objects of class Intro1.
     * 
     */
    public NewIntro1(Boy boy)
    {
        super();
        this.boy = boy;
        bloodBourne.setVolume(25);
        prepare();
    }
    
    public void prepare(){
        for(int i = 0; i<15; i++)
            for(int j = 0; j<2; j++)
            {
                IntroFence fence = new IntroFence();
                addObject(fence, 25+j*700, 50*i+25);
        }
        for(int i = 1;i<15; i++)
            for(int j = 0; j<2; j++)
            {
                IntroFence fence = new IntroFence();
                addObject(fence, 50*i+25, 25+j*700);
        }

        for (int i = 0; i< 7; i++)
        {
            IntroFence fence = new IntroFence();
            addObject(fence, 515, 700-25-50-50*i);
        }
        for (int i = 0; i< 7; i++)
        {
            IntroFence fence = new IntroFence();
            addObject(fence, 360, 50*i+50+50);
        }
        for (int i = 0; i< 7; i++)
        {
            IntroFence fence = new IntroFence();
            addObject(fence, 200, 700-25-50-50*i);
        }

        doorT10 doort10 = new doorT10();
        addObject(doort10, 100, 640);

        addObject(healthCounter, 866, 120);
        healthCounter.setValue(boy.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(boy.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(boy.getPOWERBAR());

        addObject(levelCounter, 950, 15);
        levelCounter.setValue(1);
        addObject(boy, 650, 600);

        IntroWeaponRack introweaponrack = new IntroWeaponRack();
        addObject(introweaponrack, 515, 258);
        TrainingDummy trainingdummy2 = new TrainingDummy(3, 1);
        addObject(trainingdummy2, 280, 316);
        TrainingDummy trainingdummy3 = new TrainingDummy(3, 1);
        addObject(trainingdummy3, 363, 495);

        npcs = getObjects(NPCS.class);
        for(int i = 0; i<npcs.size(); i++)
        {
            TempText5 text = new TempText5(npcs.get(i));
            addObject(text, npcs.get(i).getX()-5, npcs.get(i).getY()-50);
        }
    }

    public void act(){
        bloodBourne.playLoop();
        delay++;
        counterDelay++;
       if (Greenfoot.isKeyDown("h")&&delay>10) 
       {
           Menu menu = new Menu(getThisWorld());
           Greenfoot.setWorld(menu);
           delay = 0;
           
       }
       if (Greenfoot.isKeyDown("escape")&& delay > 20) 
      //want to be all keys
      {
          bloodBourne.stop();
          Greenfoot.setWorld(new NewIntro2(boy));
      }
      if(getObjects(Boy.class).size() != 0 && counterDelay >= 10)
        {
        healthCounter.setValue(boy.getNINJAHP());
        counterDelay-= 10;
       }
        checkDoor();
       
      
    }
    public void makeAllIcons()
    {
    }
      public void checkDoor()
       {
        if(boy.checkDoor()==true)
        {
            bloodBourne.stop();
            Greenfoot.setWorld(new NewIntro2(boy));
        }
       }
      public Boy getBoy()
      {
       return boy;
      }
        
      public Trap getThisWorld()
     {
       return this;
     }
       public void gameover(){
       boy.setHP(boy.getArmor());
       Greenfoot.setWorld(new NewIntro1(boy));
    }
}
