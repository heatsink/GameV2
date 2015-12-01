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
        addObject(healthCounter, 70, 730);
        addObject(shurikenCounter, 225, 730);
        addObject(powerCounter, 500, 730);
        addObject(levelCounter, 355, 730);
        levelCounter.setValue(1);
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
        counterDelay++;
        if(getObjects(Ninja.class).size() != 0 && counterDelay >= 10)
        {
        healthCounter.setValue(ninja.getNINJAHP());
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
        powerCounter.setValue(ninja.getPOWERBAR());
        counterDelay -= 10;
        
        }
        if (Greenfoot.isKeyDown("h")&&delay>10) 
        {
            Menu menu = new Menu(getThisWorld());
            Greenfoot.setWorld(menu);
            delay = 0;
        }
        if (getObjects(NPCS.class).size()==0)
        {
            while (getObjects(NPCS.class).size()<stage)
            {
                random=Greenfoot.getRandomNumber(10);
                if (random==0)
                {
                    RedMM red=new RedMM(stage,stage);
                    addObject(red,Greenfoot.getRandomNumber(getWidth()-613)+67,Greenfoot.getRandomNumber(getHeight()-594)+65);
                    TempText2 text = new TempText2(red);
                    addObject(text, red.getX(), red.getY()-20);
                }
                if (random==1)
                {
                    BlueMM red=new BlueMM(stage,stage);
                    addObject(red,Greenfoot.getRandomNumber(getWidth()-613)+67,Greenfoot.getRandomNumber(getHeight()-594)+65);
                    TempText2 text = new TempText2(red);
                    addObject(text, red.getX(), red.getY()-20);
                }
                if (random==2)
                {
                    Firebat red=new Firebat(stage,stage);
                    addObject(red,Greenfoot.getRandomNumber(getWidth()-613)+67,Greenfoot.getRandomNumber(getHeight()-594)+65);
                    TempText2 text = new TempText2(red);
                    addObject(text, red.getX(), red.getY()-20);
                }
                if (random==3)
                {
                    BlackMM red=new BlackMM(stage,stage);
                    addObject(red,Greenfoot.getRandomNumber(getWidth()-613)+67,Greenfoot.getRandomNumber(getHeight()-594)+65);
                    TempText2 text = new TempText2(red);
                    addObject(text, red.getX(), red.getY()-20);
                }
                if (random==4)
                {
                    AxisFirebat red=new AxisFirebat(stage,stage);
                    addObject(red,Greenfoot.getRandomNumber(getWidth()-613)+67,Greenfoot.getRandomNumber(getHeight()-594)+65);
                    TempText2 text = new TempText2(red);
                    addObject(text, red.getX(), red.getY()-20);
                }
                 if (random==5)
                {
                    addShuriken shuriken=new addShuriken();
                    addObject(shuriken,Greenfoot.getRandomNumber(getWidth()-613)+67,Greenfoot.getRandomNumber(getHeight()-594)+65);
                    
                }
                if (random==6)
                {
                    addShuriken shuriken=new addShuriken();
                    addObject(shuriken,Greenfoot.getRandomNumber(getWidth()-613)+67,Greenfoot.getRandomNumber(getHeight()-594)+65);
                    
                }
                if (random==7)
                {
                    addShuriken shuriken=new addShuriken();
                    addObject(shuriken,Greenfoot.getRandomNumber(getWidth()-613)+67,Greenfoot.getRandomNumber(getHeight()-594)+65);
                    
                }
                if (random==8)
                {
                    addShuriken shuriken=new addShuriken();
                    addObject(shuriken,Greenfoot.getRandomNumber(getWidth()-613)+67,Greenfoot.getRandomNumber(getHeight()-594)+65);
                    
                }
                if (random==9)
                {
                    HealthGlobe healthGlobe=new HealthGlobe();
                    addObject(healthGlobe,Greenfoot.getRandomNumber(getWidth()-613)+67,Greenfoot.getRandomNumber(getHeight()-594)+65);
                    
                }
                if (random==10)
                {
                    HealthGlobe healthGlobe=new HealthGlobe();
                    addObject(healthGlobe,Greenfoot.getRandomNumber(getWidth()-613)+67,Greenfoot.getRandomNumber(getHeight()-594)+65);
                    
                }
            }
            stage++;
        }
        delay++;
    }
    public Ninja getNinja()
    {
        return ninja;
    }
    public Trap getThisWorld()
    {
        return this;
    }
}
