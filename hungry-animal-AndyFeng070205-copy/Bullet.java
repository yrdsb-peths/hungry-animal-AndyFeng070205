import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int hitNum = 0;
    public void act()
    {
        setRotation(-90);
        move(5);
        
        MyWorld myworld = (MyWorld) getWorld();
        
        if (isAtEdge()) {
            myworld.removeObject(this);
            return; 
        }

        if(isTouching(Alien.class)){
            removeTouching(Alien.class);
            myworld.increaseScore();
            myworld.removeObject(this);
            return;
        }
    }
}
