import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Poison here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Poison extends Actor
{
    /**
     * Act - do whatever the Poison wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int speed = 2;
    
    public void act()
    {
        // Add your action code here.
        setLocation(getX(), getY() + speed);
        if(isAtEdge()){
            MyWorld myworld = (MyWorld) getWorld();
            myworld.removeObject(this);
        }
    }
    
    public void setSpeed(int a){
        speed = a;
    }
}
