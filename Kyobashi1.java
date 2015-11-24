import greenfoot.*;
/**
 * Functionality in this class:
 */
public class Kyobashi1 extends Trap
{
    public int level = 0;
    private int delay = 11;    //Constructor for objects of class Kyobashi
    private Ninja ninja;
    Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter powerCounter = new Counter("Power: ");
    Counter levelCounter = new Counter("Level: ");
    GreenfootSound backgroundTheme = new GreenfootSound("ninja_backgroundtheme.mp3");
    // Levels
    DeathWorld deathWorld;
    public Kyobashi1(Ninja ninja)
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
        TextBoxKyo0 textboxkyo0 = new TextBoxKyo0();
        addObject (textboxkyo0, 380, 640-50+15);
        
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
            addObject(fence, 50*i, 550-35);
        }
        addObject(healthCounter, 70, 730);
        healthCounter.setValue(ninja.getNINJAHP());
        // Shurikens [Sean]
        
        addObject(shurikenCounter, 225, 730);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
        
        addObject(powerCounter, 500, 730);
        powerCounter.setValue(ninja.getPOWERBAR());
        
        addObject(levelCounter, 355, 730);
        levelCounter.setValue(level);
        doorT10 door = new doorT10();
        addObject(door, 100, 475-50+15);
        
        doorT21 snowdoor = new doorT21();
        addObject(snowdoor, 650, 100);
        
        addShuriken s = new addShuriken();
        addObject(s, 375, 475-50);
        HealthGlobe hg = new HealthGlobe();
        addObject(hg, 650, 325);
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
       if (Greenfoot.isKeyDown("1")&&delay>10) 
       {
           Greenfoot.setWorld(new Inferno1(ninja));
           delay = 0;
       }
       if (Greenfoot.isKeyDown("2")&&delay>10) 
       {
           Greenfoot.setWorld(new Inferno2(ninja));
           delay = 0;
       }
       if (Greenfoot.isKeyDown("3")&&delay>10) 
       {
           Greenfoot.setWorld(new Inferno3(ninja));
           delay = 0;
       }
       if (Greenfoot.isKeyDown("4")&&delay>10) 
       {
           Greenfoot.setWorld(new Inferno4(ninja));
           delay = 0;
       }
       if (Greenfoot.isKeyDown("0")&&delay>10) 
       {
           Greenfoot.setWorld(new InfernoBossLevel(ninja));
           delay = 0;
       }
       if (Greenfoot.isKeyDown("8")&&delay>10) 
       {
           Greenfoot.setWorld(new K12(ninja));
           delay = 0;
       }
       if (Greenfoot.isKeyDown("7")&&delay>10)
       {
           Greenfoot.setWorld(new Snow3(ninja));
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
   
   public Kyobashi1 getThisWorld()
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
  }
