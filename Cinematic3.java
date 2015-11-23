import greenfoot.*;

/**
 * Write a description of class Cinematic3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cinematic3 extends Trap
{
    Ninja ninja;
    /**
     * Constructor for objects of class Cinematic3.
     * 
     */
    public Cinematic3(Ninja ninja)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(); 
        this.ninja = ninja;
        prepare();
    }
    public void prepare(){
        
        doorT10 door = new doorT10();
        addObject(door, 40, 375);
        
        
        for (int i = 0; i < 150; i++)
        {
            Bush topBush = new Bush();
            addObject(topBush, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight())/2 -100);
            Bush bottomBush = new Bush();
            addObject(bottomBush, Greenfoot.getRandomNumber(getWidth()), (getHeight() + 70 - Greenfoot.getRandomNumber(getHeight()/2)));
        }
        for (int i = 0; i<16; i++)
        {
            Woman w = new Woman();
            addObject(w, Greenfoot.getRandomNumber(650)+100, Greenfoot.getRandomNumber(750));
        }
        for (int i = 0; i<16; i++)
        {
            Man m = new Man();
            addObject(m, Greenfoot.getRandomNumber(650)+100, Greenfoot.getRandomNumber(750));
        }
        TYN tyn = new TYN();
        addObject(tyn, 375, 600);
        addObject(ninja, 700, 375);
        for (int i = 0; i<16; i++)
        {
            Smoke1 fence = new Smoke1();
            addObject(fence, 30, 50*i);
        }
        for (int i = 0; i<16; i++)
        {
            Smoke1 fence = new Smoke1();
            addObject(fence, 150, 50*i);
        }
        for (int i = 0; i<16; i++)
        {
            Smoke1 fence = new Smoke1();
            addObject(fence, 270, 50*i);
        }
        for (int i = 0; i<16; i++)
        {
            Smoke1 fence = new Smoke1();
            addObject(fence, 400, 50*i);
        }
        for (int i = 0; i<16; i++)
        {
            Smoke1 fence = new Smoke1();
            addObject(fence, 520, 50*i);
        }
        for (int i = 0; i<16; i++)
        {
            Smoke1 fence = new Smoke1();
            addObject(fence, 640, 50*i);
        }
        for (int i = 0; i<16; i++)
        {
            Smoke1 fence = new Smoke1();
            addObject(fence, 700, 50*i);
        }
        
    }
    public void prepareHUD()
    {
    }
    public void makedoor(){
        
        doorT10 door = new doorT10();
        addObject(door, 60, 375);
    }
    public void checkDoor()
   {
       if(ninja.checkDoor()==true)
            Greenfoot.setWorld(new Kyobashi4(ninja));
   }
   public void act(){
       checkDoor();
    }
}
