import greenfoot.*;
import java.util.*;//Hayden
/**
 * Write a description of class K5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class K5 extends Trap//Hayden
{
    Ninja ninja;
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    int delay = 11;
    private List<NPCS> npcs;
    private int counterDelay = 0;
    GreenfootSound Peaceful = new GreenfootSound("Peaceful.mp3");
    static boolean played = false;
    /**
     * Constructor for objects of class K5.
     * 
     */
    public K5(Ninja ninja)//Hayden
    {
        super();
        this.ninja = ninja;
        prepare();
    }
       private void prepare(){//Hayden
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
        addObject(doort10, 80, 620-40+20);

        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        addObject(levelCounter, 950, 15);
        addObject(ninja, 100, 100);
        levelCounter.setValue(3);
            
            
            
            
        Fence fence77 = new Fence();
        addObject(fence77, 218, 76);
        Fence fence78 = new Fence();
        addObject(fence78, 221, 118);
        Fence fence79 = new Fence();
        addObject(fence79, 219, 162);
        Fence fence80 = new Fence();
        addObject(fence80, 223, 213);
        Fence fence81 = new Fence();
        addObject(fence81, 77, 378);
        Fence fence82 = new Fence();
        addObject(fence82, 127, 380);
        Fence fence83 = new Fence();
        addObject(fence83, 179, 385);
        Fence fence84 = new Fence();
        addObject(fence84, 222, 382);
        Fence fence85 = new Fence();
        addObject(fence85, 275, 389);
        Fence fence86 = new Fence();
        addObject(fence86, 334, 391);
        Fence fence87 = new Fence();
        addObject(fence87, 387, 397);
        Fence fence88 = new Fence();
        addObject(fence88, 436, 396);
        Fence fence89 = new Fence();
        addObject(fence89, 440, 356);
        Fence fence90 = new Fence();
        addObject(fence90, 447, 312);
        Fence fence91 = new Fence();
        addObject(fence91, 451, 276);
        Fence fence92 = new Fence();
        addObject(fence92, 456, 238);
        Fence fence93 = new Fence();
        addObject(fence93, 443, 563);
        fence81.setLocation(73, 424);
        fence82.setLocation(121, 423);
        fence83.setLocation(170, 422);
        fence84.setLocation(216, 421);
        fence85.setLocation(263, 420);
        fence86.setLocation(309, 420);
        fence87.setLocation(358, 420);
        fence88.setLocation(408, 420);
        fence89.setLocation(457, 419);
        fence90.setLocation(457, 371);
        fence91.setLocation(458, 323);
        fence92.setLocation(458, 275);
        fence77.setLocation(224, 74);
        fence78.setLocation(223, 124);
        fence79.setLocation(222, 171);
        fence80.setLocation(222, 219);
        Lv1Melee redmm = new Lv1Melee(2, 1);
        addObject(redmm, 134, 321);
        Lv1Melee redmm2 = new Lv1Melee(2, 1);
        addObject(redmm2, 356, 332);
        Lv1Melee redmm3 = new Lv1Melee(2, 1);
        addObject(redmm3, 364, 144);
        BlueRM bluerm = new BlueRM(3, 1);
        addObject(bluerm, 602, 152);
        bluerm.setLocation(593, 144);
        BlueRM bluerm2 = new BlueRM(3, 1);
        addObject(bluerm2, 638, 643-50);
        Lv1Melee redmm4 = new Lv1Melee(2, 1);
        addObject(redmm4, 601, 418);
        Lv1Melee redmm5 = new Lv1Melee(2, 1);
        addObject(redmm5, 320, 566-50-40); 
            makeAllIcons();
        
                npcs = getObjects(NPCS.class);
       for(int i = 0; i<npcs.size(); i++)
       {
           TempText2 text = new TempText2(npcs.get(i));
           addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
       }
    }
    public void act()//Hayden bill
    {
        counterDelay++;
        if (!played){
            Peaceful.playLoop();
            played = !played;
        }
        if (Greenfoot.isKeyDown("h")&&delay>10) //bill
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
    public void makeAllIcons()//sean
    {
        SwordIcon swordicon = new SwordIcon();
        addObject(swordicon, 889, 360);
        ShurikenIcon shurikenicon = new ShurikenIcon();
        addObject(shurikenicon, 838, 360);
    }
    public void checkDoor()//Hayden
    {
        if(ninja.checkDoor()==true){
            Peaceful.stop();
            Greenfoot.setWorld(new K7(ninja));
        }
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
       Greenfoot.setWorld(new K5(ninja));
    }
    
}
