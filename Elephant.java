import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("a")) move(-4);
        if(Greenfoot.isKeyDown("d")) move(4);
        
        moreApple();
    }
    
    public void moreApple(){
        if(isTouching(Apple.class)){
            removeTouching(Apple.class);
            MyWorld myworld = (MyWorld) getWorld();
            myworld.increaseScore();
            if(myworld.score == 20){
                myworld.gameOver2();
            }
            else{
                myworld.createApple();
            }
        }
    }
}
