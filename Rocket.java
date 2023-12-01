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
    public boolean canFire = true;
    private boolean shotgunOn = false;
    private boolean lazerOn = false;
    private double xC = 0;
    private double yC = 0;
    private int rounds = 12;
    private int time = 900;
    
    public void act()
    {
        // Add your action code here.
        
        xC = getX();
        yC = getY();
        
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
        
        upgrade();
    }
    
    public void shoot(){
        if(shotgunOn == false && lazerOn == false){
            if(Greenfoot.isKeyDown("j") && canFire == true){
                Bullet bullet = new Bullet();
                bullet.turn(-90);
                getWorld().addObject(bullet, getX(), getY() - 45);
                canFire = false;
            }
            else if(!Greenfoot.isKeyDown("j")) canFire = true;
        }
        if(shotgunOn == true){
            if(Greenfoot.isKeyDown("j") && canFire == true && rounds != 0){
                Bullet bullet = new Bullet();
                bullet.turn(-90);
                getWorld().addObject(bullet, getX(), getY() - 45);
                Bullet bullet1 = new Bullet();
                bullet1.turn(-75);
                getWorld().addObject(bullet1, getX(), getY() - 45);
                Bullet bullet2 = new Bullet();
                bullet2.turn(-105);
                getWorld().addObject(bullet2, getX(), getY() - 45);
                rounds--;
                canFire = false;
            }
            else if(!Greenfoot.isKeyDown("j")){
                canFire = true;
            }
            else if(rounds == 0){
                shotgunOn = false;
                rounds = 12;
            }
        }
        if(lazerOn == true){
            time--;
            if(time <= 0){
                lazerOn = false;
                time = 900;
            }
            if(Greenfoot.isKeyDown("j") && canFire == true){
                Bullet bullet = new Bullet();
                bullet.turn(-90);
                getWorld().addObject(bullet, getX(), getY() - 45);
            }
            else if(!Greenfoot.isKeyDown("j")){
                canFire = true;
            }
        }
    }
    
    public void upgrade(){
        if(isTouching(Shotgun.class)){
            removeTouching(Shotgun.class);
            shotgunOn = true;
        }
        if(isTouching(Lazer.class)){
            removeTouching(Lazer.class);
            lazerOn = true;
        }
    }
    
    public double getxC(){
        return xC;
    }
    
    public double getyC(){
        return yC;
    }
}
