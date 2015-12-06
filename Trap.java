import greenfoot.*;
// Bill & Hayden & sean
/**
 * Write a description of class Trap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trap extends World
{
    Ninja ninja;
    Boy boy;
    DeathWorld deathWorld;
     GreenfootSound velocitator = new GreenfootSound("Velocitator.mp3");
     //sound cred http://www.newgrounds.com/audio/listen/656737
    //http://soundbible.com/tags-bounce.html
    GreenfootSound clickSound = new GreenfootSound("Bounce-SoundBible.com-12678623.mp3");
    /**
     * Constructor for objects of class Trap.
     * 
     */
    public Trap() //Bill
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        prepareHUD();
        //makeAllIcons();
    }
    public void prepareHUD()//bill
    {
        HUD hud = new HUD();
        addObject(hud, 852+50-1, 373);
        NinjaImage ninjaImage = new NinjaImage();
        addObject(ninjaImage, 808, 55);
        ActionBar actionBar = new ActionBar();
        addObject(actionBar, 881, 438);
        UpgradeIcon upgradeIcon = new UpgradeIcon();
        addObject(upgradeIcon, 790, 360);
    }
    public Ninja getNinja()//bill
    {
        return ninja;
    }
    public Boy getBoy()//bill
    {
        return boy;
    }
    public void makeAllIcons()//sean
    {
        SwordIcon swordicon = new SwordIcon();
        addObject(swordicon, 889, 360);
        ShurikenIcon shurikenicon = new ShurikenIcon();
        addObject(shurikenicon, 838, 360);
        StealthIcon stealthicon = new StealthIcon();
        addObject(stealthicon, 923, 308);
        DashIcon dashicon = new DashIcon();
        addObject(dashicon, 819, 308);
        DoubleDamageIcon doubledamageicon = new DoubleDamageIcon();
        addObject(doubledamageicon, 871, 308);
    }
    public void infernostart()  // [Hayden]
   {
        deathWorld = new DeathWorld(ninja);
        Greenfoot.setWorld(deathWorld);
   }
      public void gameover(){ //Hayden
       ninja.setHP(ninja.getArmor());
       Greenfoot.setWorld(new Kyobashi(ninja));
    }
     public void stopmusic(){// Hayden
        
        velocitator.stop();
    }

}
