import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snow1 extends Trap
{
    Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    private List<NPCS> npcs;
    Ninja ninja;
    int delay = 11;
    public Snow1(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        prepare();
    }

    private void prepare()
    {
        SnowDoor door = new SnowDoor();
        addObject(door, 653, 534);

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
        addObject(snowfence, 33, 32);
        snowfence.setLocation(25, 25);
        SnowFence snowfence2 = new SnowFence();
        addObject(snowfence2, 83, 31);
        snowfence2.setLocation(75, 27);
        SnowFence snowfence3 = new SnowFence();
        addObject(snowfence3, 129, 28);
        SnowFence snowfence4 = new SnowFence();
        addObject(snowfence4, 179, 29);
        SnowFence snowfence5 = new SnowFence();
        addObject(snowfence5, 227, 26);
        SnowFence snowfence6 = new SnowFence();
        addObject(snowfence6, 281, 25);
        SnowFence snowfence7 = new SnowFence();
        addObject(snowfence7, 327, 25);
        SnowFence snowfence8 = new SnowFence();
        addObject(snowfence8, 376, 23);
        SnowFence snowfence9 = new SnowFence();
        addObject(snowfence9, 426, 27);
        SnowFence snowfence10 = new SnowFence();
        addObject(snowfence10, 474, 24);
        SnowFence snowfence11 = new SnowFence();
        addObject(snowfence11, 521, 26);
        SnowFence snowfence12 = new SnowFence();
        addObject(snowfence12, 577, 30);
        SnowFence snowfence13 = new SnowFence();
        addObject(snowfence13, 675, 27);
        SnowFence snowfence14 = new SnowFence();
        addObject(snowfence14, 675, 27);
        snowfence3.setLocation(130, 30);
        snowfence6.setLocation(280, 26);
        snowfence7.setLocation(330, 25);
        snowfence8.setLocation(386, 25);
        snowfence9.setLocation(429, 27);
        snowfence8.setLocation(384, 25);
        snowfence12.setLocation(572, 24);
        SnowFence snowfence15 = new SnowFence();
        addObject(snowfence15, 629, 30);
        InfernoFence infernofence = new InfernoFence();
        addObject(infernofence, 33, 85);
        InfernoFence infernofence2 = new InfernoFence();
        addObject(infernofence2, 32, 140);
        InfernoFence infernofence3 = new InfernoFence();
        addObject(infernofence3, 27, 181);
        InfernoFence infernofence4 = new InfernoFence();
        addObject(infernofence4, 30, 239);
        removeObject(infernofence);
        removeObject(infernofence2);
        removeObject(infernofence3);
        removeObject(infernofence4);
        SnowFence snowfence16 = new SnowFence();
        addObject(snowfence16, 31, 81);
        SnowFence snowfence17 = new SnowFence();
        addObject(snowfence17, 30, 128);
        SnowFence snowfence18 = new SnowFence();
        addObject(snowfence18, 30, 178);
        SnowFence snowfence19 = new SnowFence();
        addObject(snowfence19, 29, 230);
        SnowFence snowfence20 = new SnowFence();
        addObject(snowfence20, 29, 277);
        SnowFence snowfence21 = new SnowFence();
        addObject(snowfence21, 28, 327);
        SnowFence snowfence22 = new SnowFence();
        addObject(snowfence22, 31, 376);
        SnowFence snowfence23 = new SnowFence();
        addObject(snowfence23, 27, 428);
        SnowFence snowfence24 = new SnowFence();
        addObject(snowfence24, 28, 473);
        SnowFence snowfence25 = new SnowFence();
        addObject(snowfence25, 29, 525);
        SnowFence snowfence26 = new SnowFence();
        addObject(snowfence26, 682, 78);
        snowfence14.setLocation(690, 126);
        snowfence26.setLocation(685, 75);
        snowfence13.setLocation(683, 23);
        snowfence15.setLocation(627, 24);
        snowfence14.setLocation(675, 127);
        SnowFence snowfence27 = new SnowFence();
        addObject(snowfence27, 730, 30);
        snowfence26.setLocation(722, 74);
        snowfence27.setLocation(726, 23);
        snowfence26.setLocation(723, 72);
        snowfence14.setLocation(719, 124);
        SnowFence snowfence28 = new SnowFence();
        addObject(snowfence28, 728, 181);
        snowfence14.setLocation(721, 122);
        snowfence28.setLocation(725, 174);
        SnowFence snowfence29 = new SnowFence();
        addObject(snowfence29, 728, 231);
        SnowFence snowfence30 = new SnowFence();
        addObject(snowfence30, 727, 282);
        SnowFence snowfence31 = new SnowFence();
        addObject(snowfence31, 731, 330);
        SnowFence snowfence32 = new SnowFence();
        addObject(snowfence32, 731, 382);
        SnowFence snowfence33 = new SnowFence();
        addObject(snowfence33, 729, 433);
        SnowFence snowfence34 = new SnowFence();
        addObject(snowfence34, 729, 481);
        SnowFence snowfence35 = new SnowFence();
        addObject(snowfence35, 728, 531);
        SnowFence snowfence36 = new SnowFence();
        addObject(snowfence36, 732, 580);
        SnowFence snowfence37 = new SnowFence();
        addObject(snowfence37, 36, 582);
        SnowFence snowfence38 = new SnowFence();
        addObject(snowfence38, 734, 628);
        SnowFence snowfence39 = new SnowFence();
        addObject(snowfence39, 730, 677);
        SnowFence snowfence40 = new SnowFence();
        addObject(snowfence40, 732, 729);
        SnowFence snowfence41 = new SnowFence();
        addObject(snowfence41, 28, 633);
        SnowFence snowfence42 = new SnowFence();
        addObject(snowfence42, 31, 677);
        SnowFence snowfence43 = new SnowFence();
        addObject(snowfence43, 81, 680);
        SnowFence snowfence44 = new SnowFence();
        addObject(snowfence44, 129, 681);
        SnowFence snowfence45 = new SnowFence();
        addObject(snowfence45, 180, 685);
        SnowFence snowfence46 = new SnowFence();
        addObject(snowfence46, 232, 686);
        SnowFence snowfence47 = new SnowFence();
        addObject(snowfence47, 278, 683);
        SnowFence snowfence48 = new SnowFence();
        addObject(snowfence48, 327, 680);
        SnowFence snowfence49 = new SnowFence();
        addObject(snowfence49, 378, 681);
        SnowFence snowfence50 = new SnowFence();
        addObject(snowfence50, 429, 680);
        SnowFence snowfence51 = new SnowFence();
        addObject(snowfence51, 473, 681);
        SnowFence snowfence52 = new SnowFence();
        addObject(snowfence52, 523, 680);
        SnowFence snowfence53 = new SnowFence();
        addObject(snowfence53, 575, 681);
        SnowFence snowfence54 = new SnowFence();
        addObject(snowfence54, 620, 681);
        SnowFence snowfence55 = new SnowFence();
        addObject(snowfence55, 670, 683);
        SnowFence snowfence56 = new SnowFence();
        addObject(snowfence56, 681, 728);
        SnowFence snowfence57 = new SnowFence();
        addObject(snowfence57, 729, 730);
        SnowFence snowfence58 = new SnowFence();
        addObject(snowfence58, 82, 32);
        SnowFence snowfence59 = new SnowFence();
        addObject(snowfence59, 33, 31);
        SnowFence snowfence60 = new SnowFence();
        addObject(snowfence60, 182, 75);
        
        SnowFence snowfence62 = new SnowFence();
        addObject(snowfence62, 180, 179);
        SnowFence snowfence63 = new SnowFence();
        addObject(snowfence63, 180, 227);
        SnowFence snowfence64 = new SnowFence();
        addObject(snowfence64, 180, 280);
        SnowFence snowfence65 = new SnowFence();
        addObject(snowfence65, 181, 329);
        SnowFence snowfence66 = new SnowFence();
        addObject(snowfence66, 79, 533);
        SnowFence snowfence67 = new SnowFence();
        addObject(snowfence67, 132, 538);
        SnowFence snowfence68 = new SnowFence();
        addObject(snowfence68, 182, 542);
        SnowFence snowfence69 = new SnowFence();
        addObject(snowfence69, 232, 533);
        SnowFence snowfence70 = new SnowFence();
        addObject(snowfence70, 281, 537);
        SnowFence snowfence71 = new SnowFence();
        addObject(snowfence71, 332, 533);
        SnowFence snowfence72 = new SnowFence();
        addObject(snowfence72, 231, 336);
        SnowFence snowfence73 = new SnowFence();
        addObject(snowfence73, 285, 334);
        SnowFence snowfence74 = new SnowFence();
        addObject(snowfence74, 332, 332);
        SnowFence snowfence75 = new SnowFence();
        addObject(snowfence75, 387, 332);
        SnowFence snowfence76 = new SnowFence();
        addObject(snowfence76, 379, 379);
        SnowFence snowfence77 = new SnowFence();
        addObject(snowfence77, 383, 424);
        SnowFence snowfence78 = new SnowFence();
        addObject(snowfence78, 379, 485);
        SnowFence snowfence79 = new SnowFence();
        addObject(snowfence79, 377, 524);
        SnowFence snowfence80 = new SnowFence();
        addObject(snowfence80, 379, 576);
        SnowFence snowfence81 = new SnowFence();
        addObject(snowfence81, 383, 627);
        SnowFence snowfence82 = new SnowFence();
        addObject(snowfence82, 382, 78);
        SnowFence snowfence83 = new SnowFence();
        addObject(snowfence83, 378, 126);
        SnowFence snowfence84 = new SnowFence();
        addObject(snowfence84, 378, 176);
        SnowFence snowfence85 = new SnowFence();
        addObject(snowfence85, 383, 232);
        SnowFence snowfence86 = new SnowFence();
        addObject(snowfence86, 383, 283);
        snowfence79.setLocation(377, 532);
        snowfence82.setLocation(415, 103);
        snowfence83.setLocation(429, 129);
        snowfence84.setLocation(417, 175);
        snowfence85.setLocation(451, 149);
        snowfence86.setLocation(426, 227);
        snowfence80.setLocation(459, 568);
        snowfence81.setLocation(480, 577);
        removeObject(snowfence82);
        removeObject(snowfence83);
        removeObject(snowfence85);
        removeObject(snowfence84);
        removeObject(snowfence86);
        removeObject(snowfence81);
        removeObject(snowfence80);
        snowfence55.setLocation(623, 571);
        removeObject(snowfence55);
        snowfence56.setLocation(675, 678);
        snowfence57.setLocation(671, 729);
        removeObject(snowfence57);
        snowfence40.setLocation(712, 728);
        removeObject(snowfence40);
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
            Greenfoot.setWorld(new Snow2(ninja));
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
       Greenfoot.setWorld(new Snow1(ninja));
    }
}