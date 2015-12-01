import greenfoot.*;
import java.util.*;
/**
 * Sean's Level
 */
public class Inferno1 extends Trap
{
    Counter shurikenCounter = new ShurikenCounter(getThisWorld(),"Shurikens: ");
    Counter powerCounter = new PowerCounter("Power: ");
    Counter levelCounter = new Counter("Stage: ");
    Counter healthCounter = new HealthCounter(getThisWorld(), "Health: ");
    
    private List <MeleeMinion> meleeMinions;
    private List <RangedMinion> rangedMinions;
    Ninja ninja;
    // Inferno Themesong https://www.youtube.com/watch?v=kGYRIf6RdS4
    GreenfootSound burningSteppes = new GreenfootSound("Music of Cataclysm - Burning Steppes.mp3");
    private int delay = 11;
    private int fireballDelay = 11;
    private int counterDelay = 0;
    public Inferno1(Ninja ninja)
    {
        super();
        burningSteppes.setVolume(40);
        this.ninja = ninja;
        ninja.addPowerUp(4);
        prepare();
    }
    
    private void prepare()
    {
        InfernoDoor door = new InfernoDoor();
        addObject(door, 663-50, 651-50);

        for(int i = 0; i<14; i++)
            for(int j = 0; j<2; j++)
            {
                InfernoFence infernoFence = new InfernoFence();
                addObject(infernoFence, 25+j*700, 50*i+25);
        }
        for(int i = 1;i<14; i++)
            for(int j = 0; j<2; j++)
            {
                InfernoFence infernoFence = new InfernoFence();
                addObject(infernoFence, 50*i+25, 25+j*(700-50));
        }

        for(int i = 0; i<9; i++)
        {
            InfernoFence infernoFence = new InfernoFence();
            addObject(infernoFence, 50*i+25, 125);
        }
        for(int i = 0; i<9; i++)
        {
            InfernoFence infernoFence = new InfernoFence();
            addObject(infernoFence, 50*i+175+100, 225);
        }

        Firebat firebat2 = new Firebat(8, 3);
        addObject(firebat2, 511, 625);

        Firebat firebat3 = new Firebat(8, 3);
        addObject(firebat3, 588, 534);

        Firebat firebat4 = new Firebat(8, 3);
        addObject(firebat4, 629, 489);

        Firebat firebat5 = new Firebat(8, 3);
        addObject(firebat5, 203, 608);

        Firebat firebat6 = new Firebat(8, 3);
        addObject(firebat6, 484, 388);

        Firebat firebat7 = new Firebat(8, 3);
        addObject(firebat7, 320, 350);

        InfernoFence infernoFence = new InfernoFence();
        addObject(infernoFence, 133, 417);


        InfernoFence infernoFence3 = new InfernoFence();
        addObject(infernoFence3, 164, 571);

        InfernoFence infernoFence5 = new InfernoFence();
        addObject(infernoFence5, 429, 360);

        InfernoFence infernoFence6 = new InfernoFence();
        addObject(infernoFence6, 325, 669);

        InfernoFence infernoFence7 = new InfernoFence();
        addObject(infernoFence7, 452, 571);

        InfernoFence infernoFence8 = new InfernoFence();

        addObject(healthCounter, 866, 120);
        healthCounter.setValue(ninja.getNINJAHP());

        addObject(shurikenCounter, 866, 201);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());

        addObject(powerCounter, 866, 161);
        powerCounter.setValue(ninja.getPOWERBAR());

        addObject(levelCounter, 950, 15);
        levelCounter.setValue(1);
        addObject(ninja, 75, 75);
        ninja.setLocation(100, 75);

        
        HealthGlobe healthglobe = new HealthGlobe();
        addObject(healthglobe, 668, 57);
        healthglobe.setLocation(674, 54);
        HealthGlobe healthglobe2 = new HealthGlobe();
        addObject(healthglobe2, 638, 138);
        healthglobe2.setLocation(672, 110);
        instaPower instapower = new instaPower();
        addObject(instapower, 87, 624);
        instapower.setLocation(76, 623);
        addShuriken addshuriken = new addShuriken();
        addObject(addshuriken, 76, 181);
        addShuriken addshuriken2 = new addShuriken();
        addObject(addshuriken2, 466, 123);
        addshuriken2.setLocation(675, 277);
        instaPower instapower2 = new instaPower();
        addObject(instapower2, 429, 627);
        instapower2.setLocation(431, 625);
        makeAllIcons();
        meleeMinions = getObjects(MeleeMinion.class);
        for(int i = 0; i<meleeMinions.size(); i++)
        {
            TempText8 text = new TempText8(meleeMinions.get(i));
            addObject(text, meleeMinions.get(i).getX(), meleeMinions.get(i).getY()-20);
        }
    }

    public void act()
    {
        burningSteppes.playLoop();
       //makeSmokeFireball();
       counterDelay++;
       if (Greenfoot.isKeyDown("h")&&delay>10) 
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
        /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       
       /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       }
       delay++;
       fireballDelay++;
       checkDoor();
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
    /*
    public void makeSmokeFireball()
    {
        if (delay > 100)
        {
            int randomNumber = Greenfoot.getRandomNumber(1000);
            if (randomNumber < 50)
            {
                SmokeFireball smokeFireball = new SmokeFireball();
                addObject(smokeFireball, 500, 475);
                delay = 0;
            }
            if (randomNumber >= 50 && randomNumber < 100)
            {
                SmokeFireball smokeFireball = new SmokeFireball();
                addObject(smokeFireball, 95, 661);
                delay = 0;
            }
            if (randomNumber >= 100 && randomNumber < 150)
            {
                SmokeFireball smokeFireball = new SmokeFireball();
                addObject(smokeFireball, 160, 493);
                delay = 0;
            }
            if (randomNumber >= 150 && randomNumber < 200)
            {
                SmokeFireball smokeFireball = new SmokeFireball();
                addObject(smokeFireball, 637, 423);
                delay = 0;
            }
            if (randomNumber >= 200 && randomNumber < 250)
            {
                SmokeFireball smokeFireball = new SmokeFireball();
                addObject(smokeFireball, 422, 285);
                delay = 0;
            }
        }
    }
    */
    public void checkDoor()
    {
        if(ninja.checkInfernoDoor()==true)
{
        burningSteppes.stop();
            Greenfoot.setWorld(new Inferno2(ninja));
        }
    }
   public Ninja getNinja()
   {
       return ninja;
   }
   public Trap getThisWorld()
   {
       return this;
   }
       public void gameover(){
       ninja.setHP(ninja.getArmor());
       burningSteppes.stop();
       Greenfoot.setWorld(new Inferno1(ninja));
    }
}