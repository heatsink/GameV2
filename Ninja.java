import greenfoot.*;
/**
 * Functionality in this class:
 * Ninja Melee
 * Ninja Ranged
 * Relationship to Melee AI "CURRENTLY CALLED RANGED AI"
 */

public class Ninja extends Heroes
{
    private int progress = 0;
    private boolean powerUpTwo = false;
    boolean powerUpThree;
    private boolean transparent = false;
    private int transparentDelay = 36;

    private boolean haungsMode = false;
    static int speedMultiplier = 2;
    private int delay = 21;
    // Start Hayden Variables
    public int powerBar = 100;
    public int powerBarDelay = 0;

    public int shurikennumber = 8;
    public int maxShurikens = 8;

    private int delay1 = 71;
    private int ninjahp = 10;

    private int points = 0;
    private int meleeDamage = 1;
    private int rangeDamage = 1;
    private int armor = 10;
    // End Hayden Variables

    private int ninjaRotation = 0;
    private int swordRotation = 0;
    // Ninja sprite images Start [Tiffany]
    private GreenfootImage up1 = new GreenfootImage("Ninja2/Ninja Up/Ninja Up. Left Step.png");
    private GreenfootImage up2 = new GreenfootImage("Ninja2/Ninja Up/Ninja Up. Right Step.png");
    private GreenfootImage placeholder;
    private GreenfootImage down1 = new GreenfootImage("Ninja2/Ninja Down/Ninja Down. Left Step.png");
    private GreenfootImage down2 = new GreenfootImage("Ninja2/Ninja Down/Ninja Down. Right Step.png");

    private GreenfootImage left1 = new GreenfootImage("Ninja2/Ninja Left/Ninja Left. Left Step.png");
    private GreenfootImage left2 = new GreenfootImage("Ninja2/Ninja Left/Ninja Left. Right Step.png");

    private GreenfootImage right1 = new GreenfootImage("Ninja2/Ninja Right/Ninja Right. Left Step.png");
    private GreenfootImage right2 = new GreenfootImage("Ninja2/Ninja Right/Ninja Right. Right Step.png");

    private GreenfootSound ninjaDeathSound = new GreenfootSound("Pain-SoundBible.com-1883168362.mp3");
    // Ninja sprite images End [Tiffany]

    // http://soundbible.com/1898-Spin-Jump.html
    GreenfootSound sliceSound = new GreenfootSound("spin_jump-Brandino480-2020916281.mp3");
    
    GreenfootSound ninjaHitByMelee = new GreenfootSound("MinionCut1.wav");

    GreenfootSound velocitator = new GreenfootSound("Velocitator.mp3");
     //sound cred http://www.newgrounds.com/audio/listen/656737
    
    private GreenfootSound swordSound = new GreenfootSound("Blade1.mp3");
    public Ninja()
    {
    }

    public void act() 
    {
        TheHackIs();
        keyState(up1, down1, left1, right1); // Checks which movement button is pressed first
        betaMovement(speedMultiplier, up1, up2, placeholder, down1, down2, placeholder, left1, left2, placeholder, right1, right2, placeholder); // Implements movement + animation
        hitLightning(); // Implements melee attack
        shootShuriken(); // Implements ranged attack
        minionAttack();
        damageRangedMinion();
        damageRangedDashBoss();
        transparent();
        powerBarCount();
        addPower();
        addShuriken();
        addHealth();
        powerUpOne();
        powerUpTwo();
        powerUpThree();
        ninjaDied();
        cutorb();
    }    

    public void powerBarCount(){
        powerBarDelay++;
        if (powerBarDelay >= 40){
            powerBarDelay = 0;
            if (powerBar < 100){
                powerBar++;
            }
        }
    }

