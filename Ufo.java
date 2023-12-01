import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ufo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ufo extends Actor
{
    /**
     * Act - do whatever the Ufo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int hitNum = 2;
    public void act()
    {
        // Add your action code here.
        setLocation(getX(), getY() + 3);
        
        MyWorld myworld = (MyWorld) getWorld();
        
        if(isAtEdge()){
            myworld.removeObject(this);
            return;
        }
        
        hitByBullet();
    }
    
    public void hitByBullet(){
        Actor bullet = getOneIntersectingObject(Bullet.class);
        MyWorld myworld = (MyWorld) getWorld();
        if(bullet != null){
            myworld.removeObject(bullet);
            hitNum--;
        }
        if(hitNum == 0){
            myworld.increaseScore();
            myworld.increaseScore();
            myworld.removeObject(this);
            return;
        }
    }
    
}
