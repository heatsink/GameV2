import greenfoot.*;
/**
 * Functionality in this class:
 * Ninja Melee
 * Ninja Ranged
 * Relationship to Melee AI "CURRENTLY CALLED RANGED AI"
 */

public class Boy extends Heroes
{
   private int progress = 0;
   private boolean powerUpTwo = false;
    boolean powerUpThree;
    private boolean transparent = false;
   private int transparentDelay = 36;
    
    static int speedMultiplier = 2;
    private int delay = 21;
    // Start Hayden Variables
    public int powerBar = 100;
    public int powerBarDelay = 0;
    
    public int shurikennumber = 8;
    public int maxShurikens = 8;
    
    private int delay1 = 71;
    private int ninjahp = 5;
    
    private int points = 5;
    private int meleeDamage = 1;
    private int rangeDamage = 1;
    private int armor = 5;
    // End Hayden Variables
    
    private int ninjaRotation = 0;
    private int swordRotation = 0;
    // Ninja sprite images Start [Tiffany]
    private GreenfootImage up1 = new GreenfootImage("Boy/BoyUp1.png");
    private GreenfootImage up2 = new GreenfootImage("Boy/BoyUp2.png");
    private GreenfootImage up3 = new GreenfootImage("Boy/BoyUp3.png");
    
    private GreenfootImage down1 = new GreenfootImage("Boy/BoyDown1.png");
    private GreenfootImage down2 = new GreenfootImage("Boy/BoyDown2.png");
    private GreenfootImage down3 = new GreenfootImage("Boy/BoyDown3.png");
    
    private GreenfootImage left1 = new GreenfootImage("Boy/BoyLeft1.png");
    private GreenfootImage left2 = new GreenfootImage("Boy/BoyLeft2.png");
    private GreenfootImage left3 = new GreenfootImage("Boy/BoyLeft3.png");
    
    private GreenfootImage right1 = new GreenfootImage("Boy/BoyRight1.png");
    private GreenfootImage right2 = new GreenfootImage("Boy/BoyRight2.png");
    private GreenfootImage right3 = new GreenfootImage("Boy/BoyRight3.png");// Ninja sprite images End [Tiffany]
    
    private boolean canUseSword = false;
    private boolean canUseShuriken = false;
    private boolean canUseInvisibility = false;
    private boolean canUseDash = false;
    private boolean canUseDoubleDamage = false;
    
    private GreenfootSound swordSound = new GreenfootSound("Blade1.wav");
    public Boy()
    {
        swordSound.setVolume(20);
    }
    public void act() 
    {
        TheHackIs();
        keyState(up1, down1, left1, right1); // Checks which movement button is pressed first
        betaMovement(speedMultiplier, up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3); // Implements movement + animation
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
        cutorb();
        checkDashSpellbook();
        checkShurikenRack();
        checkWeaponRack();
    }    
    public void powerBarCount(){
        powerBarDelay++;
        if (powerBarDelay >= 60){
            powerBarDelay = 0;
            if (powerBar < 100){
                powerBar++;
            }
        }
    }
    
