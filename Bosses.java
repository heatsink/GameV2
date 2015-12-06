// Sean's entire class
import greenfoot.*;

/**
 * Write a description of class Bosses here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bosses extends NPCS
{
    /**
     * Act - do whatever the Bosses wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int travelMagnitude = 0;
    private int speed = 2;
    private int distance;
    
    private int frame = 0;
    public void act() 
    {
        // Add your action code here.
    }    
    public void moveLeft(int distance)
    {
        this.distance = distance;
        if (distance > travelMagnitude)
        {
            setLocation(getX() - speed, getY());
            travelMagnitude+= Math.abs(speed);
        }
    }
    public void moveRight(int distance)
    {
        this.distance = distance;
        if (distance > travelMagnitude)
        {
            setLocation(getX() + speed, getY());
            travelMagnitude+= Math.abs(speed);
        }
    }
    public void moveUp(int distance)
    {
        this.distance = distance;
        if (distance > travelMagnitude)
        {
            setLocation(getX(), getY() - speed);
            travelMagnitude+= Math.abs(speed);
        }
    }
    public void moveDown(int distance)
    {
        this.distance = distance;
        if (distance > travelMagnitude)
        {
            setLocation(getX(), getY() + speed);
            travelMagnitude+= Math.abs(speed);
        }
    }
    public boolean finishedMovingHorizontally()
    {
        if (distance >= travelMagnitude)
        {
        return true;
        }
        return false;
    }
    public boolean finishedMovingVeritcally()
    {
        if (travelMagnitude >= distance)
        {
        return true;
        }
        return false;
    }
    public void animateSeven(GreenfootImage move0, GreenfootImage move1, GreenfootImage move2, GreenfootImage move3, GreenfootImage move4, GreenfootImage move5, GreenfootImage move6, GreenfootImage move7)
    {
        frame ++;
        if (frame == 1)
            {
                setImage(move0);
            }
            else if (frame == 4)
            {
                setImage(move1);
            }
            else if (frame == 8)
            {
                setImage(move2);
            }
            else if (frame == 12)
            {
                setImage(move3);
            }
            else if (frame == 16)
            {
                setImage(move4);
            }
            else if (frame == 20)
            {
                setImage(move5);
            }
            else if (frame == 24)
            {
                setImage(move6);
            }
            else if (frame == 28)
            {
                setImage(move7);
            }
            else if (frame == 32)
            {
                frame = 0;
                return;
            }
    }
    public void animateSix(GreenfootImage move0, GreenfootImage move1, GreenfootImage move2, GreenfootImage move3, GreenfootImage move4, GreenfootImage move5)
    {
        frame ++;
        if (frame == 1)
            {
                setImage(move0);
            }
            else if (frame == 4)
            {
                setImage(move1);
            }
            else if (frame == 8)
            {
                setImage(move2);
            }
            else if (frame == 12)
            {
                setImage(move3);
            }
            else if (frame == 16)
            {
                setImage(move4);
            }
            else if (frame == 20)
            {
                setImage(move5);
            }
            else if (frame == 24)
            {
                frame = 0;
                return;
            }
    }
}
