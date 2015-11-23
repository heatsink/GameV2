import greenfoot.*;
/**
 * Functionality in this class:
 */
public class Kyobashi extends Trap
{
    public int level = 0;
    private int delay = 11;    //Constructor for objects of class Kyobashi
    private Ninja ninja;
     //HAYDENS
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    //Counter powerCounter = new PowerCounter("Energy: ");
    
    GreenfootSound backgroundTheme = new GreenfootSound("ninja_backgroundtheme.mp3");
    // Levels
    DeathWorld deathWorld;
    private int counterRefreshDelay = 0;
    public Kyobashi(Ninja ninja)
    {    
        super(); 
        this.ninja = ninja;
        
        
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        TextBoxKyo3 textboxkyo3 = new TextBoxKyo3();
        addObject (textboxkyo3, 380, 640);
        addObject(ninja, 100, 100);
        for(int i = 0; i<15; i++)
            for(int j = 0; j<2; j++)
            {
                Fence fence = new Fence();
                addObject(fence, 25+j*700, 50*i+25);
        }
        for(int i = 1;i<15; i++)
            for(int j = 0; j<2; j++)
            {
                Fence fence = new Fence();
                addObject(fence, 50*i+25, 25+j*700);
        }
        for (int i = 0; i<15; i++)
        {
            Fence fence = new Fence();
            addObject(fence, 50*i, 550);
        }

        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        addObject(levelCounter, 950, 15);
        levelCounter.setValue(level);
        
        TheHack thehack=new TheHack();
        addObject(thehack, 720, 30);

        
        doorT10 door = new doorT10();
        addObject(door, 100, 475);

        makeAllIcons();
        //PowerBar powerbar = new PowerBar();
        //addObject(powerbar, 824, 143+50);
    }
    
   public void act()
   {
       backgroundTheme.setVolume(65);
       //backgroundTheme.playLoop(); 
       
       /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       
       /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       if (Greenfoot.isKeyDown("h")&&delay>10) 
       {
           Menu menu = new Menu(getThisWorld());
           Greenfoot.setWorld(menu);
           delay = 0;
           
       }
      
       delay++;
       counterRefresh();
       /*
       healthCounter.setValue(ninja.getNINJAHP());
       shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
       powerCounter.setValue(ninja.getPOWERBAR());
       */
       checkDoor();
       checkSnowDoor();
       checkInfernoDoor();
       t2Start();
   }
   public void makeAllIcons()
    {
        SwordIcon swordicon = new SwordIcon();
        addObject(swordicon, 889, 360);
        ShurikenIcon shurikenicon = new ShurikenIcon();
        addObject(shurikenicon, 838, 360);
        DoubleDamageIcon doubledamageicon = new DoubleDamageIcon();
        addObject(doubledamageicon, 871, 308);
    }
   public void counterRefresh()
   {
       counterRefreshDelay++;
        if (counterRefreshDelay > 5)
        {
            counterRefreshDelay-=5;
            healthCounter.setValue(ninja.getNINJAHP());
            shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
            powerCounter.setValue(ninja.getPOWERBAR());
        }
    }
   public Kyobashi getThisWorld()
   {
       return this;
   }
   
   public Ninja getNinja()
   {
       return ninja;
   }
   
   // Starting Levels
   
   public void k2Start() // [Sean]
   {
       K2 k2 = new K2(ninja);
       Greenfoot.setWorld(k2);
   }
   public void k3Start() // [Sean]
   {
       K3 k3 = new K3(ninja);
       Greenfoot.setWorld(k3);
   }
   public void addLevel()
   {
       level++;
       levelCounter.add(1);
   }
   public int getLevel()
   {
       return level;
   }
   public void checkDoor()
   {
       if(ninja.checkDoor()==true)
            Greenfoot.setWorld(new K2(ninja));
   }
   public void checkInfernoDoor()
   {
       if(ninja.checkInfernoDoor()== true)
            Greenfoot.setWorld(new Inferno1(ninja));
   }
   public void t2Start()
   {
       if (ninja.checkDoorT21()==true)
            Greenfoot.setWorld(new T21(ninja));
    }
       public void checkSnowDoor()
   {
       if(ninja.checkSnowDoor()==true)
            Greenfoot.setWorld(new Snow1(ninja));
   }
      public void gameover(){
       ninja.setHP(ninja.getArmor());
       Greenfoot.setWorld(new Kyobashi(ninja));
    }
}