import greenfoot.*;
/**
 * Functionality in this class:
 */
public class BoyBot extends Animated
{
    private double time = 0;
    // Sprites Drawn by [Edward, Sean's roommate]
    // Sprite Implementation Start [Sean] 
    /*
    private GreenfootImage up1 = new GreenfootImage("Ninja/Ninja Up/ninja_sprites_up_stance_left_step2.png");
    private GreenfootImage up2 = new GreenfootImage("Ninja/Ninja Up/ninja_sprites_up_stance_right_step2.png");
    
    private GreenfootImage down1 = new GreenfootImage("Ninja/Ninja Down/ninja_sprites_down_stance_left_step2.png");
    private GreenfootImage down2 = new GreenfootImage("Ninja/Ninja Down/ninja_sprites_down_stance_right_step2.png");
    
    private GreenfootImage left1 = new GreenfootImage("Ninja/Ninja Left/ninja_sprites_left_stance_left_step2.png");
    private GreenfootImage left2 = new GreenfootImage("Ninja/Ninja Left/ninja_sprites_left_stance2.png");
    
    private GreenfootImage right1 = new GreenfootImage("Ninja/Ninja Right/ninja_sprites_right_stance_left_step2.png");
    private GreenfootImage right2 = new GreenfootImage("Ninja/Ninja Right/ninja_sprites_right_stance2.png");
    */
    
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
    private GreenfootImage right3 = new GreenfootImage("Boy/BoyRight3.png");
    
    
    // Sprite Implementation End [Sean] 
    private double frame = 1;
    public BoyBot()
    {
    }

    // Heroes Move
    public void act()
    {
        time += 0.01602;
        if (time >= 4.5 && time <= 5.5){
            moveUp(up1, up2);
        }
        if (time >= 5.5 && time <= 11.25){
            moveRight(right1, right2);
        }
        if (time >= 11.25 && time <= 11.35)
        {
            moveLeft(left1, left2);
        }
        if (time >= 22 && time <= 50)
        {
            moveRight(right1, right2);
        }
    }
    // Movement + Animation Start [Sean]
    public void moveUp(GreenfootImage up1, GreenfootImage up2)
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
            frame = 1;
            return;
        }
        frame+=0.25;
    }
    public void moveDown(GreenfootImage down1, GreenfootImage down2)
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
            frame = 1;
            return;
        }
        frame+=0.25;
    }
    public void moveLeft(GreenfootImage left1, GreenfootImage left2)
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
                frame = 1;
                return;
            }
            frame+=0.25;
    }
    public void moveRight(GreenfootImage right1, GreenfootImage right2)
    {
            setLocation(getX() + 1, getY());
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
                frame = 1;
                return;
            }
            frame+=0.25;
    }
    // Movement + Animation End [Sean]
}
