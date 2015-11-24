import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class K9 extends Trap
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
     * Constructor for objects of class K8.
     * 
     */
    public K9(Ninja ninja)
    {
                super();
        this.ninja = ninja;
        prepare();
    }
            private void prepare(){
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
                     for (int i = 0; i<12; i++)
        {
            Fence fence = new Fence();
            addObject(fence, 375, 50*i+200);
        }
        doorT10 doort10 = new doorT10();
        addObject(doort10, 80, 670);
        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        addObject(levelCounter, 950, 15);
        addObject(ninja, 650, 650);
        levelCounter.setValue(3);
       

        
                addObject(ninja, 600, 650);
                
                        Fence fence89 = new Fence();
        addObject(fence89, 565, 202);
        Fence fence90 = new Fence();
        addObject(fence90, 565, 202);
        Fence fence91 = new Fence();
        addObject(fence91, 188, 205);
        Fence fence92 = new Fence();
        addObject(fence92, 195, 533);
        Fence fence93 = new Fence();
        addObject(fence93, 576, 541);
        fence93.setLocation(557, 536);
        fence92.setLocation(199, 536);
        fence91.setLocation(192, 200);
        fence90.setLocation(565, 199);
        BlueRM bluerm = new BlueRM(3, 2);
        addObject(bluerm, 574, 378);
        fence93.setLocation(569, 536);
        BlueRM bluerm2 = new BlueRM(3, 2);
        addObject(bluerm2, 201, 381);
        fence92.setLocation(196, 535);
        bluerm2.setLocation(194, 380);
        RedMM redmm = new RedMM(3, 3);
        addObject(redmm, 378, 117);
        RedMM redmm2 = new RedMM(3, 3);
        addObject(redmm2, 568, 122);
        RedMM redmm3 = new RedMM(3, 3);
        addObject(redmm3, 190, 127);
        redmm3.setLocation(190, 120);
        redmm.setLocation(374, 118);

        
                npcs = getObjects(NPCS.class);
       for(int i = 0; i<npcs.size(); i++)
       {
           TempText2 text = new TempText2(npcs.get(i));
           addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
       }
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
            counterDelay-= 10;counterDelay-= 10;
            checkDoor();
            /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
        }
        delay++;
        
        
    }
    
    public void checkDoor()
    {
        if(ninja.checkDoor()==true)
            Greenfoot.setWorld(new K10(ninja));
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
       Greenfoot.setWorld(new K9(ninja));
    }
}
