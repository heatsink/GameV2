import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Intro1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewIntro3 extends Trap
{
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    private List<NPCS> npcs;
    private GreenfootSound bloodBourne = new GreenfootSound("Bloodborne - Celestial Emissary.mp3");
    Boy boy;
    private boolean madeShurikenIcon = false;
    int delay = 0;
    private int counterDelay = 0;
    /**
     * Constructor for objects of class Intro1.
     * 
     */
    public NewIntro3(Boy boy)
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

        for(int i = 1;i<11; i++)
        {
            IntroFence fence = new IntroFence();
            addObject(fence, 200+50*i+25, 360);
        }

        for (int i = 0; i < 3; i++)
        {
            IntroFence fence = new IntroFence();
            addObject(fence, 525+25, 425+i*50);
        }
        for (int i = 0; i < 4; i++)
        {
            IntroFence fence = new IntroFence();
            addObject(fence, 100+250+25, 525+i*50);
        }
        for (int i = 0; i < 4; i++)
        {
            IntroFence fence = new IntroFence();
            addObject(fence, 550+25, 200+i*50);
        }
        doorT10 doort10 = new doorT10();
        addObject(doort10, 652, 268);

        addObject(healthCounter, 866, 120);
        healthCounter.setValue(boy.getNINJAHP());

        addObject(levelCounter, 950, 15);
        levelCounter.setValue(2);

        addObject(boy, 606, 422);

        MenuIcon menuIcon = new MenuIcon();
        addObject(menuIcon, 875, 605);
        
        /*
        SwordIcon swordicon = new SwordIcon();
        addObject(swordicon, 840, 493);
         */
        IntroShurikenWeaponRack introshurikenweaponrack = new IntroShurikenWeaponRack();
        addObject(introshurikenweaponrack, 632, 526);
        makeAllIcons();
        TrainingDummyRM trainingdummyrm = new TrainingDummyRM(2, 3);
        addObject(trainingdummyrm, 144, 616);
        TrainingDummyRM trainingdummyrm2 = new TrainingDummyRM(2, 3);
        addObject(trainingdummyrm2, 536, 115);

        npcs = getObjects(NPCS.class);
        for(int i = 0; i<npcs.size(); i++)
        {
            TempText5 text = new TempText5(npcs.get(i));
            addObject(text, npcs.get(i).getX()-5, npcs.get(i).getY()-50);
        }
        addShuriken addshuriken = new addShuriken();
        addObject(addshuriken, 87, 354);
        addshuriken.setLocation(108, 214);
        addshuriken.setLocation(87, 93);
        addShuriken addshuriken2 = new addShuriken();
        addObject(addshuriken2, 512, 288);
        addshuriken2.setLocation(513, 291);
        addShuriken addshuriken3 = new addShuriken();
        addObject(addshuriken3, 379, 451);
        addshuriken3.setLocation(375, 446);
        addShuriken addshuriken4 = new addShuriken();
        addObject(addshuriken4, 82, 637);
        addshuriken4.setLocation(80, 639);
    }

    public void act(){
      delay++;
      counterDelay++;
      bloodBourne.playLoop();
       if (Greenfoot.isKeyDown("h")&&delay>10) 
       {
           clickSound.play();
           IntroMenu menu = new IntroMenu(getThisWorld());
           Greenfoot.setWorld(menu);
           delay = 0;
           
       }
        if (Greenfoot.isKeyDown("escape") && delay > 20) 
      //want to be all keys
      {
          bloodBourne.stop();
          Greenfoot.setWorld(new NewIntro4(boy));
      }
      if(getObjects(Boy.class).size() != 0 && counterDelay >= 10)
        {
        healthCounter.setValue(boy.getNINJAHP());
        powerCounter.setValue(boy.getPOWERBAR());
        shurikenCounter.setValue(boy.getSHURIKENNUMBER());
        counterDelay-= 10;
       }
      
       makeShurikenIcon();
       checkDoor();
    }
    public void makeAllIcons()
    {
        SwordIcon swordicon = new SwordIcon();
        addObject(swordicon, 889, 360);
    }
    public void makeShurikenIcon()
    {
        if (boy.getShurikenStatus() == true && madeShurikenIcon == false)
        {
            /*
            addObject(shurikenCounter, 826, 65);
            ShurikenIcon shurikenicon = new ShurikenIcon();
            addObject(shurikenicon, 789, 493);
            */
           ShurikenIcon shurikenicon = new ShurikenIcon();
            addObject(shurikenicon, 838, 360);
            addObject(shurikenCounter, 866, 201);
            shurikenCounter.setValue(boy.getSHURIKENNUMBER());
            addObject(powerCounter, 866, 161);
           powerCounter.setValue(boy.getPOWERBAR());
            madeShurikenIcon = true;
        }
    }
      public void checkDoor()
       {
           
        if(boy.checkDoor()==true)
        {
        bloodBourne.stop();
            Greenfoot.setWorld(new NewIntro4(boy));
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
       Greenfoot.setWorld(new NewIntro3(boy));
    }
}
