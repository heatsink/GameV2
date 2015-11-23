import greenfoot.*;

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
    public int page;
    public StoryPage(int p)
    {
        page=p;
    }
    public void act() 
    {
        untouchable();
        if (noRemainingMonsters()==true)
        {
            System.out.println("here");
            Ninja ninja = (Ninja) getOneIntersectingObject(Ninja.class);
            if (ninja!=null)
            {
                showStory();
            }
        }    
    }
    public boolean noRemainingMonsters()
    {
        if (getWorld().getObjects(NPCS.class).size() == 0)
        {
            return true;
        }
        return false;
    }
    public void showStory()
    {
        if (page==1)
        {
          story1 story=new story1();
          getWorld().addObject(story, 375, 375);
        }
    }
    
    private void untouchable()
    {
        getImage().setTransparency(50);
        if (noRemainingMonsters()==true)
        {
            getImage().setTransparency(255);
        }
    }
}
