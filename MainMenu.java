import greenfoot.*;

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class MainMenu extends World//Hayden sean
{
    //http://i1333.photobucket.com/albums/w631/megapowerskills/Background_zps510c32af.jpg
    
    // new tentative background http://whisperingworlds.com/gallery/albums/fantasylandbg/fantasyland1.jpg
    
    private GreenfootSound mainMenuTheme = new GreenfootSound("Fable Theme.mp3");
    private int volumeMonitor = 0;
    private int volume = 70;
    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()//Hayden
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        mainMenuTheme.setVolume(volume);
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()//Hayden
    {
        NinjaFighter ninjafighter = new NinjaFighter();
        addObject(ninjafighter, 373+125, 202);
        Play play = new Play(mainMenuTheme);
        addObject(play, 410, 498);
        play.setLocation(374+125, 469);
    }
    public void act()//sean
    {
        volumeMonitor++;
        if (volumeMonitor >= 30)
        {
            volumeMonitor-= 30;
            if (volume >= 30)
            {
                volume --;
            }
        }
        mainMenuTheme.setVolume(volume);
        mainMenuTheme.playLoop();
    }
}
