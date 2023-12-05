import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author Andy
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage[] walkRight = new GreenfootImage[8];
    GreenfootImage[] walkLeft = new GreenfootImage[8];
    GreenfootImage startImage = new GreenfootImage("images/tile000.png");
    SimpleTimer timer = new SimpleTimer();
    private boolean right = true;
    World world = getWorld();
    public Elephant(){
        for(int i = 0; i < walkRight.length; i++){
            walkRight[i] = new GreenfootImage("images/Elephant_walking/walk" + i + ".png");
            walkRight[i].scale(70, 70);
        }
        for(int i = 0; i < walkLeft.length; i++){
            walkLeft[i] = new GreenfootImage("images/Elephant_walking/walk" + i + ".png");
            walkLeft[i].mirrorHorizontally();
            walkLeft[i].scale(70, 70);
        }
        startImage.scale(70, 70);
        setImage(startImage);
    }
    
    private int index = 0;
    public void animateElephant(){
        if(timer.millisElapsed() < 120) return; 
        timer.mark();
        if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("d")){
            if(right){
                setImage(walkRight[index]);
                index = (index + 1) % walkRight.length;
            }
            else{
                setImage(walkLeft[index]);
                index = (index + 1) % walkLeft.length;
            }
        }
        else{
                if(right){
                    GreenfootImage image = new GreenfootImage("images/tile000.png");
                    image.scale(70, 70);
                    setImage(image);
                }
                else{
                    GreenfootImage image = new GreenfootImage("images/tile000.png");
                    image.mirrorHorizontally();
                    image.scale(70, 70);
                    setImage(image);
                }
        }
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("a")){
            move(-3);
            right = false;
        }
        if(Greenfoot.isKeyDown("d")){
            move(3);
            right = true;
        }
        
        moreApple();
        
        animateElephant();
    }
    
    public void moreApple(){
        if(world instanceof MyWorld){
            MyWorld myworld = (MyWorld) getWorld();
            if(isTouching(Apple.class)){
                removeTouching(Apple.class);
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
}
