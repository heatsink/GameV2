// Sean's class except for lines 278-362 and its corresponding variables
import greenfoot.*;
/**
 * Functionality in this class:
 * Hero movement (Includes key state)
 * General Animation
 * Fence hit detection
 */
public class Heroes extends SmoothMover
{
    private double frame = 1; // Used for animation
    private int moveState = 0; // Used for movement, Up/Down/Left/Right
    private int keysPressed = 0; // Used to tally number of movement keys pressed
    private int up = 0; // Up key pressed in the number of movement keys pressed
    private int down = 0; // Down key pressed in the number of movement keys pressed
    private int left = 0; // Left key pressed in the number of movement keys pressed
    private int right = 0; // Right key pressed in the number of movement keys pressed
    public int swordRotation;
    private boolean powerUpTwo = false;
    public int powerBar = 100;
    public int powerBarDelay = 0;
    
   public void act()
   {
    //powerUpTwo();
    powerBarCount();
    }
    
    // Checks which key is pressed first for movement Start [Sean]
    public void keyState(GreenfootImage up1, GreenfootImage down1, GreenfootImage left1, GreenfootImage right1)
    {
        
        keysPressed = up + down + left + right;
        if (keysPressed == 0)
        {
            if (Greenfoot.isKeyDown("w"))
            {
                setRotation(0);
                setImage(up1);
                moveState = 1;
                up = 1;
            }
            else if (Greenfoot.isKeyDown("s"))
            {
                setRotation(180);
                setImage(down1);
                moveState = 2;
                down = 1;
            }
            else if (Greenfoot.isKeyDown("a"))
            {
                setRotation(-90);
                setImage(left1);
                moveState = 3;
                left = 1;
            }
            else if (Greenfoot.isKeyDown("d"))
            {
                setRotation(90);
                setImage(right1);
                moveState = 4;
                right = 1;
            }
        }
        if(!(Greenfoot.isKeyDown("w")))
        {
            up = 0;
        }
        if(!(Greenfoot.isKeyDown("s")))
        {
            down = 0;
        }
        if(!(Greenfoot.isKeyDown("a")))
        {
            left = 0;
        }
        if(!(Greenfoot.isKeyDown("d")))
        {
            right = 0;
        }
        if(!(Greenfoot.isKeyDown("w")) && !(Greenfoot.isKeyDown("s")) && !(Greenfoot.isKeyDown("a")) && !(Greenfoot.isKeyDown("d")))
        {
            moveState = 0;
        }
    }
    // Checks which key is pressed first for movement End [Sean]
    // Ninja movement implementing animation Start [Sean] + Debugged [Bill]
    public void betaMovement(int speedMultiplier, GreenfootImage up1, GreenfootImage up2, GreenfootImage up3, GreenfootImage down1, GreenfootImage down2, GreenfootImage down3, GreenfootImage left1, GreenfootImage left2, GreenfootImage left3, GreenfootImage right1, GreenfootImage right2, GreenfootImage right3)
    {
        // Main up
        if (moveState == 1)
        {
            swordRotation = -65;
            animateUp(up1, up2, up3);
            if (Greenfoot.isKeyDown("a") && canMoveLeft() && canMoveUp())
            {
                setLocation(getX() - 1*speedMultiplier, getY() - 1*speedMultiplier);
            }
            else if (Greenfoot.isKeyDown("d") && canMoveRight() && canMoveUp())
            {
                setLocation(getX() + 1*speedMultiplier, getY() - 1*speedMultiplier);
            }
            else if (Greenfoot.isKeyDown("d") && canMoveRight())
            {
                setLocation(getX() + 1*speedMultiplier, getY());
            }
            else if (Greenfoot.isKeyDown("a") && canMoveLeft())
            {
                setLocation(getX() - 1*speedMultiplier, getY());
            }
            else if(canMoveUp())
            {
                setLocation(getX(), getY() - 1*speedMultiplier);
            }
        }
        // Main down
        else if (moveState == 2)
        {   
            swordRotation = 90;
            animateDown(down1, down2, down3);
            if (Greenfoot.isKeyDown("a") && canMoveLeft() && canMoveDown())
            {
                setLocation(getX() - 1*speedMultiplier, getY() + 1*speedMultiplier);
            }
            else if (Greenfoot.isKeyDown("d") && canMoveRight() && canMoveDown())
            {
                setLocation(getX() + 1*speedMultiplier, getY() + 1*speedMultiplier);
            }
            else if (Greenfoot.isKeyDown("a") && canMoveLeft())
            {
                setLocation(getX() - 1*speedMultiplier, getY());
            }
            else if (Greenfoot.isKeyDown("d") && canMoveRight())
            {
                setLocation(getX() + 1*speedMultiplier, getY());
            }
            else if (canMoveDown())
            {
                setLocation(getX(), getY() + 1*speedMultiplier);
            }
        }
        // Main left
        else if (moveState == 3)
        {
            swordRotation = 180;
            animateLeft(left1, left2, left3);
            if (Greenfoot.isKeyDown("w") && canMoveUp() && canMoveLeft())
            {
                setLocation(getX() - 1*speedMultiplier, getY() - 1*speedMultiplier);
            }
            else if (Greenfoot.isKeyDown("s") && canMoveDown() && canMoveLeft())
            {
                setLocation(getX() - 1*speedMultiplier, getY() + 1*speedMultiplier);
            }
            else if (Greenfoot.isKeyDown("w") && canMoveUp())
            {
                setLocation(getX(), getY() - 1*speedMultiplier);
            }
            else if (Greenfoot.isKeyDown("s") && canMoveDown())
            {
                setLocation(getX(), getY() + 1*speedMultiplier);
            }
            else if (canMoveLeft())
            {
                setLocation(getX() - 1*speedMultiplier, getY());
            }
        }
        // Main right
        else if (moveState == 4)
        {   
            swordRotation = 0;
            animateRight(right1, right2, right3);
            if (Greenfoot.isKeyDown("w") && canMoveUp() && canMoveRight())
            {
                setLocation(getX() + 1*speedMultiplier, getY() - 1*speedMultiplier);
            }
            else if (Greenfoot.isKeyDown("s") && canMoveDown() && canMoveRight())
            {
                setLocation(getX() + 1*speedMultiplier, getY() + 1*speedMultiplier);
            }
            else if (Greenfoot.isKeyDown("w") && canMoveUp())
            {
                setLocation(getX(), getY() - 1*speedMultiplier);
            }
            else if (Greenfoot.isKeyDown("s") && canMoveDown())
            {
                setLocation(getX(), getY() + 1*speedMultiplier);
            }
            else if (canMoveRight())
            {
                setLocation(getX() + 1*speedMultiplier, getY());
            }
        }
    }
    // Ninja movement implementing animation End [Sean] + Debugged [Bill]
    // Animation System Start [Sean]
    public void animateUp(GreenfootImage up1, GreenfootImage up2, GreenfootImage up3)
    {
        if (frame == 1)
            {
                setRotation(0);
                setImage(up1);
            }
            else if (frame == 3)
            {
                setRotation(0);
                setImage(up2);
            }
            else if (frame == 5)
            {
                frame = 1;
                return;
            }
            frame+=.25;
    }
    
