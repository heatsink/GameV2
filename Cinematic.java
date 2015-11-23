import greenfoot.*;
/**
 * Functionality in this class:
 */
public class Cinematic extends World
{
    private Kyobashi cinematic;
    private double time = 0;
    private int delay = 0;
    private double cloudIncrease = 0;
    private boolean createdOldManBot = false;
    private boolean createdLatestTextBox = false;
    private boolean middleClouds = false;
    private boolean flashed = false;
    GreenfootSound backgroundTheme = new GreenfootSound("Foreboding.mp3");
    private GreenfootSound dragonSpawn = new GreenfootSound("Roaring Lion-SoundBible.com-527774719.mp3");
    
    private Text text;
    private Ninja ninja;
    private Boy boy;
    private int volumeControl = 100;
    Flash flash = new Flash();
    public Cinematic(Kyobashi cinematic)
    {   
        
        super(1000, 700, 1, false); 
        boy = new Boy();
        prepare();
        this.cinematic = cinematic;
        
    }
    public void prepare()
    {
        
        backgroundTheme.play();
        // Create Ninja
        BoyBot boyBot = new BoyBot();
        addObject(boyBot, 175, 405);
        Bush ninjaBush = new Bush();
        addObject(ninjaBush, 175, 425);
        ninja = new Ninja();
        
        // Create many bushes at random locations not blocking the middle of the screen
        for (int i = 0; i < 150; i++)
        {
            Bush topBush = new Bush();
            addObject(topBush, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight())/2 -100);
            Bush bottomBush = new Bush();
            addObject(bottomBush, Greenfoot.getRandomNumber(getWidth()), (getHeight() + 70 - Greenfoot.getRandomNumber(getHeight()/2)));
        }
    }
    public void act()
    {
        //backgroundTheme.playLoop();
       // backgroundTheme.setVolume(100);
        // Allows us to change between worlds smoothly
        if (Greenfoot.isKeyDown("l")&&delay>10) 
        {
            backgroundTheme.pause();
            Greenfoot.setWorld(cinematic);
            delay = 0;
        }
       delay++;
       time += 0.01602;
       
       // CINEMATIC TIME RELATED FUNCTIONS
       if (time >= 3)
       {
           cloudFunction();
       }
       if (time >= 4.95 && flashed == false)
       {
           addObject(flash, 500, 350);
           OldManBot oldManBot = new OldManBot();
           addObject(oldManBot, 765, 375);
           flashed = true;
        }
       if (time >= 5 && createdOldManBot == false)
       {
           removeObject(flash);
           
           
           createdOldManBot = true;
           DragonBot dragonBot = new DragonBot();
           addObject(dragonBot, -50, 285);
           dragonSpawn.setVolume(30);
           dragonSpawn.play();
           DragonBot dragonBot2 = new DragonBot();
           addObject(dragonBot2, -50, 350);
           DragonBot dragonBot3 = new DragonBot();
           addObject(dragonBot3, -50, 415);
       }
       
       if (time >= 6)
       {
           dragonSpawn.stop();
        }
       if (time >= 8 && time <= 10 &&createdLatestTextBox == false)
       {
           //Text text = new Text("One day, the village of Kyobashi was threatened. \nA terrible force, the darkness, began to swarm.\nA lone berrypicker remained in the fields.");
           //addObject(text, 315, 465);
           createdLatestTextBox = true;
       }
       if (time > 10)
       {
           createdLatestTextBox = false;
       }
       if (time >=10 && time <= 27 && createdLatestTextBox == false)
       {
           createdLatestTextBox = true;
           //text.setText("An old man appeared\n\"Come with me.\"\n\"I will save you.\"");
           //Text text2 = new Text("An old man appeared\n\"Come with me.\"\n\"I will save you.\"");
           //addObject(text2, 310, 465);
       }
       if (time > 30)
       {
           volumeControl-= 1;
           backgroundTheme.setVolume(volumeControl);
       }
       setPaintOrder(BoyBot.class, OldManBot.class);
       startgame();
    }
    // Create continous clouds at random locations with differing speeds not blocking the middle of the screen
    public void cloudFunction()
    {
        if (cloudIncrease < 25)
        {
            cloudIncrease+= 0.05;
        }
        if (time >= 20 && cloudIncrease <= 50)
        {
            cloudIncrease += 2;
            middleClouds = true;
        }
        if (Greenfoot.getRandomNumber(1000) < 35 + (int)cloudIncrease)
        {
            Smoke topSmoke = new Smoke(Greenfoot.getRandomNumber(2)+ 1);
            addObject(topSmoke, -150, Greenfoot.getRandomNumber(getHeight()/2 - 150));
            Smoke bottomSmoke = new Smoke(Greenfoot.getRandomNumber(2) + 1);
            addObject(bottomSmoke, -150, (getHeight() + 125 - Greenfoot.getRandomNumber(getHeight()/2)));
            
            if (middleClouds == true)
            {
                Smoke middleSmoke = new Smoke(Greenfoot.getRandomNumber(2) + 1);
            addObject(middleSmoke, -150, (Greenfoot.getRandomNumber(275) + 200));
            }
        }
    }
    public void startgame(){
        if (time>= 32 || Greenfoot.isKeyDown("escape")){
            backgroundTheme.pause();
            Greenfoot.setWorld(new NewIntro0(boy));
        }
        
    }
    
}
