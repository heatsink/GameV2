import greenfoot.*;

/**
 * Write a description of class WorldMaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DevelopersWorldMaker extends World
{

    /**
     * Constructor for objects of class WorldMaker.
     * 
     */
    Ninja ninja;
    public DevelopersWorldMaker()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        Ninja ninja = new Ninja();
        addObject(ninja, 100, 100);
        Counter healthCounter = new Counter("Health: "); //HAYDENS
        Counter shurikenCounter = new Counter("Shurikens: ");
        Counter powerCounter = new Counter("Power: ");
        Counter levelCounter = new Counter("Level: ");
        
        addObject(healthCounter, 70, 730);
        healthCounter.setValue(ninja.getNINJAHP());
        // Shurikens [Sean]
        
        addObject(shurikenCounter, 225, 730);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
        
        addObject(powerCounter, 500, 730);
        powerCounter.setValue(ninja.getPOWERBAR());
        
        addObject(levelCounter, 355, 730);
        levelCounter.setValue(1);
        
        prepare();
    }
    
    public void prepare()
    {
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

        for (int i = 0; i<16; i++)
        {
            Fence fence = new Fence();
            addObject(fence, 50*i, 550);
        }

        TheHack thehack=new TheHack();
        addObject(thehack, 720, 30);

        doorT10 door = new doorT10();
        addObject(door, 140, 00);

        InfernoDoor infernoDoor = new InfernoDoor();
        addObject(infernoDoor, 400, 600);

        doorT21 doorT21 = new doorT21();
        addObject(doorT21, 600, 600);
        SnowDoor snowdoor = new SnowDoor();
        addObject(snowdoor, 600, 200);
        HUD hud = new HUD();
        addObject(hud, 874, 373);

        SwordIcon swordicon = new SwordIcon();
        addObject(swordicon, 840+25, 493);
        ShurikenIcon shurikenicon = new ShurikenIcon();
        addObject(shurikenicon, 789+25, 493);
        StealthIcon stealthicon = new StealthIcon();
        addObject(stealthicon, 871+25, 442);
        DashIcon dashicon = new DashIcon();
        addObject(dashicon, 767+25, 442);
        DoubleDamageIcon doubledamageicon = new DoubleDamageIcon();
        addObject(doubledamageicon, 819+25, 441);
        
    }
    
}
