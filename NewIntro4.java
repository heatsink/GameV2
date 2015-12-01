import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Intro1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewIntro4 extends Trap
{
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    private List<NPCS> npcs;
    private GreenfootSound bloodBourne = new GreenfootSound("Bloodborne - Celestial Emissary.mp3");
    Boy boy;
    Ninja ninja;
    int delay = 0;
    private int counterDelay = 0;
    /**
     * Constructor for objects of class Intro1.
     * 
     */
    public NewIntro4(Boy boy)
    {
        super();
        this.boy = boy;
        bloodBourne.setVolume(25);
        ninja = new Ninja();
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

        for(int i = 1;i<8; i++)
        {
            IntroFence fence = new IntroFence();
            addObject(fence, 275+50*i+25, 360);
        }
        for(int i = 0; i < 8; i++)
        {
            IntroFence fence = new IntroFence();
            addObject(fence, 175, 250+50*i);
        }
        for (int i = 0; i < 6; i++)
        {
            IntroFence fence = new IntroFence();
            addObject(fence, 175+50*i, 200);
        }
        doorT10 doort10 = new doorT10();
        addObject(doort10, 100, 640-50);

        addObject(healthCounter, 866, 120);
        healthCounter.setValue(boy.getNINJAHP());

        addObject(powerCounter, 866, 161);
           powerCounter.setValue(boy.getPOWERBAR());
           
        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(boy.getSHURIKENNUMBER());

        addObject(levelCounter, 950, 15);
        levelCounter.setValue(3);

        addObject(boy, 600+50, 500-50);

        HealthGlobe healthglobe = new HealthGlobe();

        TrainingDummy trainingdummy = new TrainingDummy(5, 2);
        addObject(trainingdummy, 266, 353);
        TrainingDummyRM trainingdummyrm = new TrainingDummyRM(5, 1);
        addObject(trainingdummyrm, 522, 118);
        TrainingDummyRM trainingdummyrm2 = new TrainingDummyRM(5, 1);
        addObject(trainingdummyrm2, 105, 113);
        TrainingDummy trainingdummy2 = new TrainingDummy(5, 1);
        addObject(trainingdummy2, 100, 478);
        addShuriken addshuriken = new addShuriken();
        addObject(addshuriken, 674, 615);
        addshuriken.setLocation(664, 610);
        addShuriken addshuriken2 = new addShuriken();
        addObject(addshuriken2, 657, 285);
        addShuriken addshuriken3 = new addShuriken();
        addObject(addshuriken3, 369, 136);
        HealthGlobe healthglobe2 = new HealthGlobe();
        addObject(healthglobe2, 663, 97);

        npcs = getObjects(NPCS.class);
        for(int i = 0; i<npcs.size(); i++)
        {
            TempText5 text = new TempText5(npcs.get(i));
            addObject(text, npcs.get(i).getX()-5, npcs.get(i).getY()-50);
        }
        HealthGlobe healthglobe3 = new HealthGlobe();
        addObject(healthglobe3, 393, 280);
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
       checkDoor();
       
      
    }
     public void makeAllIcons()
     {
        SwordIcon swordicon = new SwordIcon();
        addObject(swordicon, 889, 360);
        ShurikenIcon shurikenicon = new ShurikenIcon();
        addObject(shurikenicon, 838, 360);
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
       Greenfoot.setWorld(new NewIntro4(boy));
    }
}

