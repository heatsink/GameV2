import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class K3 extends Trap
{
    Ninja ninja;
    Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    int delay = 11;
    private int counterDelay = 0;
    private List<NPCS> npcs;
    /**
     * Constructor for objects of class K3.
     * 
     */
    public K3(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        prepare();
    }

    public void act()
    {
        counterDelay++;
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
            checkDoor();
            /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
        }
        delay++;
    }
    
    private void prepare()
    {
                for(int i = 0; i<15; i++)
            for(int j = 0; j<2; j++)
            {
            Fence fence = new Fence();
            addObject(fence, 25+j*700, 50*i+25);
            }
        for(int i = 1;i<24; i++)
            for(int j = 0; j<2; j++)
            {
                Fence fence = new Fence();
                addObject(fence, 50*i+25, 25+j*700);
            }
        
        doorT10 doort10 = new doorT10();
        addObject(doort10, 670, 80);

        addObject(healthCounter, 70, 730);

        addObject(shurikenCounter, 225, 730);
        
        addObject(powerCounter, 500, 730);

        addObject(levelCounter, 355, 730);
        addObject(ninja, 100, 100);
        levelCounter.setValue(3);
        addObject(ninja, 100, 100);
        Fence fence77 = new Fence();
        addObject(fence77, 521, 80);
        Fence fence78 = new Fence();
        addObject(fence78, 530, 188);
        Fence fence79 = new Fence();
        addObject(fence79, 538, 329);
        fence78.setLocation(520, 188);
        fence77.setLocation(517, 75);
        fence79.setLocation(521, 299);
        BlackMM blackrm = new BlackMM(2, 2);
        addObject(blackrm, 521, 134);
        BlackMM blackrm2 = new BlackMM(2, 2);
        addObject(blackrm2, 526, 248);
        Fence fence80 = new Fence();
        addObject(fence80, 294, 275);
        Fence fence81 = new Fence();
        addObject(fence81, 276, 486);
        Fence fence82 = new Fence();
        addObject(fence82, 376, 493);
        Fence fence83 = new Fence();
        addObject(fence83, 492, 490);
        fence82.setLocation(375, 487);
        fence83.setLocation(480, 488);
        BlackRM blackmm = new BlackRM(2, 1);
        addObject(blackmm, 159, 492);
        BlackRM blackmm2 = new BlackRM(2, 1);
        addObject(blackmm2, 609, 494);
        BlackMM blackrm3 = new BlackMM(2, 1);
        addObject(blackrm3, 335, 617);
        BlackMM blackrm4 = new BlackMM(2, 1);
        addObject(blackrm4, 459, 620);
        BlackMM blackrm5 = new BlackMM(2, 1);
        addObject(blackrm5, 305, 394);
        BlackMM blackrm6 = new BlackMM(2, 1);
        addObject(blackrm6, 416, 276);
        checkDoor();
        
                npcs = getObjects(NPCS.class);
       for(int i = 0; i<npcs.size(); i++)
       {
           TempText2 text = new TempText2(npcs.get(i));
           addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
       }
    }

    
    public void checkDoor()
    {
        if(ninja.checkDoor()==true)
            Greenfoot.setWorld(new K4(ninja));
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
       Greenfoot.setWorld(new K3(ninja));
    }
}
