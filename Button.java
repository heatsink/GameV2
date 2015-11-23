import greenfoot.*;
/**
 * Functionality in this class:
 */
public class Button extends Actor
{
    // Image made by bill on paint.net
    private int type;
    private int delay = 21;
    public Button(int type)
    {
        this.type = type;
    }
    public void act() 
    {
        Menu menu = (Menu) getWorld();
        Ninja ninja = menu.getTrap().getNinja();
        if(delay>20&&Greenfoot.mouseClicked(this)&&type==1&&ninja.getPoints()>4)
        {
            delay = 0;
            ninja.setMeleeDamage(ninja.getMeleeDamage()+1);
            ninja.setPoints(ninja.getPoints()-5);
        }
        if(delay>20&&Greenfoot.mouseClicked(this)&&type==2&&ninja.getPoints()>4)
        {
            delay = 0;
            ninja.setRangeDamage(ninja.getRangeDamage()+1);
            ninja.setPoints(ninja.getPoints()-5);
        }
        if(delay>20&&Greenfoot.mouseClicked(this)&&type==3&&ninja.getPoints()>4)
        {
            delay = 0;
            ninja.setArmor(ninja.getArmor()+1);
            ninja.setHP(ninja.getHP()+1);
            if(ninja.getHP()>ninja.getArmor())
                ninja.setHP(ninja.getArmor());
            ninja.setPoints(ninja.getPoints()-5);
        }
        delay++;
    }    
}