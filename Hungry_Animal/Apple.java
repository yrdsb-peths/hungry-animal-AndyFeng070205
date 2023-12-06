import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Apple here.
 * 
 * @author Andy
 * @version (a version number or a date)
 */
public class Apple extends Actor
{
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
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
            myworld.damage();
            if(myworld.life > 0){
                myworld.createApple();
            }
            else{
                endScreen goodGame = new endScreen();
                Greenfoot.setWorld(goodGame);
            }
        }
    }
    public void increaseDiff(int a){
        speed = a;
    }
}
