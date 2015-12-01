import greenfoot.*;
/**
 * Functionality in this class:
 */
public class DragonBot extends Animated
{
    private double time = 0;
    // Sprite Implementation Start [Sean] + Background Fix for Hit Detection [Bill]
    private GreenfootImage up1 = new GreenfootImage("BlueDragon/BlueDragon Up/Dragon_Up_Left2.png");
    private GreenfootImage up2 = new GreenfootImage("BlueDragon/BlueDragon Up/Dragon_Up_Center2.png");
    private GreenfootImage up3 = new GreenfootImage("BlueDragon/BlueDragon Up/Dragon_Up_Right2.png");
    
    private GreenfootImage down1 = new GreenfootImage("BlueDragon/BlueDragon Down/Dragon_Down_Left2.png");
    private GreenfootImage down2 = new GreenfootImage("BlueDragon/BlueDragon Down/Dragon_Down_Center2.png");
    private GreenfootImage down3 = new GreenfootImage("BlueDragon/BlueDragon Down/Dragon_Down_Right2.png");
    
    private GreenfootImage left1 = new GreenfootImage("BlueDragon/BlueDragon Left/Dragon_Left_Left2.png");
    private GreenfootImage left2 = new GreenfootImage("BlueDragon/BlueDragon Left/Dragon_Left_Center2.png");
    private GreenfootImage left3 = new GreenfootImage("BlueDragon/BlueDragon Left/Dragon_Left_Right2.png");
    
    private GreenfootImage right1 = new GreenfootImage("BlueDragon/BlueDragon Right/Dragon_Right_Left2.png");
    private GreenfootImage right2 = new GreenfootImage("BlueDragon/BlueDragon Right/Dragon_Right_Center2.png");
    private GreenfootImage right3 = new GreenfootImage("BlueDragon/BlueDragon Right/Dragon_Right_Right2.png");
    // Sprite Implementation End [Sean] + Background Fix for Hit Detection [Bill]
    
    // sounds from //http://soundbible.com/
    
    private GreenfootSound dragonDeath = new GreenfootSound("Tyrannosaurus Rex-SoundBible.com-2136096676.mp3");
    
    private double xMovement = -50;
    private double frame = 1;
    public DragonBot()
    {
        
    }

    // Heroes Move
    public void act()
    {
        xMovement += 0.5;
        moveRight(right1, right2, right3);
        if (getX() > 175 && getX() < 295)
        {
            if (Greenfoot.getRandomNumber(1000) < 25)
            {
                PurpleBlood ninjaBlood = new PurpleBlood();
                ninjaBlood.changeColor();
                getWorld().addObject(ninjaBlood, getX(), getY());
            }
        }
        if (getX() >= 300)
        {
            ArmPool armPool = new ArmPool(false);
            getWorld().addObject(armPool, getX(), getY());
            dragonDeath.setVolume(25);
            dragonDeath.play();
            getWorld().removeObject(this);
        }
        
    }

    // Dragon Movement + Animation Start [Sean]
    public void moveUp(GreenfootImage up1, GreenfootImage up2, GreenfootImage up3)
    {
        setLocation(getX(), getY() - 1);
        //Put rotation within if statements instead of here for smoother animation
        if (frame == 1)
        {
            setImage(up1);
            setRotation(0);
        }
        else if (frame == 3)
        {
            setImage(up2);
            setRotation(0);
        }
        else if (frame == 5)
        {
            setRotation(0);
            setImage(up3);
        }
        else if (frame == 7)
         {
            frame = 1;
            return;
        }
        frame+=0.25;
    }
    public void moveDown(GreenfootImage down1, GreenfootImage down2, GreenfootImage down3)
    {
        setLocation(getX(), getY() + 1);
        //Put rotation within if statements instead of here for smoother animation
        if (frame == 1)
        {
            setRotation(180);
            setImage(down1);
        }
        else if (frame == 3)
        {
            setRotation(180);
            setImage(down2);
        }
        else if (frame == 5)
        {
            setRotation(180);
            setImage(down3);
        }
        else if (frame == 7)
         {
            frame = 1;
            return;
        }
        frame+=0.25;
    }
    public void moveLeft(GreenfootImage left1, GreenfootImage left2, GreenfootImage left3)
    {
        setLocation(getX() - 1, getY());
        //Put rotation within if statements instead of here for smoother animation
        if (frame == 1)
        {
            setRotation(-90);
            setImage(left1);
        }
        else if (frame == 3)
        {
            setRotation(-90);
            setImage(left2);
        }
        else if (frame == 5)
        {
            setRotation(-90);
            setImage(left3);
        }
        else if (frame == 7)
        {
            frame = 1;
            return;
        }
        frame+=0.25;
    }
    public void moveRight(GreenfootImage right1, GreenfootImage right2, GreenfootImage right3)
    {
        setLocation((int)xMovement, getY());
        //setLocation(getX() + 1, getY());
        //Put rotation within if statements instead of here for smoother animation
        if (frame == 1)
        {
            setRotation(90);
            setImage(right1);
        }
        else if (frame == 3)
        {
            setRotation(90);
            setImage(right2);
        }
        else if (frame == 5)
        {
            setRotation(90);
            setImage(right3);
        }
        else if (frame == 7)
         {
            frame = 1;
            return;
        }
        frame+=0.25;
    }
    // Dragon Movement + Animation End [Sean]
}
