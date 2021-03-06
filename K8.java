import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class K8 extends Trap//Hayden
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
     * Constructor for objects of class K8.
     * 
     */
    public K8(Ninja ninja)//Hayden
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
        for (int i = 0; i<12; i++)
        {
            Fence fence = new Fence();
            addObject(fence, 50*i+175, 160);
        }
        for (int i = 0; i<12; i++)
        {
            Fence fence = new Fence();
            addObject(fence, 50*i+25, 550);
        }
        doorT10 doort10 = new doorT10();
        addObject(doort10, 80, 620);
        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        addObject(levelCounter, 950, 15);
        addObject(ninja, 650, 100);
        levelCounter.setValue(5);
        //addObject(ninja, 600, 100);

        doort10.setLocation(86, 651-50);
        Fence fence101 = new Fence();
        addObject(fence101, 380, 512);
        Fence fence102 = new Fence();
        addObject(fence102, 384, 205);
        Fence fence103 = new Fence();
        addObject(fence103, 225, 357);
        Fence fence104 = new Fence();
        addObject(fence104, 549, 362);
        Fence fence105 = new Fence();
        addObject(fence105, 233, 508);
        Fence fence106 = new Fence();
        addObject(fence106, 231, 216);
        Fence fence107 = new Fence();
        addObject(fence107, 550, 213);
        Fence fence108 = new Fence();
        addObject(fence108, 558, 508);
        BlueRM bluerm = new BlueRM(2, 1);
        addObject(bluerm, 386, 300);
        BlueRM bluerm2 = new BlueRM(2, 1);
        addObject(bluerm2, 388, 434);
        fence106.setLocation(226, 210);
        fence105.setLocation(227, 501);
        fence102.setLocation(376, 210);
        fence101.setLocation(376, 501);
        fence107.setLocation(551, 208);
        fence108.setLocation(552, 502);
        fence101.setLocation(388, 501);
        fence102.setLocation(386, 209);
        fence107.setLocation(545, 209);
        Lv1Melee redmm = new Lv1Melee(4, 2);
        addObject(redmm, 120, 288);
        Lv1Melee redmm2 = new Lv1Melee(4, 2);
        addObject(redmm2, 125, 443);
        Lv1Melee redmm3 = new Lv1Melee(4, 2);
        addObject(redmm3, 635, 288);
        Lv1Melee redmm4 = new Lv1Melee(4, 2);
        addObject(redmm4, 640, 449);
        HealthGlobe hg = new HealthGlobe();
        addObject(hg, 670, 640-50);
        addShuriken sb = new addShuriken();
        addObject(sb, 630, 640-50);

        makeAllIcons();

        npcs = getObjects(NPCS.class);
        for(int i = 0; i<npcs.size(); i++)
        {
            TempText2 text = new TempText2(npcs.get(i));
            addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
        }
        StaticStoryPage staticstorypage = new StaticStoryPage(5);
        addObject(staticstorypage, 564, 71);
        staticstorypage.setLocation(390, 89);
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
            Greenfoot.setWorld(new K10(ninja));}
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
       Greenfoot.setWorld(new K8(ninja));
    }
}
