import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Intro1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewIntro2 extends Trap
{
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    private List<NPCS> npcs;
    private GreenfootSound bloodBourne = new GreenfootSound("Bloodborne - Celestial Emissary.mp3");
    Boy boy;
    int delay = 0;
    private boolean madeSwordIcon = false;
    private int counterDelay = 0;
    /**
     * Constructor for objects of class Intro1.
     * 
     */
    public NewIntro2(Boy boy)
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
                addObject(fence, 50*i+25, 25+j*(700-50));
        }

        for(int i = 1;i<13; i++)
            for(int j = 0; j<2; j++)
            {
                IntroFence fence = new IntroFence();
                addObject(fence, 100+50*i+25, 360);
        }
        for(int i = 1;i<11; i++)
        {
            IntroFence fence = new IntroFence();
            addObject(fence, 50*i+25, 200);
        }
        for (int i = 0; i < 4; i++)
        {
            IntroFence fence = new IntroFence();
            addObject(fence, 500+25, 425+i*50-50);
        }
        for (int i = 0; i < 4; i++)
        {
            IntroFence fence = new IntroFence();
            addObject(fence, 305+50*i, 525);
        }
        //doorT10 doort10 = new doorT10();
        //addObject(doort10, 100, 640);

        addObject(healthCounter, 866, 120);
        healthCounter.setValue(boy.getNINJAHP());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(boy.getPOWERBAR());
           
        addObject(levelCounter, 950, 15);
        levelCounter.setValue(1);

        addObject(boy, 611, 437);

        //IntroRedMM bluemm = new IntroRedMM(1, 1);
        //addObject(bluemm, 252, 653-20);
        TrainingDummy trainingdummy = new TrainingDummy(3, 1);
        addObject(trainingdummy, 98, 356);
        TrainingDummy trainingdummy2 = new TrainingDummy(3, 1);
        addObject(trainingdummy2, 449, 441);
        TrainingDummy trainingdummy3 = new TrainingDummy(3, 1);
        addObject(trainingdummy3, 651, 108);
        doorT10 doort10 = new doorT10();
        addObject(doort10, 98, 113);
        
        MenuIcon menuIcon = new MenuIcon();
        addObject(menuIcon, 875, 605);
        
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
       if (Greenfoot.isKeyDown("escape") && delay > 20) 
      //want to be all keys
      {
          bloodBourne.stop();
          Greenfoot.setWorld(new NewIntro3(boy));
      }
      if(getObjects(Boy.class).size() != 0 && counterDelay >= 10)
        {
        healthCounter.setValue(boy.getNINJAHP());
        powerCounter.setValue(boy.getPOWERBAR());
        counterDelay-= 10;
       }
      makeSwordIcon();
      checkDoor();
       
      
    }
    public void makeAllIcons()
    {
    }
    public void makeSwordIcon()
    {   if (boy.getSwordStatus() == true && madeSwordIcon == false)
        {/*
            SwordIcon swordicon = new SwordIcon();
            addObject(swordicon, 840, 493);
            */
           SwordIcon swordicon = new SwordIcon();
           addObject(swordicon, 889, 360);
            madeSwordIcon = true;
        }
    }
      public void checkDoor()
       {
        if(boy.checkDoor()==true)
        {
        bloodBourne.stop();
            Greenfoot.setWorld(new NewIntro3(boy));
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
       Greenfoot.setWorld(new NewIntro2(boy));
    }
}

