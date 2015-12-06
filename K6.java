import greenfoot.*;
import java.util.*;//Hayden
/**
 * Write a description of class K6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class K6 extends Trap//Hayden
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
     * Constructor for objects of class K6.
     * 
     */
    public K6(Ninja ninja)//Hayden
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
                addObject(fence, 50*i+25, 25+j*700);
            }

        
                for (int i = 0; i<7; i++)
        {
            Fence fence = new Fence();
            addObject(fence, 50*i+200, 50*i+200);
        }
        addObject(ninja, 675, 625);
        
        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        addObject(levelCounter, 950, 15);
        levelCounter.setValue(3);
        
        doorT10 doort10 = new doorT10();
        addObject(doort10, 85, 85);
        
        HealthGlobe healthglobe = new HealthGlobe();
        addObject(healthglobe, 403, 351);
        healthglobe.setLocation(396, 346);
        addShuriken addshuriken = new addShuriken();
        addObject(addshuriken, 343, 404);
        addshuriken.setLocation(351, 399);
        BlueRM bluerm = new BlueRM(3, 1);
        addObject(bluerm, 304, 245);
        BlueRM bluerm2 = new BlueRM(3, 1);
        addObject(bluerm2, 255, 300);
        bluerm2.setLocation(252, 300);
        Lv1Melee redmm = new Lv1Melee(2, 1);
        addObject(redmm, 444, 313);
        Lv1Melee redmm2 = new Lv1Melee(2, 1);
        addObject(redmm2, 317, 448);
        Lv1Melee redmm3 = new Lv1Melee(2, 1);
        addObject(redmm3, 164, 458);
        Lv1Melee redmm4 = new Lv1Melee(2, 1);
        addObject(redmm4, 451, 172);
        BlueRM bluerm3 = new BlueRM(3, 1);
        addObject(bluerm3, 88, 652);
        BlueRM bluerm4 = new BlueRM(3, 1);
        addObject(bluerm4, 649, 106);
        Lv1Melee redmm5 = new Lv1Melee(2, 1);
        addObject(redmm5, 537, 415);
        Lv1Melee redmm6 = new Lv1Melee(2, 1);
        addObject(redmm6, 420, 546);
        makeAllIcons();
                npcs = getObjects(NPCS.class);
       for(int i = 0; i<npcs.size(); i++)
       {
           TempText2 text = new TempText2(npcs.get(i));
           addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
       }
    }
        public void act()//Hayden & bill
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
            Greenfoot.setWorld(new K7(ninja));}
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
       Greenfoot.setWorld(new K6(ninja));
    }
}
