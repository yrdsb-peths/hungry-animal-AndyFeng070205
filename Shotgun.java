import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Shotgun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shotgun extends Power
{
    /**
     * Act - do whatever the Shotgun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Shotgun(){
        super("Shotgun", 15);
    }
    
    public void act()
    {
        // Add your action code here.
        MyWorld myworld = (MyWorld) getWorld();
        setLocation(getX(), getY() + 3);
    }
}
