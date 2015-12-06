import greenfoot.*;
//Duy
/**
 * Write a description of class StoryPage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StoryPage extends Actor
{
    /**
     * Act - do whatever the StoryPage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //http://tibia.wikia.com/wiki/Sheet_of_Tracing_Paper/History
    public int page;
    public StoryPage(int p)//Duy
    {
        page=p;
    }
    public void act() //Duy
    {
        untouchable();
        if (noRemainingMonsters()==true)
        {
            Ninja ninja = (Ninja) getOneIntersectingObject(Ninja.class);
            if (ninja!=null)
            {
                showStory();
                getWorld().removeObject(this);
            }
        }    
    }
    public boolean noRemainingMonsters()//Duy
    {
        if (getWorld().getObjects(NPCS.class).size() == 0)
        {
            return true;
        }
        return false;
    }
    public void showStory()//Duy
    {
        if (page==1)
        {
          s1 story=new s1();
          getWorld().addObject(story, 375, 375);
        }
        if (page==2)
        {
          s2 story=new s2();
          getWorld().addObject(story, 375, 375);
        }if (page==3)
        {
          s3 story=new s3();
          getWorld().addObject(story, 375, 375);
        }if (page==4)
        {
          s4 story=new s4();
          getWorld().addObject(story, 375, 375);
        }if (page==5)
        {
          s5 story=new s5();
          getWorld().addObject(story, 375, 375);
        }if (page==6)
        {
          s6 story=new s6();
          getWorld().addObject(story, 375, 375);
        }if (page==7)
        {
          s7 story=new s7();
          getWorld().addObject(story, 375, 375);
        }if (page==8)
        {
          s8 story=new s8();
          getWorld().addObject(story, 375, 375);
        }if (page==9)
        {
          s9 story=new s9();
          getWorld().addObject(story, 375, 375);
        }if (page==10)
        {
          s10 story=new s10();
          getWorld().addObject(story, 375, 375);
        }if (page==11)
        {
          s11 story=new s11();
          getWorld().addObject(story, 375, 375);
        }if (page==12)
        {
          s12 story=new s12();
          getWorld().addObject(story, 375, 375);
        }
    }   
    private void untouchable()//Duy
    {
        getImage().setTransparency(50);
        if (noRemainingMonsters()==true)
        {
            getImage().setTransparency(255);
        }
    }
}
