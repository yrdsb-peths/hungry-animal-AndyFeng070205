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
    
    GreenfootSound sound = new GreenfootSound("images/elephant.mp3");
    GreenfootSound jump = new GreenfootSound("images/jump.mp3");
    GreenfootImage[] walkRight = new GreenfootImage[8];
    GreenfootImage[] walkLeft = new GreenfootImage[8];
    GreenfootImage startImage = new GreenfootImage("images/tile000.png");
    GreenfootImage startJump = new GreenfootImage("images/Elephant_dance/jump0.png");
    GreenfootImage[] jumpRight = new GreenfootImage[9];
    GreenfootImage[] jumpLeft = new GreenfootImage[9];
    SimpleTimer timer = new SimpleTimer();
    private boolean right = true;
    private int speed = 3;
    public Elephant(){
        World world = getWorld();
        for(int i = 0; i < walkRight.length; i++){
            walkRight[i] = new GreenfootImage("images/Elephant_walking/walk" + i + ".png");
            walkRight[i].scale(70, 70);
        }
        for(int i = 0; i < walkLeft.length; i++){
            walkLeft[i] = new GreenfootImage("images/Elephant_walking/walk" + i + ".png");
            walkLeft[i].mirrorHorizontally();
            walkLeft[i].scale(70, 70);
        }
        for(int i = 0; i < jumpRight.length; i++){
            jumpRight[i] = new GreenfootImage("images/Elephant_dance/jump" + i + ".png");
            jumpRight[i].scale(70, 70);
        }
        for(int i = 0; i < jumpLeft.length; i++){
            jumpLeft[i] = new GreenfootImage("images/Elephant_dance/jump" + i + ".png");
            jumpLeft[i].mirrorHorizontally();
            jumpLeft[i].scale(70, 70);
        }
        if(world instanceof MyWorld){
            setImage(startImage);
            startImage.scale(70, 70);
        }
        if(world instanceof titleWorld){
            setImage(startJump);
            startJump.scale(80, 80);
        }
    }
    
    private int index1 = 0;
    private int index2 = 0;
    private int index3 = 0;
    public void animateElephant(){
        World world = getWorld();
        if(timer.millisElapsed() < 100) return; 
        timer.mark();
        if(world instanceof MyWorld){
            if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("d")){
                if(right){
                    setImage(walkRight[index2]);
                    index2 = (index2 + 1) % walkRight.length;
                }
                else{
                    setImage(walkLeft[index2]);
                    index2 = (index2 + 1) % walkLeft.length;
                }
            }
            if(Greenfoot.isKeyDown("w")){
                if(right){
                    setImage(jumpRight[index3]);
                    index3 = (index3 + 1) % jumpRight.length;
                }
                else{
                    setImage(jumpLeft[index3]);
                    index3 = (index3 + 1) % jumpLeft.length;
                }
            }
        }
        if(world instanceof titleWorld || world instanceof endScreen){
            jumpRight[index1].scale(70, 70);
            setImage(jumpRight[index1]);
            index1 = (index1 + 1) % jumpRight.length;
        }
    }
    
    
    private static int gravity = 2;
    public void jump(){
        World world = getWorld();
        boolean onGround = false;
        int acceleration = 3;
        int jumpForce = 10;
        if(world instanceof MyWorld){
            if(getY() == 300){
                onGround = true;
                jumpForce = 12;
            }
            if(getY() < 300){
                if(right){
                    setLocation(getX() + 1, getY() + acceleration++);
                }
                else{
                    setLocation(getX() - 1, getY() + acceleration++);
                }
            }
            if(Greenfoot.isKeyDown("w") && onGround){
                jump.play();
                while(jumpForce != 0){
                    setLocation(getX(), getY() - jumpForce);
                    jumpForce -= gravity;
                }
                acceleration = 4;
            }
        }
    }
    
    public void act()
    {
        // Add your action code here.
        World world = getWorld();
        sound.setVolume(45);
        if(world instanceof MyWorld){
            if(Greenfoot.isKeyDown("a")){
            move(-1*speed);
            right = false;
            }
            if(Greenfoot.isKeyDown("d")){
                move(speed);
                right = true;
            }
            
            jump();
            
            moreApple();
            
            setSpeed();
        }
        animateElephant();
    }
    
    public void moreApple(){
        World world = getWorld();
        if(world instanceof MyWorld){
            MyWorld myworld = (MyWorld) getWorld();
            if(isTouching(Apple.class)){
                sound.play();
                myworld.createApple();
                removeTouching(Apple.class);
                myworld.increaseScore();
            }
        }
    }
    
    public void setSpeed(){
        MyWorld myworld = (MyWorld) getWorld();
        speed = myworld.speed;
    }
}
