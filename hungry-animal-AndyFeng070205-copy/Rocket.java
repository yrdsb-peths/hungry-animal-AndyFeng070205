import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean canFire = true;
    public void act()
    {
        // Add your action code here.
        MyWorld myworld = (MyWorld) getWorld();
        if(Greenfoot.isKeyDown("a")) move(-4);
        if(Greenfoot.isKeyDown("d")) move(4);
        
        shoot();
        
        if(isTouching(Ufo.class)){
            myworld.takeDamage();
            removeTouching(Ufo.class);
            if(myworld.life == 0){
                myworld.gameOver();
            }
        }
        else if(isTouching(Alien.class)){
            myworld.takeDamage();
            removeTouching(Alien.class);
            if(myworld.life == 0){
                myworld.gameOver();
            }
        }
    }
    
    public void shoot(){
        if(Greenfoot.isKeyDown("j") && canFire == true){
            getWorld().addObject(new Bullet(), getX(), getY() - 45);
            canFire = false;
        }
        else if(!Greenfoot.isKeyDown("j")) canFire = true;
    }
}
