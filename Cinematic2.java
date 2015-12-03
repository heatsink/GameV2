import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Cinematic3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cinematic2 extends Trap
{
    Ninja ninja;
    private List<Flash> flash;
    private int c2t =0;
    private List<OldManBot5> oldmanbot5;
    private List<Graitful> graitful;
    GreenfootSound win = new GreenfootSound("win.mp3");
    // sound http://www.newgrounds.com/audio/listen/375369
    /**
     * Constructor for objects of class Cinematic3.
     * 
     */
    public Cinematic2(Ninja ninja)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(); 
        this.ninja = ninja;
        prepare();
    }
    public void prepare(){
        
        
        
        
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
        OldManBot5 OMB5 = new OldManBot5();
        addObject(OMB5, 160, 375);
        Graitful g = new Graitful();
        addObject(g, 160, 200);
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
            addObject(fence, 760, 50*i);
        }
        for (int i = 0; i<16; i++)
        {
            Smoke1 fence = new Smoke1();
            addObject(fence, 880, 50*i);
        }
        for (int i = 0; i<16; i++)
        {
            Smoke1 fence = new Smoke1();
            addObject(fence, 950, 50*i);
        }
        
    }
    public void prepareHUD()
    {
    }
    public void makedoor(){
        c2t++;
        if (c2t >=1003 && c2t <= 1006){
        doorT10 door = new doorT10();
        addObject(door, 60, 375);
       }
    }
    public void checkDoor()
   {
       if(ninja.checkDoor()==true){
       win.stop();
       ninja.setPoints(ninja.getPoints()+50);
       Greenfoot.setWorld(new Kyobashi4(ninja));
    }
   }
       public void flash(){
        if (c2t <= 1001 && c2t >= 1000){
            Flash flash = new Flash();
            addObject(flash, 375, 375);
        }
        if (c2t > 1005){
            flash = getObjects(Flash.class);
            if(flash.size()>0)
            removeObject(flash.get(0));
        }
        
    }
    public void Deletestuff(){
        if (c2t >=1001 && c2t <= 1005){
            oldmanbot5 = getObjects(OldManBot5.class);
            if (oldmanbot5.size()>0)
            {
                removeObject(oldmanbot5.get(0));
            }
            graitful = getObjects(Graitful.class);
            if (graitful.size()>0){
                removeObject(graitful.get(0));
            }
            
        }
    }
   public void act(){
       win.playLoop();
       checkDoor();
       makedoor();
       flash();
       Deletestuff();
    }
}

