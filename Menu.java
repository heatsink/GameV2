import greenfoot.*;

public class Menu extends World
{
    // Menu Variables Start [Bill]
    private Trap trap;
    private int delay = 0;
    private TempText text1;
    private TempText text2;
    private TempText text3;
    private TempText text4;
    private TempText text5;
    private TempText text6;
    private TempText text7;
    private TempText text10;
    // background from http://www.thedigitalyardsale.com/freebies/freebie-6-old-paper-textures/
    
    //http://soundbible.com/tags-bounce.html
    GreenfootSound clickSound = new GreenfootSound("Bounce-SoundBible.com-12678623.mp3");
    // Menu Variables End [Bill]
    // Button Constructor Start [Billl]
    public Menu(Trap trap)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        this.trap = trap;
        Button button1 = new Button(1);
        addObject(button1, 100, 250-75);
        Button button2 = new Button(2);
        addObject(button2, 100, 450-75);
        Button button3 = new Button(3);
        addObject(button3, 100, 650-75);
	ReturnToGame returnToGame = new ReturnToGame();
        addObject(returnToGame, 825-25, 578-25);
        if (trap.getNinja() != null)
        {
            text1 = new TempText("Melee Damage: "+Integer.toString(trap.getNinja().getMeleeDamage()));
            addObject(text1, 300, 250-75);
            text2 = new TempText("Range Damage: "+Integer.toString(trap.getNinja().getRangeDamage()));
            addObject(text2, 300, 450-75);
            text3 = new TempText("Armor: "+Integer.toString(trap.getNinja().getArmor()));
            addObject(text3, 250, 650-75);
            text4 = new TempText("Points: "+Integer.toString(trap.getNinja().getPoints()));
            addObject(text4, 250, 150-75);
            text5 = new TempText("You need "+trap.getNinja().getMeleeDamage()*5+" points to level up.");
            addObject(text5, 440, 250-35);
            text6 = new TempText("You need "+trap.getNinja().getRangeDamage()*5+" points to level up.");
            addObject(text6, 440, 450-35);
            text7 = new TempText("You need "+(trap.getNinja().getArmor()-9)*5+" points to level up.");
            addObject(text7, 440, 650-35);
            text10 = new TempText("Ninja Level: "+Integer.toString(trap.getNinja().getNinjaLv()));
            addObject(text10, 450, 100-25);
        }
        if (trap.getBoy() != null)
        {
            text1 = new TempText("Melee Damage: "+Integer.toString(trap.getBoy().getMeleeDamage()));
            addObject(text1, 300, 250-75);
            text2 = new TempText("Range Damage: "+Integer.toString(trap.getBoy().getRangeDamage()));
            addObject(text2, 300, 450-75);
            text3 = new TempText("Armor: "+Integer.toString(trap.getBoy().getArmor()));
            addObject(text3, 250, 650-75);
            text4 = new TempText("Points: "+Integer.toString(trap.getBoy().getPoints()));
            addObject(text4, 250, 150-75);
            text5 = new TempText("You need "+trap.getBoy().getMeleeDamage()*5+" points to level up.");
            addObject(text5, 440, 250-35);
            text6 = new TempText("You need "+trap.getBoy().getRangeDamage()*5+" points to level up.");
            addObject(text6, 440, 450-35);
            text7 = new TempText("You need "+(trap.getBoy().getArmor()-9)*5+" points to level up.");
            addObject(text7, 440, 650-35);
            //text10 = new TempText("Ninja Level: "+Integer.toString(trap.getBoy().getNinjaLv()));
            //addObject(text10, 350, 100);
        }

        prepare();
    }
    // Button Constructor End [Billl]
    // Menu Implementation Start [Bill]
    public void act()
    {
        if (Greenfoot.isKeyDown("h")&&delay>10) 
        {
            clickSound.play();
            Greenfoot.setWorld(trap);
            delay = 0;
        }
        delay++;
        if (trap.getNinja() != null)
        {
            text1.updateImage("Melee Damage: "+Integer.toString(trap.getNinja().getMeleeDamage()));
            text2.updateImage("Range Damage: "+Integer.toString(trap.getNinja().getRangeDamage()));
            text3.updateImage("Armor: "+Integer.toString(trap.getNinja().getArmor()));
            text4.updateImage("Points: "+Integer.toString(trap.getNinja().getPoints()));
            text5.updateImage("You need "+trap.getNinja().getMeleeDamage()*5+" points to level up.");
            text6.updateImage("You need "+trap.getNinja().getRangeDamage()*5+" points to level up.");
            text7.updateImage("You need "+(trap.getNinja().getArmor()-9)*5+" points to level up.");
            text10.updateImage("Ninja Level: "+Integer.toString(trap.getNinja().getNinjaLv()));
        }
        if (trap.getBoy() != null)
        {
            text1.updateImage("Melee Damage: "+Integer.toString(trap.getBoy().getMeleeDamage()));
            text2.updateImage("Range Damage: "+Integer.toString(trap.getBoy().getRangeDamage()));
            text3.updateImage("Armor: "+Integer.toString(trap.getBoy().getArmor()));
            text4.updateImage("Points: "+Integer.toString(trap.getBoy().getPoints()));
            text5.updateImage("You need "+trap.getBoy().getMeleeDamage()*5+" points to level up.");
            text6.updateImage("You need "+trap.getBoy().getRangeDamage()*5+" points to level up.");
            text7.updateImage("You need "+(trap.getBoy().getArmor()-9)*5+" points to level up.");
            //text10.updateImage("Ninja Level: "+Integer.toBoy(trap.getNinja().getNinjaLv()));
        }
    }
    // Menu Implementation End [Bill]
    // [Bill]
    public Trap getTrap()
    {
        return trap;
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        SwordIcon swordicon = new SwordIcon();
        addObject(swordicon, 183, 297-75);
        ShurikenIcon shurikenicon = new ShurikenIcon();
        addObject(shurikenicon, 186, 505-75);
        swordicon.setLocation(176, 296-75);
        shurikenicon.setLocation(177, 490-75);
    }
}