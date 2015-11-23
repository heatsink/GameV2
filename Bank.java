import greenfoot.*;

/**
 * Write a description of class Bank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bank extends World
{
    private Ninja ninja;
    /**
     * Constructor for objects of class Bank.
     * 
     */
    public Bank()
    {    
        super(750, 750, 1);
        ninja = new Ninja();
    }
    public void act()
    {
        if(true)
        {
            Kyobashi kyo = new Kyobashi(ninja);
            Greenfoot.setWorld(kyo);
        }
    }
    public Ninja getNinja()
    {
        return ninja;
    }
}
