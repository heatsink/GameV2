import greenfoot.*;

/**
 * Write a description of class BillBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BillBoss extends NPCS
{
    int delay = 0;
    public BillBoss(int RMHP, int damage)
    {
        super(RMHP, damage);
    }
    public void act() 
    {
        if(delay<60)
        {
            getImage().setTransparency(250);
            move(5);
            setRotation(0);
            delay++;
        }
        if(delay>=60&&delay<120)
        {
            getImage().setTransparency(100);
            setRotation(90);
            move(5);
            setRotation(0);
            delay++;
        }
        if(delay>=120&&delay<180)
        {
            getImage().setTransparency(250);
            setRotation(180);
            move(5);
            setRotation(0);
            delay++;
        }
        if(delay>=180&&delay<240)
        {
            getImage().setTransparency(100);
            setRotation(270);
            move(5);
            setRotation(0);
            delay++;
        }
        if(delay>=240)
        delay = 0;
    }    
}
