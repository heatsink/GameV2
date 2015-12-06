import greenfoot.*;
//Duy & Tiffany 
public class StaticStoryPage extends Actor
{
    // Duy found this sprite from http://tibia.wikia.com/wiki/Sheet_of_Tracing_Paper/History
    public int pageNumber;
    private boolean createdPage = false;
    public StaticStoryPage(int pageNumber)//Tiffany
    {
        this.pageNumber = pageNumber;
    }
    public void act() //Tiffany
    {
        ninjaCollision();
    }    
    public void ninjaCollision()//Tiffany
    {
        Ninja ninja = (Ninja) getOneIntersectingObject(Ninja.class);
        Boy boy = (Boy) getOneIntersectingObject(Boy.class);
        if (ninja!=null)
        {
            changeStoryPage();
            getWorld().removeObject(this);
        }
        else if (boy!=null)
        {
            changeStoryPage();
            getWorld().removeObject(this);
        }
        
    }
    public void changeStoryPage()//Duy
    {
        if (pageNumber == 1)
        {
            ss1 s1 = new ss1();
            getWorld().addObject(s1, 781, 349);
            createdPage = true;
        }
        else if (pageNumber == 2)
        {
            ss2 s2 = new ss2();
            getWorld().addObject(s2, 781, 349);
            createdPage = true;
        }
        else if (pageNumber == 3)
        {
            createdPage = true;
        }
        else if (pageNumber == 4)
        {
            ss4 s4 = new ss4();
            getWorld().addObject(s4, 781, 349);
            createdPage = true;
        }
        else if (pageNumber == 5)
        {
            ss5 s5 = new ss5();
            getWorld().addObject(s5, 781, 349);
            createdPage = true;
        }
        else if (pageNumber == 6)
        {
            ss6 s6 = new ss6();
            getWorld().addObject(s6, 781, 349);
            createdPage = true;
        }
        else if (pageNumber == 7)
        {
            ss7 s7 = new ss7();
            getWorld().addObject(s7, 781, 349);
            createdPage = true;
        }
        else if (pageNumber == 8)
        {
            ss8 s8 = new ss8();
            getWorld().addObject(s8, 781, 349);
            createdPage = true;
        }
        else if (pageNumber == 9)
        {
            ss9 s9 = new ss9();
            getWorld().addObject(s9, 781, 349);
            createdPage = true;
        }
        else if (pageNumber == 10)
        {
            ss10 s10 = new ss10();
            getWorld().addObject(s10, 781, 349);
            createdPage = true;
        }
    }
}
