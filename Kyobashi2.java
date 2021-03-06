import greenfoot.*;
//Hayden
/**
 * Functionality in this class:
 */
public class Kyobashi2 extends Trap//Hayden
{
    public int level = 0;
    private int delay = 11;    //Constructor for objects of class Kyobashi
    private Ninja ninja;
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    GreenfootSound backgroundTheme = new GreenfootSound("ninja_backgroundtheme.mp3");
    // Levels
    // https://www.youtube.com/watch?v=9MdqA2oPqN0
    GreenfootSound goldenLotus = new GreenfootSound("GoldenLotus.mp3");
    DeathWorld deathWorld;
    public Kyobashi2(Ninja ninja)//Hayden
    {    
        super(); 
        this.ninja = ninja;
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()//Hayden
    {
        TextBoxKyo1 textboxkyo1 = new TextBoxKyo1();
        addObject (textboxkyo1, 380, 640-40);

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
                addObject(fence, 50*i+25, 25+j*(700-50));
        }
        for (int i = 0; i<15; i++)
        {
            Fence fence = new Fence();
            addObject(fence, 50*i, 550-40);
        }

        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        addObject(levelCounter, 950, 15);

        doorT21 doorT21 = new doorT21();
        addObject(doorT21, 376, 436);

        doorT10 door = new doorT10();
        addObject(door, 663, 436);

        addShuriken s = new addShuriken();
        addObject(s, 98, 191);
        HealthGlobe hg = new HealthGlobe();
        addObject(hg, 197, 91);
        makeAllIcons();//Sean
    }
    
   public void act()//Bill, Sean, Hayden
   {
       goldenLotus.setVolume(65);
       goldenLotus.playLoop();
       backgroundTheme.setVolume(65);
       //backgroundTheme.playLoop(); 
       
       /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       
       /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       if (Greenfoot.isKeyDown("h")&&delay>10) 
       {
           clickSound.play();
           Menu menu = new Menu(getThisWorld());
           Greenfoot.setWorld(menu);
           delay = 0;
           
       }
       
       delay++;
       healthCounter.setValue(ninja.getNINJAHP());
       shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
       powerCounter.setValue(ninja.getPOWERBAR());
       checkDoor();
       checkSnowDoor();
       checkInfernoDoor();
       t2Start();
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
        MenuIcon menuIcon = new MenuIcon();
        addObject(menuIcon, 875, 605);
    }
   public Kyobashi2 getThisWorld()//Bill
   {
       return this;
   }
   
   public Ninja getNinja()//bill
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
   public void addLevel()//Bill
   {
       level++;
       levelCounter.add(1);
   }
   public int getLevel()//Bill
   {
       return level;
   }
   public void checkDoor()//Hayden
   {
       if(ninja.checkDoor()==true)
       {
           goldenLotus.stop();
            Greenfoot.setWorld(new K2(ninja));
        }
   }
   public void checkInfernoDoor()//Hayden
   {
       if(ninja.checkInfernoDoor()== true)
       {
           goldenLotus.stop();
            Greenfoot.setWorld(new Inferno1(ninja));
        }
   }
   public void t2Start()//Hayden
   {
       if (ninja.checkDoorT21()==true)
       {
           goldenLotus.stop();
            Greenfoot.setWorld(new T21(ninja));
        }
    }
       public void checkSnowDoor()//Hayden
   {
       if(ninja.checkSnowDoor()==true)
       {
           goldenLotus.stop();
            Greenfoot.setWorld(new Snow1(ninja));
        }
   }
  }
