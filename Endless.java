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
    Counter healthCounter = new Counter("Health: "); //Duy
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    private List<NPCS> npcs;
    Ninja ninja;
    int delay = 11;
    private int stage=1;
    private int random;
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
    }
    public void act()
    {
        if(getObjects(Ninja.class).size() != 0)
        {
        healthCounter.setValue(ninja.getNINJAHP());
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
        powerCounter.setValue(ninja.getPOWERBAR());
        /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       
        /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
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
                random=Greenfoot.getRandomNumber(5);
                if (random==0)
                {
                    RedMM red=new RedMM(stage,stage);
                    addObject(red,Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
                    TempText2 text = new TempText2(red);
                    addObject(text, red.getX(), red.getY()-20);
                }
                if (random==1)
                {
                    BlueMM red=new BlueMM(stage,stage);
                    addObject(red,Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
                    TempText2 text = new TempText2(red);
                    addObject(text, red.getX(), red.getY()-20);
                }
                if (random==2)
                {
                    Firebat red=new Firebat(stage,stage);
                    addObject(red,Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
                    TempText2 text = new TempText2(red);
                    addObject(text, red.getX(), red.getY()-20);
                }
                if (random==3)
                {
                    BlackMM red=new BlackMM(stage,stage);
                    addObject(red,Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
                    TempText2 text = new TempText2(red);
                    addObject(text, red.getX(), red.getY()-20);
                }
                if (random==4)
                {
                    AxisFirebat red=new AxisFirebat(stage,stage);
                    addObject(red,Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
                    TempText2 text = new TempText2(red);
                    addObject(text, red.getX(), red.getY()-20);
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