    // Melee Attack Start [Bill]
    public void hitLightning()
    {
        if ((Greenfoot.isKeyDown("k") && delay>120)&& canUseSword == true)
        {
            Lightning l1 = new Lightning(swordRotation);
            if(powerUpThree)
            setPower(getPower()-25);
            SwordSwing swordSwing = new SwordSwing(getSwordRotation());
            swordSound.play();
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
        if (Greenfoot.isKeyDown("j")  && delay> 50 && shurikennumber >0 && canUseShuriken == true)
        {
            Shuriken s1 = new Shuriken(getRangeDamage());
            shurikennumber--;
            if(powerUpThree)
                setPower(getPower()-25);
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
           }
           if (actor != null)
           {
               MinionClaw minionClaw = new MinionClaw();
               getWorld().addObject(minionClaw, getX(), getY());
           }
        }
    }
    public void transparent()
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
    }
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
    
   
    
    public boolean checkDoorT21()
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
    }
  
   public int getMeleeDamage()
    {
        return meleeDamage;
    }
    
    public int getRangeDamage()
    {
        if(powerUpThree)
        return rangeDamage*2;
        return rangeDamage;
    }
    
    public int getArmor()
    {
        return armor;
    }
    
    public void setMeleeDamage(int a)
    {
        meleeDamage = a;
    }
    
    public void setRangeDamage(int a)
    {
        rangeDamage = a;
    }
    
    public void setArmor(int a)
    {
        armor = a;
    }
    public int getMaxShurikens()
    {
        return maxShurikens;
    }
    public int getSHURIKENNUMBER(){
        return shurikennumber;
    }
    public int getNINJAHP(){
        return ninjahp;
    }
        public int getPOWERBAR(){
        return powerBar;
    }
    public boolean checkDoor()
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
    public boolean checkDoor1()
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
       public boolean checkSnowDoor()
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
    public boolean checkInfernoDoor()
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
    public void damageRangedMinion()
    {
        BoyDarkness darkness = (BoyDarkness) getOneIntersectingObject(BoyDarkness.class);
        if(darkness!=null&&!powerUpTwo)
        {
            ninjahp-=darkness.getDamage();
            NinjaBlood ninjaBlood = new NinjaBlood();
            getWorld().addObject(ninjaBlood, getX(), getY());
        }
        Fireball fireball = (Fireball) getOneIntersectingObject(Fireball.class);
        if(fireball!=null&&!powerUpTwo)
        {
            ninjahp--;
            NinjaBlood ninjaBlood = new NinjaBlood();
            getWorld().addObject(ninjaBlood, getX(), getY());
        }
    }
        public void damageRangedDashBoss()
    {
        DashDarkness dashdarkness = (DashDarkness) getOneIntersectingObject(DashDarkness.class);
        if(dashdarkness!=null&&!powerUpTwo)
        {
            ninjahp-=dashdarkness.getDamage();
            NinjaBlood ninjaBlood = new NinjaBlood();
            getWorld().addObject(ninjaBlood, getX(), getY());
        }

    }
    
    // "Currently under ranged minion" Melee minion AI End [Hayden] 
       public void powerUpOne(){
        if (powerBar >= 1  && (canMoveUp() || canMoveDown() || canMoveLeft() || canMoveRight()) && canUseDash == true){
            
            if (Greenfoot.isKeyDown("u"))
            {
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
       public void powerUpTwo(){
            if(powerBar>0&&(Greenfoot.isKeyDown("'") || Greenfoot.isKeyDown("r")) && canUseInvisibility == true)
            {
                getImage().setTransparency(100);
                powerBar-=1;
                powerUpTwo = true;
            }
            else
                powerUpTwo = false;
                
    }
    
        public void powerUpThree(){
        if (powerBar>24&&(Greenfoot.isKeyDown("l")) &&  canUseDoubleDamage  == true){
            powerUpThree = true;
        }
        else
            powerUpThree = false;
        }
        public void addShuriken(){
        Actor SP  = getOneIntersectingObject(addShuriken.class);
        if (SP != null){
            shurikennumber += 3;
            maxShurikens += 3;
            getWorld().removeObject(SP);
        }
    } 
            public void addPower(){
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
    public boolean checkTeleport()
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
    public void addHealth(){
        Actor HP  = getOneIntersectingObject(HealthGlobe.class);
        if (HP != null){
            ninjahp += 3;
            getWorld().removeObject(HP);
            if(ninjahp>armor)
                ninjahp = armor;
        }
    }
    public void setPoints(int a)
    {
        points = a;
    }
    public int getPoints()
    {
        return points;
    }
    public int getHP()
    {
        return ninjahp;
    }
    public void setHP(int a)
    {
        ninjahp = a;
    }
    public void setProgress(int a)
    {
        progress = a;
    }
    public int getProgress(int a)
    {
        return progress;
    }
    public boolean getPower3()
    {
        return powerUpThree;
    }
    public int getPower()
    {
        return powerBar;
    }
    public void setPower(int a)
    {
        powerBar = a;
    }
    public void cutorb(){
        Actor O = getOneIntersectingObject(Darkness.class);
        if (delay >=40 && Greenfoot.isKeyDown("k") && O!=null){
            getWorld().removeObject(O);
        }
    }
    public void checkDashSpellbook()
    {
        Actor dashSpellbook = getOneIntersectingObject(Spellbook.class);
          if (dashSpellbook != null)
          {
              canUseDash = true;
              getWorld().removeObject(dashSpellbook);
          }
    }
    public void checkShurikenRack()
    {
          Actor introWeaponRack = getOneIntersectingObject(IntroShurikenWeaponRack.class);
          if (introWeaponRack != null)
          {
              canUseShuriken = true;
              getWorld().removeObject(introWeaponRack);
          }
    }
    public void checkWeaponRack()
    {
        Actor weaponRack = getOneIntersectingObject(IntroWeaponRack.class);
        if (weaponRack != null)
        {
            canUseSword = true;
            getWorld().removeObject(weaponRack);
        }
    }
    public void TheHack(){
        int point = 100;
    }
    public void TheHackIs(){
        TheHack thehack = new TheHack();
        
        if (Greenfoot.isKeyDown("1")&&Greenfoot.isKeyDown("3")&&Greenfoot.isKeyDown("5")&&Greenfoot.isKeyDown("7")){
            ninjahp += 5;
        }
        /*if (thehack.istrue() == true){
             // meleedamage += 5;
             //rangeddamage += 5;
             ninjahp += 5;
        }*/
   }
   public boolean getSwordStatus()
   {
       return canUseSword;
    }
    public boolean getShurikenStatus()
    {
        return canUseShuriken;
    }
    public boolean getDashStatus()
    {
        return canUseDash;
    }
}
