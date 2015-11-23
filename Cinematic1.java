import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Cinamatic1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cinematic1 extends Trap
{
    Ninja ninja;
    public int timec1 = 50;
    private List<Flash> flash;
    private List<EndStory0> endstory0;
    private List<InfernoBoss1> infernoboss1;
    /**
     * Constructor for objects of class Cinamatic1.
     * 
     */
    public Cinematic1(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        prepare();
        
    }
    public void act(){
        timec1++;
        flash();
        Texts();
        ByeBoss();
        choose();
        intromaster();
        checkDoor();
        checkDoor1();
    }
    public void prepareHUD()
    {
        }
   public void prepare(){
               for(int i = 0; i<15; i++)
            for(int j = 0; j<2; j++)
            {
            InfernoFence fence = new InfernoFence();
            addObject(fence, 25+j*(700+250), 50*i+25);
            }
        for(int i = 1;i<24; i++)
            for(int j = 0; j<2; j++)
            {
                InfernoFence fence = new InfernoFence();
                addObject(fence, 50*i+25, 25+j*(700-25));
            }
            addObject(ninja, 100, 375);
            InfernoBoss1 ifb1 = new InfernoBoss1();
            addObject(ifb1, 620, 375);
            
            
            
            
    }
    public void flash(){
        if (timec1 <= 401 && timec1 >= 400){
            Flash flash = new Flash();
            addObject(flash, 375, 375);
        }
        if (timec1 > 405){
            flash = getObjects(Flash.class);
            if(flash.size()>0)
            removeObject(flash.get(0));
        }
        
    }
    public void ByeBoss(){
        
        if (timec1 > 405)
        {
            infernoboss1 = getObjects(InfernoBoss1.class);
            if(infernoboss1.size()>0)
            removeObject(infernoboss1.get(0));
        }
    }
    public void Texts(){
        if (timec1 >= 200 && timec1 <= 201){
            EndStory0 endstory0 = new EndStory0();
            addObject(endstory0, 620, 200);
        }
        if (timec1 > 405 && timec1 < 407)
        {
            endstory0 = getObjects(EndStory0.class);
            if(endstory0.size()>0)
            removeObject(endstory0.get(0));
        }
    }
    public int getTIMEC1(){
        return timec1;
    }
    public void intromaster(){
        if (timec1 > 405 && timec1 < 407)
        {
            OldManBot4 omb4= new OldManBot4();
            addObject(omb4, 580, 375);
            EndStoryKyo1 esk1 = new EndStoryKyo1();
            addObject(esk1, 620, 200);
        }
    }
    public void choose(){
        if (timec1 > 410 && timec1 < 420){
            InfernoDoor door = new InfernoDoor();
            addObject(door, 90, 375);
        }
        if (timec1 == 410){
            ninja.setLocation(375,375);
            EndStoryKyo2 esk2=new EndStoryKyo2();
            addObject(esk2, ninja.getX(), ninja.getY()-150);
        }
    }
    public void checkDoor()
    {
        if(ninja.checkInfernoDoor()==true)
            Greenfoot.setWorld(new Cinematic2(ninja));
    }
    public void checkDoor1()
    {
        if(ninja.checkInfernoDoor1()==true)
            Greenfoot.setWorld(new Cinematic3(ninja));
    }
       public Ninja getNinja()
    {
       return ninja;
    }
    public Trap getThisWorld()
    {
       return this;
    }
}
