import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Intro1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewIntro5 extends Trap
{
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    private List<NPCS> npcs;
    private GreenfootSound bloodBourne = new GreenfootSound("Bloodborne - Celestial Emissary.mp3");
    Ninja ninja;
    Boy boy;
    int delay = 0;
    private int counterDelay = 0;
    private boolean madeDashIcon = false;
    private boolean madeDoor = false;
    /**
     * Constructor for objects of class Intro1.
     * 
     */
    public NewIntro5(Boy boy)
    {
        super();
        ninja = new Ninja();
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
                addObject(fence, 50*i+25, 25+j*(700-50));
        }

        for(int i = 1;i<10; i++)
            {
                IntroFence fence = new IntroFence();
                addObject(fence, 50*i+25, 320);
        }
        for(int i = 1;i<12; i++)
            {
                IntroFence fence = new IntroFence();
                addObject(fence, 651, 50*i+50);
        }
        for (int i = 0; i < 4; i++)
        {
            IntroFence fence = new IntroFence();
            addObject(fence, 175, 625-50*i);
        }
        for (int i =0; i< 3; i++)
        {
            IntroFence fence = new IntroFence();
            addObject(fence, 325,600-50-50*i-50);
        }
        for (int i = 0; i < 4; i++)
        {
            IntroFence fence = new IntroFence();
            addObject(fence, 475, 625-50*i);
        }
        /*
        for (int i = 0; i < 2; i++)
        {
            IntroFence fence = new IntroFence();
            addObject(fence, 175, 250-50*i);
        }
        for (int i =0; i< 2; i++)
        {
            IntroFence fence = new IntroFence();
            addObject(fence, 325,200-50-50*i);
        }
        for (int i = 0; i < 2; i++)
        {
            IntroFence fence = new IntroFence();
            addObject(fence, 475, 250-50*i);
        }*/
        
        
        addObject(healthCounter, 866, 120);
        healthCounter.setValue(boy.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(boy.getSHURIKENNUMBER());

        

        addObject(levelCounter, 950, 15);
        levelCounter.setValue(4);

        addObject(boy, 100, 646-50);

        Spellbook spellbook = new Spellbook();
        addObject(spellbook, 100, 250);
        makeAllIcons();
    }

    public void act(){
       delay++;
       counterDelay++;
        bloodBourne.playLoop();
       if (Greenfoot.isKeyDown("h")&&delay>10) 
       {
           Menu menu = new Menu(getThisWorld());
           Greenfoot.setWorld(menu);
           delay = 0;
           
       }
        if (Greenfoot.isKeyDown("escape") && delay > 20) 
      //want to be all keys
      {
          bloodBourne.stop();
          Greenfoot.setWorld(new Kyobashi(ninja));
          
      }
      if(getObjects(Boy.class).size() != 0 && counterDelay >= 10)
        {
        healthCounter.setValue(boy.getNINJAHP());
        shurikenCounter.setValue(boy.getSHURIKENNUMBER());
        powerCounter.setValue(boy.getPOWERBAR());
        counterDelay-= 10;
       }
       makeDashIcon();
       checkDoor();
      if (getObjects(Spellbook.class).size() == 0 && madeDoor == false)
      {
          madeDoor = true;
          doorT10 doort10 = new doorT10();
          addObject(doort10, 100, 640-50);
        }
      
    }
    public void makeAllIcons()
    {
        SwordIcon swordicon = new SwordIcon();
        addObject(swordicon, 889, 360);
        ShurikenIcon shurikenicon = new ShurikenIcon();
        addObject(shurikenicon, 838, 360);
    }
    public void makeDashIcon()
    {   if (boy.getDashStatus() == true && madeDashIcon == false)
        {
            /*
            addObject(powerCounter, 826, 139);
            powerCounter.setValue(ninja.getPOWERBAR());
            DashIcon dashicon = new DashIcon();
            addObject(dashicon, 767, 442);
            */
           addObject(powerCounter, 866, 161);
            powerCounter.setValue(boy.getPOWERBAR());
            DashIcon dashicon = new DashIcon();
            addObject(dashicon, 819, 308);
            madeDashIcon = true;
        }
    }
      public void checkDoor()
       {
        if(boy.checkDoor()==true)
        {
            bloodBourne.stop();
            Greenfoot.setWorld(new Kyobashi(ninja));
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
       bloodBourne.stop();
       Greenfoot.setWorld(new NewIntro5(boy));
      }
}
