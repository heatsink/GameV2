import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snow3 extends Trap
{
    Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    private List<NPCS> npcs;
    Ninja ninja;
    int delay = 11;
    public Snow3(Ninja ninja)
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

        SnowFence snowfence = new SnowFence();
        addObject(snowfence, 35, 31);
        SnowFence snowfence2 = new SnowFence();
        addObject(snowfence2, 80, 34);
        SnowFence snowfence3 = new SnowFence();
        addObject(snowfence3, 127, 31);
        SnowFence snowfence4 = new SnowFence();
        addObject(snowfence4, 177, 32);
        SnowFence snowfence5 = new SnowFence();
        addObject(snowfence5, 227, 27);
        SnowFence snowfence6 = new SnowFence();
        addObject(snowfence6, 281, 31);
        SnowFence snowfence7 = new SnowFence();
        addObject(snowfence7, 326, 27);
        SnowFence snowfence8 = new SnowFence();
        addObject(snowfence8, 378, 25);
        SnowFence snowfence9 = new SnowFence();
        addObject(snowfence9, 425, 20);
        SnowFence snowfence10 = new SnowFence();
        addObject(snowfence10, 475, 23);
        SnowFence snowfence11 = new SnowFence();
        addObject(snowfence11, 525, 27);
        SnowFence snowfence12 = new SnowFence();
        addObject(snowfence12, 577, 28);
        SnowFence snowfence13 = new SnowFence();
        addObject(snowfence13, 627, 28);
        SnowFence snowfence14 = new SnowFence();
        addObject(snowfence14, 682, 27);
        SnowFence snowfence15 = new SnowFence();
        addObject(snowfence15, 30, 74);
        SnowFence snowfence16 = new SnowFence();
        addObject(snowfence16, 26, 122);
        SnowFence snowfence17 = new SnowFence();
        addObject(snowfence17, 28, 191);
        SnowFence snowfence18 = new SnowFence();
        addObject(snowfence18, 27, 222);
        snowfence17.setLocation(28, 176);
        SnowFence snowfence19 = new SnowFence();
        addObject(snowfence19, 31, 278);
        SnowFence snowfence20 = new SnowFence();
        addObject(snowfence20, 26, 325);
        SnowFence snowfence21 = new SnowFence();
        addObject(snowfence21, 25, 372);
        SnowFence snowfence22 = new SnowFence();
        addObject(snowfence22, 23, 428);
        SnowFence snowfence23 = new SnowFence();
        addObject(snowfence23, 28, 479);
        SnowFence snowfence24 = new SnowFence();
        addObject(snowfence24, 20, 527);
        SnowFence snowfence25 = new SnowFence();
        addObject(snowfence25, 25, 578);
        SnowFence snowfence26 = new SnowFence();
        addObject(snowfence26, 24, 630);
        SnowFence snowfence27 = new SnowFence();
        addObject(snowfence27, 28, 676);
        SnowFence snowfence28 = new SnowFence();
        addObject(snowfence28, 83, 677);
        SnowFence snowfence29 = new SnowFence();
        addObject(snowfence29, 125, 677);
        SnowFence snowfence30 = new SnowFence();
        addObject(snowfence30, 179, 675);
        SnowFence snowfence31 = new SnowFence();
        addObject(snowfence31, 222, 678);
        SnowFence snowfence32 = new SnowFence();
        addObject(snowfence32, 275, 674);
        snowfence31.setLocation(224, 675);
        SnowFence snowfence33 = new SnowFence();
        addObject(snowfence33, 330, 673);
        SnowFence snowfence34 = new SnowFence();
        addObject(snowfence34, 381, 675);
        SnowFence snowfence35 = new SnowFence();
        addObject(snowfence35, 430, 675);
        SnowFence snowfence36 = new SnowFence();
        addObject(snowfence36, 478, 675);
        SnowFence snowfence37 = new SnowFence();
        addObject(snowfence37, 528, 675);
        SnowFence snowfence38 = new SnowFence();
        addObject(snowfence38, 580, 677);
        SnowFence snowfence39 = new SnowFence();
        addObject(snowfence39, 628, 680);
        SnowFence snowfence40 = new SnowFence();
        addObject(snowfence40, 682, 676);
        SnowFence snowfence41 = new SnowFence();
        addObject(snowfence41, 729, 679);
        SnowFence snowfence42 = new SnowFence();
        addObject(snowfence42, 725, 623);
        SnowFence snowfence43 = new SnowFence();
        addObject(snowfence43, 727, 573);
        SnowFence snowfence44 = new SnowFence();
        addObject(snowfence44, 728, 526);
        SnowFence snowfence45 = new SnowFence();
        addObject(snowfence45, 724, 474);
        SnowFence snowfence46 = new SnowFence();
        addObject(snowfence46, 727, 421);
        SnowFence snowfence47 = new SnowFence();
        addObject(snowfence47, 731, 375);
        SnowFence snowfence48 = new SnowFence();
        addObject(snowfence48, 730, 324);
        SnowFence snowfence49 = new SnowFence();
        addObject(snowfence49, 731, 277);
        
        SnowFence snowfence51 = new SnowFence();
        addObject(snowfence51, 725, 173);
        SnowFence snowfence52 = new SnowFence();
        addObject(snowfence52, 725, 127);
        SnowFence snowfence53 = new SnowFence();
        addObject(snowfence53, 732, 75);
        SnowFence snowfence54 = new SnowFence();
        addObject(snowfence54, 734, 34);
        
        SnowFence snowfence56 = new SnowFence();
        addObject(snowfence56, 233, 127);
        SnowFence snowfence57 = new SnowFence();
        addObject(snowfence57, 230, 175);
        SnowFence snowfence58 = new SnowFence();
        addObject(snowfence58, 231, 232);
        SnowFence snowfence59 = new SnowFence();
        addObject(snowfence59, 228, 281);
        SnowFence snowfence60 = new SnowFence();
        addObject(snowfence60, 229, 329);
        SnowFence snowfence61 = new SnowFence();
        addObject(snowfence61, 226, 378);
        SnowFence snowfence62 = new SnowFence();
        addObject(snowfence62, 227, 426);
        SnowFence snowfence63 = new SnowFence();
        addObject(snowfence63, 225, 475);
        SnowFence snowfence64 = new SnowFence();
        addObject(snowfence64, 229, 528);
        SnowFence snowfence65 = new SnowFence();
        addObject(snowfence65, 229, 577);
        SnowFence snowfence66 = new SnowFence();
        addObject(snowfence66, 226, 626);
        SnowFence snowfence67 = new SnowFence();
        addObject(snowfence67, 284, 128);
        SnowFence snowfence68 = new SnowFence();
        addObject(snowfence68, 330, 130);
        SnowFence snowfence69 = new SnowFence();
        addObject(snowfence69, 381, 129);
        SnowFence snowfence70 = new SnowFence();
        addObject(snowfence70, 379, 225);
        SnowFence snowfence71 = new SnowFence();
        addObject(snowfence71, 482, 277);
        SnowFence snowfence72 = new SnowFence();
        addObject(snowfence72, 379, 431);
        SnowFence snowfence73 = new SnowFence();
        addObject(snowfence73, 530, 179);
        SnowFence snowfence74 = new SnowFence();
        addObject(snowfence74, 433, 433);
        SnowFence snowfence75 = new SnowFence();
        addObject(snowfence75, 481, 430);
        snowfence74.setLocation(428, 430);
        SnowFence snowfence76 = new SnowFence();
        addObject(snowfence76, 285, 632);
        SnowFence snowfence77 = new SnowFence();
        addObject(snowfence77, 282, 582);
        snowfence76.setLocation(283, 632);
        removeObject(snowfence77);
        removeObject(snowfence76);
        SnowFence snowfence78 = new SnowFence();
        addObject(snowfence78, 79, 327);
        SnowFence snowfence79 = new SnowFence();
        addObject(snowfence79, 131, 331);
        SnowFence snowfence80 = new SnowFence();
        addObject(snowfence80, 181, 328);
        snowfence62.setLocation(82, 474);
        snowfence61.setLocation(136, 476);
        snowfence63.setLocation(184, 473);
        snowfence64.setLocation(226, 474);
        snowfence65.setLocation(408, 546);
        snowfence66.setLocation(338, 529);
        snowfence65.setLocation(545, 560);
        snowfence66.setLocation(275, 557);
        snowfence73.setLocation(553, 129);
        snowfence71.setLocation(482, 274);
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
            Greenfoot.setWorld(new Kyobashi2(ninja));
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
       Greenfoot.setWorld(new Snow3(ninja));
    }
}