import greenfoot.*;
/**
 * Functionality in this class:
 */
public class IntroButton extends Actor
{
    // Image made by bill on paint.net
    private int type;
    private int delay = 21;
    public IntroButton(int type)
    {
        this.type = type;
    }
    public void act() 
    {
        IntroMenu menu = (IntroMenu) getWorld();
        Boy boy = menu.getTrap().getBoy();
        if(delay>20&&Greenfoot.mouseClicked(this)&&type==1&&boy.getPoints()>4)
        {
            delay = 0;
            boy.setMeleeDamage(boy.getMeleeDamage()+1);
            boy.setPoints(boy.getPoints()-5);
        }
        if(delay>20&&Greenfoot.mouseClicked(this)&&type==2&&boy.getPoints()>4)
        {
            delay = 0;
            boy.setRangeDamage(boy.getRangeDamage()+1);
            boy.setPoints(boy.getPoints()-5);
        }
        if(delay>20&&Greenfoot.mouseClicked(this)&&type==3&&boy.getPoints()>4)
        {
            delay = 0;
            boy.setArmor(boy.getArmor()+1);
            boy.setHP(boy.getHP()+1);
            if(boy.getHP()>boy.getArmor())
                boy.setHP(boy.getArmor());
            boy.setPoints(boy.getPoints()-5);
        }
        delay++;
    }    
}