    // Melee Attack Start [Bill]
    public void hitLightning()
    {
        if ((Greenfoot.isKeyDown("k") && delay>100) && powerBar >= 4)
        {
            powerBar-=4;
            Lightning l1 = new Lightning(swordRotation);
            SwordSwing swordSwing = new SwordSwing(getSwordRotation()); 
            swordSound.setVolume(25); // Sean
            swordSound.play(); // Sean
            if(this.getImage()==up1||this.getImage()==up2)
            {
                getWorld().addObject(l1, getX(), getY()-20);
                l1.setRotation(getRotation() -90); 
                getWorld().addObject(swordSwing, getX(), getY() - 20);
            }
            else if(this.getImage()==down1||this.getImage()==down2)
            {
                getWorld().addObject(l1, getX(), getY()+20);
                l1.setRotation(getRotation() -90);
                getWorld().addObject(swordSwing, getX(), getY() + 20);
            }
            else if(this.getImage()==left1||this.getImage()==left2)
            {
                getWorld().addObject(l1, getX()-20, getY());
                l1.setRotation(getRotation() -90);
                getWorld().addObject(swordSwing, getX() - 20, getY());
            }
            else if(this.getImage()==right1||this.getImage()==right2)
            {
                getWorld().addObject(l1, getX()+20, getY());
                l1.setRotation(getRotation() -90);
                getWorld().addObject(swordSwing, getX() + 20, getY());
            }
            delay = 0;
        }
        delay++;
    }
    // Melee Attack End [Bill]
    // Ranged Attack Start [Sean]
    public void shootShuriken()
    {
        // Up Left
        if (Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 225;
            swordRotation = 0;
        }
        // Up Right
        else if (Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 315;
            swordRotation = 0;
        }
        // Down Left
        if (!Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 135;
            swordRotation = 0;
        }
        // Down Right
        else if (!Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 45;
            swordRotation = 0;
        }
        // Up
        else if (Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 270;
            swordRotation = 0;
        }
        // Down
        else if (!Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 90;
            swordRotation = 0;
        }
        // Left
        else if (!Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 180;
            swordRotation = 90;
        }
        // Right
        else if (!Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 360;
            swordRotation = 0;
        }
        if (Greenfoot.isKeyDown("j")  && delay> 50 && shurikennumber >0)
        {
            sliceSound.setVolume(25);
            sliceSound.play();
            Shuriken s1 = new Shuriken(getRangeDamage());
            shurikennumber--;
            //if(powerUpThree)
            //  setPower(getPower()-25);
            // Convert to cart sqrt
            // get x^2 + get y^2 = R
            // add 10 to R
            // get rotation
            if (ninjaRotation == 225)
            {
                getWorld().addObject(s1, getX() - 15, getY() - 15);
            }
            else if (ninjaRotation == 315)
            {
                getWorld().addObject(s1, getX() + 15, getY() - 15);
            }
            else if (ninjaRotation == 135)
            {
                getWorld().addObject(s1, getX() - 15, getY() + 15);
            }
            else if (ninjaRotation == 45)
            {
                getWorld().addObject(s1, getX() + 15, getY() + 15);
            }
            else if (ninjaRotation == 270)
            {
                getWorld().addObject(s1, getX(), getY() - 15);
            }
            else if (ninjaRotation == 90)
            {
                getWorld().addObject(s1, getX(), getY() + 15);
            }
            else if (ninjaRotation == 180)
            {
                getWorld().addObject(s1, getX() - 15, getY());
            }
            else if (ninjaRotation == 360)
            {
                getWorld().addObject(s1, getX() + 15, getY());
            }
            s1.setRotation(ninjaRotation);
            delay = 0;
        }
        delay++;
    }
    // Ranged Attack End [Sean]

    // "Currently under ranged minion" Melee minion AI Reaction Start [Hayden] 
    public void minionAttack()
    {
        delay1++;
        if (delay1 >= 35){
            delay1 = 0;
            NPCS actor = (NPCS) getOneIntersectingObject(MeleeMinion.class);
            if (actor != null&&!powerUpTwo)
            {
                ninjahp-= actor.getDamage();
                transparentDelay = 0;
                NinjaBlood ninjaBlood = new NinjaBlood();
                getWorld().addObject(ninjaBlood, getX(), getY());
                TempText6 temptext5 = new TempText6(this, actor.getDamage());
                getWorld().addObject(temptext5, getX(), getY()-40);
                ninjaHitByMelee.setVolume(65);
                ninjaHitByMelee.play();
            }
            if (actor != null)
            {
                MinionClaw minionClaw = new MinionClaw();
                getWorld().addObject(minionClaw, getX(), getY());
            }
        }
    }

    public void transparent() // Bill method start
    {
        if(transparentDelay<35)
        {
            getImage().setTransparency(100);
        }
        if(transparentDelay>34)
        {
            getImage().setTransparency(255);
        }
        transparentDelay++;
    } // Bill method end

