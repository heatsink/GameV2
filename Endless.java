import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Endless here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Endless extends Trap
{
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    GreenfootSound velocitator = new GreenfootSound("ninja_backgroundtheme.mp3");
    
    //GreenfootSound velocitator = new GreenfootSound("Velocitator.mp3");
     //sound cred http://www.newgrounds.com/audio/listen/656737
    private int d1 = 0;
    private List<NPCS> npcs;
    Ninja ninja;
    int delay = 11;
    private int stage=1;
    private int random;
    private int counterDelay = 0;
    /**
     * Constructor for objects of class Endless.
     * 
     */
    public Endless(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        prepare();
    }
    private void prepare()
    {
        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());
        addObject(levelCounter, 920, 50);
        levelCounter.setValue(stage);
        
        makeAllIcons();
        addObject(ninja, 75, 75);
        npcs = getObjects(NPCS.class);
        for(int i = 0; i<npcs.size(); i++)
        {
            TempText2 text = new TempText2(npcs.get(i));
            addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
        }
        
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
       
    }
    public void act()
    {
        if (d1 > 20)velocitator.playLoop();
        if (d1 < 30) d1++;
        
        counterDelay++;
        if(getObjects(Ninja.class).size() != 0 && counterDelay >= 10)
        {
        healthCounter.setValue(ninja.getNINJAHP());
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
        powerCounter.setValue(ninja.getPOWERBAR());
        levelCounter.setValue(stage-1);
        counterDelay -= 10;
        
        }
        if (Greenfoot.isKeyDown("h")&&delay>10) 
        {
            clickSound.play();
            Menu menu = new Menu(getThisWorld());
            Greenfoot.setWorld(menu);
            delay = 0;
        }
        if (getObjects(NPCS.class).size()==0)
        {
            while (getObjects(NPCS.class).size()<stage)
            {
                random=Greenfoot.getRandomNumber(9);
                if (random == 0)
                {
                    Lv1Melee red=new Lv1Melee(stage+stage/2, 1+ stage/3);
                    addObject(red,Greenfoot.getRandomNumber(getWidth()-367)+67,Greenfoot.getRandomNumber(getHeight()-250)+65);
                    TempText2 text = new TempText2(red);
                    addObject(text, red.getX(), red.getY()-20);
                }
                if (random==1)
                {
                    Firebat red=new Firebat(stage+stage/2,1+ stage/3);
                    addObject(red,Greenfoot.getRandomNumber(getWidth()-367)+67,Greenfoot.getRandomNumber(getHeight()-250)+65);
                    TempText2 text = new TempText2(red);
                    addObject(text, red.getX(), red.getY()-20);
                }
                if (random==2)
                {
                    Lv1Melee red=new Lv1Melee(stage+stage/2,1+ stage/3);
                    addObject(red,Greenfoot.getRandomNumber(getWidth()-367)+67,Greenfoot.getRandomNumber(getHeight()-250)+65);
                    TempText2 text = new TempText2(red);
                    addObject(text, red.getX(), red.getY()-20);
                }
                if (random==3)
                {
                    AxisFirebat red=new AxisFirebat(stage+stage/2,1+ stage/3);
                    addObject(red,Greenfoot.getRandomNumber(getWidth()-367)+67,Greenfoot.getRandomNumber(getHeight()-250)+65);
                    TempText2 text = new TempText2(red);
                    addObject(text, red.getX(), red.getY()-20);
                }
                 if (random==4)
                {
                    addShuriken shuriken=new addShuriken();
                    addObject(shuriken,Greenfoot.getRandomNumber(getWidth()-367)+67,Greenfoot.getRandomNumber(getHeight()-250)+65);
                    
                }
                if (random == 5)
                {
                    LavaMonster lavaMonster = new LavaMonster(stage+stage/2, 1+ stage/3, 100, 650, 0, 0);
                    addObject(lavaMonster, 400, Greenfoot.getRandomNumber(getHeight()-250)+65);
                    TempText7 text = new TempText7(lavaMonster);
                    addObject(text, lavaMonster.getX(), lavaMonster.getY()-20);
                }
                if (random == 6)
                {
                    LavaMonster lavaMonster = new LavaMonster(stage+stage/2, 1+ stage/3, 100, 650, 0, 0);
                    addObject(lavaMonster, 400, Greenfoot.getRandomNumber(getHeight()-250)+65);
                    TempText7 text = new TempText7(lavaMonster);
                    addObject(text, lavaMonster.getX(), lavaMonster.getY()-20);
                }
                if (random==7)
                {
                    addShuriken shuriken=new addShuriken();
                    addObject(shuriken,Greenfoot.getRandomNumber(getWidth()-367)+67,Greenfoot.getRandomNumber(getHeight()-250)+65);
                    
                }
                if (random==8)
                {
                    HealthGlobe healthGlobe=new HealthGlobe();
                    addObject(healthGlobe,Greenfoot.getRandomNumber(getWidth()-367)+67,Greenfoot.getRandomNumber(getHeight()-250)+65);
                    
                }
                if (random==9)
                {
                    HealthGlobe healthGlobe=new HealthGlobe();
                    addObject(healthGlobe,Greenfoot.getRandomNumber(getWidth()-367)+67,Greenfoot.getRandomNumber(getHeight()-250)+65);
                    
                }
            }
            stage++;
        }
        delay++;
    }
     public void makeAllIcons()
    {
        SwordIcon swordicon = new SwordIcon();
        addObject(swordicon, 889, 360);
        ShurikenIcon shurikenicon = new ShurikenIcon();
        addObject(shurikenicon, 838, 360);
        StealthIcon stealthicon = new StealthIcon();
        addObject(stealthicon, 871, 308);
        DashIcon dashicon = new DashIcon();
        addObject(dashicon, 819, 308);
        //DoubleDamageIcon doubledamageicon = new DoubleDamageIcon();
        //addObject(doubledamageicon, 871, 308);
    }
    public Ninja getNinja()
    {
        return ninja;
    }
    public Trap getThisWorld()
    {
        return this;
    }
    public void stopmusic(){
        velocitator.stop();
    }
}
