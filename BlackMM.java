// Sean's entire class
import greenfoot.*;
import java.util.*;

/**
 * Functionality in this class:
 */
public class BlackMM extends MeleeMinion  //RM Stands for Ranged Minion
{
    // Will find the source of the sprite soon...
    private GreenfootImage up1 = new GreenfootImage("BlackDragon/BlackDragon Up/BlackDragon_Up_Left.png");
    private GreenfootImage up2 = new GreenfootImage("BlackDragon/BlackDragon Up/BlackDragon_Up_Right.png");
    private GreenfootImage up3 = new GreenfootImage("BlackDragon/BlackDragon Up/BlackDragon_Up_Center.png");
    
    private GreenfootImage down1 = new GreenfootImage("BlackDragon/BlackDragon Down/BlackDragon_Down_Left.png");
    private GreenfootImage down2 = new GreenfootImage("BlackDragon/BlackDragon Down/BlackDragon_Down_Center.png");
    private GreenfootImage down3 = new GreenfootImage("BlackDragon/BlackDragon Down/BlackDragon_Down_Right.png");
    
    private GreenfootImage left1 = new GreenfootImage("BlackDragon/BlackDragon Left/BlackDragon_Left_Left.png");
    private GreenfootImage left2 = new GreenfootImage("BlackDragon/BlackDragon Left/BlackDragon_Left_Center.png");
    private GreenfootImage left3 = new GreenfootImage("BlackDragon/BlackDragon Left/BlackDragon_Left_Right.png");
    
    private GreenfootImage right1 = new GreenfootImage("BlackDragon/BlackDragon Right/BlackDragon_Right_Left.png");
    private GreenfootImage right2 = new GreenfootImage("BlackDragon/BlackDragon Right/BlackDragon_Right_Center.png");
    private GreenfootImage right3 = new GreenfootImage("BlackDragon/BlackDragon Right/BlackDragon_Right_Right.png");
    
    public BlackMM(int RMHP, int damage)
    {
        super(RMHP, damage);
    }
    public void act() 
    {
        //moveUp(up1, up2, up3);
        //moveDown(down1, down2, down3);
        //moveLeft(left1, left2, left3);
        //moveRight(right1, right2, right3);
        detect();
                ninjaattack();
        RMDied();
    }    
        public void detect()
    {
        List<Ninja> list = getObjectsInRange(200, Ninja.class);
        if (list.size()>0)
        {
            turnTowards(list.get(0).getX(), list.get(0).getY());
            moveRight(right1, right2, right3);
            moveLeft(left1, left2, left3);
            moveUp(up1, up2, up3);
            moveDown(down1, down2, down3);
            move(8);
            if(getOneIntersectingObject(Fence.class)!=null)
                move(-8);
            else
                move(-7);
            setRotation(0);
        }
               
    }
}