    /*
    puclic static int[] worldK;
    worldK[] = new array worldK[15];
    if(int k = 0; k < 15; k++){
    if (getWorld() instanceof KworldK[k])
    {
    this.setHP(this.getArmor());
    Greenfoot.setWorld(new KworldK(this);
    }
     */

    public void ninjaDied() // Hayden method start
    {
        if (ninjahp <= 0)
        {
            ninjaDeathSound.setVolume(40);
            ninjaDeathSound.play();
            if (getWorld() instanceof K2)
            {
                this.setHP(this.getArmor());

                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new K2(this));
            }
            if (getWorld() instanceof K3)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new K3(this));
            }
            if (getWorld() instanceof K4)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new K4(this));
            }
            if (getWorld() instanceof K5)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new K5(this));
            }
            if (getWorld() instanceof K6)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new K6(this));
            }
            if (getWorld() instanceof K7)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new K7(this));
            }
            if (getWorld() instanceof K8)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new K8(this));
            }
            if (getWorld() instanceof K9)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new K9(this));
            }
            if (getWorld() instanceof K10)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new K10(this));
            }
            if (getWorld() instanceof K11)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new K11(this));
            }
            if (getWorld() instanceof K12)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new K12(this));
            }
            if (getWorld() instanceof Snow1)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new Snow1(this));
            }
            if (getWorld() instanceof Snow2)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new Snow2(this));

            }
            if (getWorld() instanceof Snow3)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new Snow3(this));
            }
            if (getWorld() instanceof Inferno1)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new Inferno1(this));
            }
            if (getWorld() instanceof Inferno2)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new Inferno2(this));
            }
            if (getWorld() instanceof Inferno3)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new Inferno3(this));
            }
            if (getWorld() instanceof Inferno4)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new Inferno4(this));
            }
            if (getWorld() instanceof InfernoBossLevel)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new InfernoBossLevel(this));
            }
            if (getWorld() instanceof T21)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new T21(this));
            }
            if (getWorld() instanceof T23)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new T23(this));
            }
            if (getWorld() instanceof T24)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new T24(this));
            }
            if (getWorld() instanceof T22)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new T22(this));
            }
            if (getWorld() instanceof T25)
            {
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new T25(this));
            }
            if (getWorld() instanceof Endless)
            {
                Trap world = (Trap) getWorld();
                
                world.stopmusic();
                
                this.setHP(this.getArmor());
                if(this.getShurikens()<=3){
                    this.setShurikens(this.getShurikens()+3);
                }
                Greenfoot.setWorld(new Kyobashi4(this));
            }
            /*
            if (getWorld() instanceof NewIntro0)
            {
            this.setHP(this.getArmor());
            Greenfoot.setWorld(new NewIntro0(this));
            }
            if (getWorld() instanceof NewIntro1)
            {
            this.setHP(this.getArmor());
            Greenfoot.setWorld(new Intro1(this));
            }
            if (getWorld() instanceof NewIntro2)
            {
            this.setHP(this.getArmor());
            Greenfoot.setWorld(new Intro2(this));
            }
            if (getWorld() instanceof NewIntro3)
            {
            this.setHP(this.getArmor());
            Greenfoot.setWorld(new Intro3(this));
            }
            if (getWorld() instanceof NewIntro4)
            {
            this.setHP(this.getArmor());
            Greenfoot.setWorld(new Intro4(this));
            }
            if (getWorld() instanceof NewIntro5)
            {
            this.setHP(this.getArmor());
            Greenfoot.setWorld(new Intro5(this));
            }
             */
        }

    } // Hayden method end

    public boolean checkDoorT21() // Bill Method start (sean made sprite)
    {
        if(getWorld().getObjects(Ninja.class).size()!=0)
        {
            Actor actor = getOneIntersectingObject(doorT21.class);
            if(actor!=null)
                return true;
            else 
                return false;
        }
        return false;
    } // Bill method end (sean made sprite)

    public boolean checkEndlessDoor() // Hayden method start (sean made animation)
    {
        if(getWorld().getObjects(Ninja.class).size()!=0)
        {
            Actor actor = getOneIntersectingObject(EndlessDoor.class);
            if(actor!=null)
                return true;
            else 
                return false;
        }
        return false;
    } // Hayden method end  (sean made animation)

    public int getMeleeDamage() // Bill
    {
        return meleeDamage;
    }

    public int getRangeDamage()  // Bill
    {
        if(powerUpThree)
            return rangeDamage*2;
        return rangeDamage;
    }

    public int getArmor()  // Bill
    {
        return armor;
    }

    public void setMeleeDamage(int a)  // Bill
    {
        meleeDamage = a;
    }

    public void setRangeDamage(int a)  // Bill
    {
        rangeDamage = a;
    }

    public void setArmor(int a)  // Bill
    {
        armor = a;
    }

    public int getSHURIKENNUMBER(){  // Bill
        return shurikennumber;
    }

    public int getNINJAHP(){  // Bill
        return ninjahp;
    }

    public int getPOWERBAR(){  // Bill
        return powerBar;
    }

    public boolean checkDoor()  // Hayden
    {
        if(getWorld().getObjects(Pictures.class).size()!=0)
        {
            Actor actor = getOneIntersectingObject(doorT10.class);
            if(actor!=null)
                return true;
            else 
                return false;
        }
        return false;
    }

    public boolean checkDoor1()// Hayden
    {
        if(getWorld().getObjects(Pictures.class).size()!=0)
        {
            Actor actor = getOneIntersectingObject(doorT11.class);
            if(actor!=null)
                return true;
            else 
                return false;
        }
        return false;
    }

    public boolean checkSnowDoor() // Tiffany
    {
        if(getWorld().getObjects(Pictures.class).size()!=0)
        {
            Actor actor = getOneIntersectingObject(SnowDoor.class);
            if(actor!=null)
                return true;
            else 
                return false;
        }
        return false;
    }

    public boolean checkInfernoDoor() // Sean
    {
        if(getWorld().getObjects(Pictures.class).size()!=0)
        {
            Actor actor = getOneIntersectingObject(InfernoDoor.class);
            if(actor!=null)
                return true;
            else
                return false;
        }
        return false;
    }

    public boolean checkInfernoDoor1() // Sean
    {
        if(getWorld().getObjects(Pictures.class).size()!=0)
        {
            Actor actor = getOneIntersectingObject(InfernoDoor1.class);
            if(actor!=null)
                return true;
            else
                return false;
        }
        return false;
    }

    public void damageRangedMinion() // Hayden
    {
        Darkness darkness = (Darkness) getOneIntersectingObject(Darkness.class);
        if(darkness!=null&&!powerUpTwo)
        {
            ninjahp-=darkness.getDamage();
            NinjaBlood ninjaBlood = new NinjaBlood();
            getWorld().addObject(ninjaBlood, getX(), getY());
            TempText6 temptext5 = new TempText6(this, darkness.getDamage());
            getWorld().addObject(temptext5, getX(), getY()-40);
        }
        Fireball fireball = (Fireball) getOneIntersectingObject(Fireball.class);
        if(fireball!=null&&!powerUpTwo)
        {
            ninjahp--;
            NinjaBlood ninjaBlood = new NinjaBlood();
            getWorld().addObject(ninjaBlood, getX(), getY());
        }
        SecondFireball secondFireball = (SecondFireball) getOneIntersectingObject(SecondFireball.class);
        if(secondFireball!=null&&!powerUpTwo)
        {
            ninjahp--;
            NinjaBlood ninjaBlood = new NinjaBlood();
            getWorld().addObject(ninjaBlood, getX(), getY());
        }
    }

    public void damageRangedDashBoss() // Hayden
    {
        DashDarkness dashdarkness = (DashDarkness) getOneIntersectingObject(DashDarkness.class);
        if(dashdarkness!=null&&!powerUpTwo)
        {
            ninjahp-=dashdarkness.getDamage();
            NinjaBlood ninjaBlood = new NinjaBlood();
            getWorld().addObject(ninjaBlood, getX(), getY());
            TempText6 temptext5 = new TempText6(this, dashdarkness.getDamage());
            getWorld().addObject(temptext5, getX(), getY()-40);
        }

    }

    // "Currently under ranged minion" Melee minion AI End [Hayden] 
    public void powerUpOne(){ // Sean
        if (progress >0&&powerBar >= 1  && (canMoveUp() || canMoveDown() || canMoveLeft() || canMoveRight())){

            if (Greenfoot.isKeyDown("u"))
            {
                if (Greenfoot.getRandomNumber(4) < 1)
                    powerBar -= 1;
                speedMultiplier = 4;
            }
            else
            {
                speedMultiplier = 2;
            }
        }
        else
        {
            speedMultiplier = 2;
        }
    }

    public void powerUpTwo()  // Hayden
    {
        if(progress>1&&powerBar>0&&(Greenfoot.isKeyDown("i")))
        {
            getImage().setTransparency(100);
            if (Greenfoot.getRandomNumber(3) < 1)
                powerBar-=1;
            powerUpTwo = true;
        }
        else 
            powerUpTwo = false;
    }

    public void powerUpThree() // Bill
    { 
        if (progress > 2 && powerBar>3 && (Greenfoot.isKeyDown("o")) && delay>140 && powerUpThree == false)
        {
            //powerUpThree = true;
            //setPower(getPower()-25);
        }

    }

    public void addShuriken() // Hayden
    { 
        Actor SP  = getOneIntersectingObject(addShuriken.class);
        if (SP != null){
            shurikennumber += 5;
            maxShurikens += 5;
            getWorld().removeObject(SP);
        }
    } 

    public int getMaxShurikens() // Sean
    {
        return maxShurikens;
    }

    public void addPower() // Hayden
    {
        Actor PP  = getOneIntersectingObject(instaPower.class);
        if (PP != null){
            if (powerBar <= 50)
            {
                powerBar += 50;
            }
            else
            {
                powerBar+= (100-powerBar);
            }

            getWorld().removeObject(PP);
        }
    }

    public boolean checkTeleport() // Bill
    {
        if(getWorld().getObjects(Ninja.class).size()!=0)
        {
            Actor actor = getOneIntersectingObject(Teleport.class);
            if(actor!=null)
                return true;
            else 
                return false;
        }
        return false;
    }

    public void addHealth() // Hayden
    {
        Actor HP  = getOneIntersectingObject(HealthGlobe.class);
        if (HP != null){
            ninjahp += 3;
            getWorld().removeObject(HP);
            if(ninjahp>armor)
                ninjahp = armor;
        }
    }

    public void setShurikens(int a) // Hayden
    {
        shurikennumber = a;
    }

    public int getShurikens() // Hayden
    {
        return shurikennumber;
    }

    public void setPoints(int a) // Bill
    {
        points = a;
    }

    public int getPoints() // Bill
    {
        return points;
    }

    public int getHP() // Hayden
    {
        return ninjahp;
    }

    public void setHP(int a) // Hayden
    {
        ninjahp = a;
    }

    public void setProgress(int a) // Bill
    {
        progress = a;
    }

    public int getProgress() // Bill
    {
        return progress;
    }

    public boolean getPower3() // Bill
    {
        return powerUpThree;
    }

    public void powerUpThreeFalse() // Bill
    {
        powerUpThree = false;
    }

    public int getPower() // Bill
    {
        return powerBar;
    }

    public void setPower(int a) // Bill
    {
        powerBar = a;
    }

    public void cutorb(){// Hayden
        Actor O = getOneIntersectingObject(Darkness.class);
        if (delay >=40 && Greenfoot.isKeyDown("k") && O!=null){
            getWorld().removeObject(O);
        }
    }

    public void TheHack(){ // Hayden
        int point = 100;
    }

    public void TheHackIs(){ // Hayden
        TheHack thehack = new TheHack();

        if (Greenfoot.isKeyDown("1")&&Greenfoot.isKeyDown("3")&&Greenfoot.isKeyDown("5")&&Greenfoot.isKeyDown("7")){
            ninjahp += 5;
            armor += 5;
            if (haungsMode == false)
            {
                CaptainHaungs captainHaungs = new CaptainHaungs();
                getWorld().addObject(captainHaungs, 824, 44);
                haungsMode = true;
            }
        }
        
        /*if (thehack.istrue() == true){
        // meleedamage += 5;
        //rangeddamage += 5;
        ninjahp += 5;
        }*/
    }

    public void addPowerUp(int prog) // Bill
    {
        progress = prog;
    }

    public int getNinjaLv(){//Hayden's Code
        return (getArmor() + getMeleeDamage() + getRangeDamage() - 11);
    }
}
