import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snow2 extends Trap
{
    Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    private List<NPCS> npcs;
    Ninja ninja;
    int delay = 11;
    public Snow2(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        prepare();
    }

    private void prepare()
    {
        SnowDoor door = new SnowDoor();
        addObject(door, 656, 415);

        addObject(healthCounter, 70, 730);

        addObject(shurikenCounter, 225, 730);
        addObject(powerCounter, 500, 730);

        addObject(levelCounter, 355, 730);
        levelCounter.setValue(1);
        addObject(ninja, 100, 100);

        npcs = getObjects(NPCS.class);
        for(int i = 0; i<npcs.size(); i++)
        {
            TempText2 text = new TempText2(npcs.get(i));
            addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
        }
        SnowFence snowfence88 = new SnowFence();
        addObject(snowfence88, 180, 78);
        SnowFence snowfence89 = new SnowFence();
        addObject(snowfence89, 31, 233);
        SnowFence snowfence90 = new SnowFence();
        addObject(snowfence90, 82, 233);
        SnowFence snowfence91 = new SnowFence();
        addObject(snowfence91, 132, 231);
        SnowFence snowfence92 = new SnowFence();
        addObject(snowfence92, 175, 229);
        SnowFence snowfence93 = new SnowFence();
        addObject(snowfence93, 182, 178);
        SnowFence snowfence94 = new SnowFence();
        addObject(snowfence94, 181, 128);
        
        SnowFence snowfence96 = new SnowFence();
        addObject(snowfence96, 229, 80);
        SnowFence snowfence97 = new SnowFence();
        addObject(snowfence97, 227, 127);
        SnowFence snowfence98 = new SnowFence();
        addObject(snowfence98, 234, 179);
        SnowFence snowfence99 = new SnowFence();
        addObject(snowfence99, 229, 231);
        
        SnowFence snowfence101 = new SnowFence();
        addObject(snowfence101, 279, 81);
        SnowFence snowfence102 = new SnowFence();
        addObject(snowfence102, 276, 126);
        SnowFence snowfence103 = new SnowFence();
        addObject(snowfence103, 278, 178);
        SnowFence snowfence104 = new SnowFence();
        addObject(snowfence104, 274, 229);
        SnowFence snowfence105 = new SnowFence();
        addObject(snowfence105, 182, 281);
        SnowFence snowfence106 = new SnowFence();
        addObject(snowfence106, 182, 331);
        SnowFence snowfence107 = new SnowFence();
        addObject(snowfence107, 179, 382);
        SnowFence snowfence108 = new SnowFence();
        addObject(snowfence108, 175, 428);

      
      
        SnowFence snowfence113 = new SnowFence();
        addObject(snowfence113, 232, 530);
        
        SnowFence snowfence115 = new SnowFence();
        addObject(snowfence115, 232, 329);
        SnowFence snowfence116 = new SnowFence();
        addObject(snowfence116, 236, 281);
        SnowFence snowfence117 = new SnowFence();
        addObject(snowfence117, 179, 581);
        SnowFence snowfence118 = new SnowFence();
        addObject(snowfence118, 228, 580);
        SnowFence snowfence119 = new SnowFence();
        addObject(snowfence119, 187, 632);
        SnowFence snowfence120 = new SnowFence();
        addObject(snowfence120, 238, 636);
        SnowFence snowfence121 = new SnowFence();
        addObject(snowfence121, 180, 679);
        SnowFence snowfence122 = new SnowFence();
        addObject(snowfence122, 226, 677);
        SnowFence snowfence123 = new SnowFence();
        addObject(snowfence123, 180, 474);
        SnowFence snowfence124 = new SnowFence();
        addObject(snowfence124, 180, 524);
        
        Ice ice = new Ice(2, 2);
        addObject(ice, 361, 230);
        Ice ice2 = new Ice(2, 2);
        addObject(ice2, 443, 105);
        Ice ice3 = new Ice(2, 2);
        addObject(ice3, 318, 600);
        Ice ice4 = new Ice(2, 2);
        addObject(ice4, 618, 526);
        Ice ice5 = new Ice(2, 2);
        addObject(ice5, 587, 186);

        SnowFence snowfence37 = new SnowFence();
        addObject(snowfence37, 31, 682);
        SnowFence snowfence38 = new SnowFence();
        addObject(snowfence38, 79, 687);
        SnowFence snowfence39 = new SnowFence();
        addObject(snowfence39, 134, 687);
        snowfence38.setLocation(79, 682);
        snowfence39.setLocation(126, 679);
        snowfence38.setLocation(78, 678);
        snowfence37.setLocation(29, 678);
        snowfence37.setLocation(28, 677);

       
        
       
        
    }

    public void act()
    {
       if (Greenfoot.isKeyDown("j")&&delay>10) 
       {
           Menu menu = new Menu(getThisWorld());
           Greenfoot.setWorld(menu);
           delay = 0;
           
       }
        if(getObjects(Ninja.class).size() != 0)
        {
        healthCounter.setValue(ninja.getNINJAHP());
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
        powerCounter.setValue(ninja.getPOWERBAR());
        checkDoor();

       }
       delay++;
    }
    public void checkDoor()
    {
        if(ninja.checkSnowDoor()==true)
            Greenfoot.setWorld(new Snow3(ninja));
    }
   public Ninja getNinja()
   {
       return ninja;
   }
   public Trap getThisWorld()
   {
       return this;
   }
      public void gameover(){
       ninja.setHP(ninja.getArmor());
       Greenfoot.setWorld(new Snow2(ninja));
    }
    
}