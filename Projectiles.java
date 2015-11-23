import greenfoot.*;  
public class Projectiles extends SmoothMover 
{             
        // Test if we are close to one of the edges of the world. Return true is we are
        public boolean atWorldEdge()     
        {         
            if(getX() < 20 || getX() > getWorld().getWidth() - 20)             
                return true;         
            if(getY() < 20 || getY() > getWorld().getHeight() - 20)             
                return true;         
            else             
            return false;    
        }
}