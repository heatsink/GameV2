import greenfoot.*;
import java.util.*;//Hayden
/**
 * Write a description of class K3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class K3 extends Trap//Hayden
{
    Ninja ninja;
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    int delay = 11;
    private int counterDelay = 0;
    private List<NPCS> npcs;
    /**
     * Constructor for objects of class K3.
     * 
     */
    public K3(Ninja ninja)//Hayden
    {
        super();
        this.ninja = ninja;
        prepare();
    }

    public void act()//Hayden
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
    
    private void prepare()//Hayden
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
                addObject(fence, 50*i+25, 25+j*(700-50));
            }
        
        doorT10 doort10 = new doorT10();
        addObject(doort10, 670, 80);

        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        addObject(levelCounter, 950, 15);
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
        makeAllIcons();
        
                npcs = getObjects(NPCS.class);
       for(int i = 0; i<npcs.size(); i++)
       {
           TempText2 text = new TempText2(npcs.get(i));
           addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
       }
    }
    public void makeAllIcons()//sean
    {
        SwordIcon swordicon = new SwordIcon();
        addObject(swordicon, 889, 360);
        ShurikenIcon shurikenicon = new ShurikenIcon();
        addObject(shurikenicon, 838, 360);
    }
    
    public void checkDoor()//Hayden
    {
        if(ninja.checkDoor()==true)
            Greenfoot.setWorld(new K4(ninja));
    }

    public Ninja getNinja()//bill
    {
        return ninja;
    }
    public Trap getThisWorld()//bill
    {
        return this;
    }
       public void gameover(){//Hayden
       ninja.setHP(ninja.getArmor());
       Greenfoot.setWorld(new K3(ninja));
    }
}
