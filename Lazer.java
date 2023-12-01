import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lazer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lazer extends Power
{
    /**
     * Act - do whatever the Lazer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Lazer(){
        super("Lazer", 12);
    }
    
    public void act()
    {
        // Add your action code here.
        MyWorld myworld = (MyWorld) getWorld();
        setLocation(getX(), getY() + 3);
    }
}
