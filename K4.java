import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class K4 extends Trap
{    Ninja ninja;
    GreenfootSound Peaceful = new GreenfootSound("Peaceful.mp3");
    static boolean played = false;
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    private int counterDelay = 0;
    int delay = 11;
    private List<NPCS> npcs;
    /**
     * Constructor for objects of class K4.
     * 
     */
    public K4(Ninja ninja)
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
        
        doorT10 doort10 = new doorT10();
        addObject(doort10, 670, 80);
        
        doorT11 doort11 = new doorT11();
        addObject(doort11, 670-4, 625-40+15);

        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        addObject(levelCounter, 950, 15);
        addObject(ninja, 100, 375);
        levelCounter.setValue(2);
            
                Fence fence77 = new Fence();
        addObject(fence77, 684, 382);
        Fence fence78 = new Fence();
        addObject(fence78, 645, 389);
        Fence fence79 = new Fence();
        addObject(fence79, 613, 387);
        Fence fence80 = new Fence();
        addObject(fence80, 579, 386);
        Fence fence81 = new Fence();
        addObject(fence81, 540, 385);
        Fence fence82 = new Fence();
        addObject(fence82, 504, 381);
        Fence fence83 = new Fence();
        addObject(fence83, 469, 377);
        Fence fence84 = new Fence();
        addObject(fence84, 430, 386);
        Fence fence85 = new Fence();
        addObject(fence85, 389, 387);
        fence77.setLocation(677, 376);
        fence78.setLocation(629, 377);
        fence79.setLocation(583, 377);
        fence80.setLocation(333, 457);
        fence81.setLocation(536, 378);
        fence82.setLocation(495, 377);
        fence81.setLocation(540, 377);
        fence83.setLocation(449, 377);
        fence84.setLocation(404, 378);
        fence85.setLocation(361, 378);
        fence80.setLocation(313, 378);
        Fence fence86 = new Fence();
        addObject(fence86, 282, 685);
        Fence fence87 = new Fence();
        addObject(fence87, 282, 647);
        Fence fence88 = new Fence();
        addObject(fence88, 286, 603);
        Fence fence89 = new Fence();
        addObject(fence89, 284, 562);
        Fence fence90 = new Fence();
        addObject(fence90, 283, 79);
        Fence fence91 = new Fence();
        addObject(fence91, 288, 133);
        Fence fence92 = new Fence();
        addObject(fence92, 292, 180);
        Fence fence93 = new Fence();
        addObject(fence93, 294, 228);
        fence90.setLocation(278, 74);
        fence91.setLocation(277, 121);
        fence92.setLocation(277, 170);
        fence93.setLocation(277, 219);
        fence89.setLocation(280, 539);
        fence88.setLocation(282, 587);
        fence87.setLocation(280, 622);
        fence86.setLocation(276, 677);
        fence87.setLocation(275, 629);
        fence88.setLocation(276, 585);
        fence89.setLocation(276, 540);
        fence86.setLocation(275, 677);
        BlueRM bluerm = new BlueRM(1, 1);
        addObject(bluerm, 485, 546);
        BlueRM bluerm2 = new BlueRM(1, 1);
        addObject(bluerm2, 492, 198);
                HealthGlobe healthglobe = new HealthGlobe();
        addObject(healthglobe, 560, 301);
        healthglobe.setLocation(175, 359);
        addShuriken addshuriken = new addShuriken();
        addObject(addshuriken, 179, 477);
        
        checkDoor();
        checkDoor1();
        makeAllIcons();
        
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
        if (!played){
            Peaceful.playLoop();
            played = !played;
        }
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
            checkDoor1();
            /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
        }
        delay++;
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
        if(ninja.checkDoor()==true){
            Peaceful.stop();
            Greenfoot.setWorld(new K5(ninja));
        }
    }
        public void checkDoor1()
    {
        if(ninja.checkDoor1()==true){
            Peaceful.stop();
            Greenfoot.setWorld(new K6(ninja));
        }
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
       Greenfoot.setWorld(new K4(ninja));
    }
}
