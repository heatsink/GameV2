import greenfoot.*;
import java.util.*;

/**
 * Functionality in this class:
 */
public class BlueRM extends RangedMinion  //RM Stands for Ranged Minion
{
    int delay = 0;
    private int imageTimer;
    
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
    
    public BlueRM(int RMHP, int damage)
    {
        super(RMHP, damage);
    }
    public void act() 
    {
        /*
        moveUp(up1, up2, up3);
        moveDown(down1, down2, down3);
        moveLeft(left1, left2, left3);
        moveRight(right1, right2, right3);
        */
       detect();
       ninjaattack();
       RMDied();
       switchImage();
    }    
    public void detect()
    {
        List<Ninja> list = getObjectsInRange(5000, Ninja.class);
        if (list.size()>0&&delay>100)
        {
            turnTowards(list.get(0).getX(), list.get(0).getY());
            double x = getRotation();
            Darkness darkness = new Darkness(this.getDamage());
            getWorld().addObject(darkness, getX(), getY());
            darkness.turnTowards(list.get(0).getX(), list.get(0).getY());
            delay = 0;
            setRotation(0);
        }
        List<Boy> list2 = getObjectsInRange(5000, Boy.class);
        if (list2.size()>0&&delay>100)
        {
            turnTowards(list2.get(0).getX(), list2.get(0).getY());
            double x = getRotation();
            Darkness darkness2 = new Darkness(this.getDamage());
            getWorld().addObject(darkness2, getX(), getY());
            darkness2.turnTowards(list2.get(0).getX(), list2.get(0).getY());
            delay = 0;
            setRotation(0);
        }
        delay++;       
    }
    private void switchImage() 
    {
        int span = 25; // cycles between image changes
        int imgCt = 3; // total number of images
        imageTimer++; // increment timer
        if (imageTimer == span) setImage("Images/Melee/range1.png");
        if (imageTimer == 2*span) setImage("Images/Melee/range2.png");
        if (imageTimer == 3*span) setImage("Images/Melee/range3.png");
        if (imageTimer == 4*span) imageTimer=0;
    }
}