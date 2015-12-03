import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class K2 extends Trap
{
    Ninja ninja;
    static boolean played = false;
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    int delay = 11;
    private List<NPCS> npcs;
    private int counterDelay = 0;
    // https://www.youtube.com/watch?v=PZV2nASIe1o
    GreenfootSound Peaceful = new GreenfootSound("Peaceful.mp3");
    public K2(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        prepare();
        
    }

    private void prepare()
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
        addObject(doort10, 85, 640-50+15);

        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        addObject(levelCounter, 950, 15);
        levelCounter.setValue(1);
        addObject(ninja, 150, 100);
        Fence fence77 = new Fence();
        addObject(fence77, 177, 163);
        Fence fence78 = new Fence();
        addObject(fence78, 73, 171);
        Fence fence79 = new Fence();
        addObject(fence79, 128, 176);
        Fence fence80 = new Fence();
        addObject(fence80, 152, 175);
        Fence fence81 = new Fence();
        addObject(fence81, 239, 178);
        Fence fence82 = new Fence();
        addObject(fence82, 318, 184);
        Fence fence83 = new Fence();
        addObject(fence83, 368, 184);
        Fence fence84 = new Fence();
        addObject(fence84, 279, 172);
        Fence fence85 = new Fence();
        addObject(fence85, 209, 172);
        Fence fence86 = new Fence();
        addObject(fence86, 422, 191);
        Fence fence87 = new Fence();
        addObject(fence87, 682, 191);
        fence79.setLocation(120, 170);
        fence80.setLocation(142, 169);
        fence77.setLocation(180, 169);
        fence85.setLocation(216, 170);
        fence81.setLocation(244, 170);
        fence84.setLocation(278, 170);
        fence82.setLocation(319, 172);
        fence82.setLocation(326, 170);
        fence83.setLocation(374, 170);
        fence86.setLocation(422, 170);
        BlueRM redRM = new BlueRM(1, 1);
        addObject(redRM, 253, 523);
        Lv1Melee redRM2 = new Lv1Melee(1, 1);
        addObject(redRM2, 557, 327);
        BlueRM redRM3 = new BlueRM(1, 1);
        addObject(redRM3, 90, 236);
        BlueRM redRM4 = new BlueRM(1, 1);
        addObject(redRM4, 659, 600);
        Lv1Melee redrm = new Lv1Melee(1, 1);
        addObject(redrm, 314, 339);
        Lv1Melee redrm2 = new Lv1Melee(1, 1);
        addObject(redrm2, 513, 543);
        Fence fence88 = new Fence();
        addObject(fence88, 683, 442);
        Fence fence89 = new Fence();
        addObject(fence89, 416, 443);
        Fence fence90 = new Fence();
        addObject(fence90, 199, 322);
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
            Greenfoot.setWorld(new K4(ninja));
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
       Greenfoot.setWorld(new K2(ninja));
    }
}