    public void animateDown(GreenfootImage down1, GreenfootImage down2, GreenfootImage down3)
    {
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
            frame+=.25;
    }
    
    public void animateLeft(GreenfootImage left1, GreenfootImage left2, GreenfootImage left3)
    {
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
            frame+=.25;
    }
    
    public void animateRight(GreenfootImage right1, GreenfootImage right2, GreenfootImage right3)
    {
        if (frame == 1)
            {
                setImage(right1);
                setRotation(90);
            }
            else if (frame == 3)
            {
                setImage(right2);
                setRotation(90);
            }
            else if (frame ==5)
            {
                frame = 1;
                return;
            }
            frame+=.25;
    }
    // Animation System End [Sean]
    
    public void powerBarCount(){
        powerBarDelay++;
        if (powerBarDelay >= 60){
            powerBarDelay = 0;
            if (powerBar < 100){
                powerBar++;
            }
        }
    }
    
     /*public void powerUpTwo(){
            if(powerBar>0&&(Greenfoot.isKeyDown("'") || Greenfoot.isKeyDown("r")))
            {
                getImage().setTransparency(100);
                powerBar-=1;
                powerUpTwo = true;
            }
            else
                powerUpTwo = false;
    
            }*/
    // Hit Detection System Start [Bill]
    public boolean canMoveRight()
    {
        boolean good = true;
        for(int i = -20; i<21; i++)
        {
            if(getOneObjectAtOffset(25,i,Obstacles.class)!=null)
                good = false;
        }
        
        if(powerUpTwo== true)
        {
            good= true;
        }
        return good;
    }
    
    public boolean canMoveLeft()
    {
        boolean good = true;
        for(int i = -20; i<21; i++)
        {
            if(getOneObjectAtOffset(-25,i,Obstacles.class)!=null)
                good = false;
        }
        
          if(powerUpTwo== true)
        {
            good= true;
        }
        return good;
    }
  
    public boolean canMoveUp()
    {
        boolean good = true;
        for(int i = -20; i<21; i++)
        {
            if(getOneObjectAtOffset(i,-25,Obstacles.class)!=null)
                good = false;
        }
        
          if(powerUpTwo== true)
        {
            good= true;
        }
        return good;
    }
    
    public boolean canMoveDown()
    {
        boolean good = true;
        for(int i = -20; i<21; i++)
        {
            if(getOneObjectAtOffset(i,25,Obstacles.class)!=null)
                good = false;
        }
        
          if(powerUpTwo== true)
        {
            good= true;
        }
        return good;
    }
    public int getSwordRotation()
    {
        return swordRotation;
    }
    // Hit Detection System End [Bill]
}