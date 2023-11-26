import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private int count = 0;
    public int score = 0;
    private Label Score;
    private Label Hp;
    public int life = 3;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 800, 1); 
        
        Rocket rocket = new Rocket();
        addObject(rocket, 200, 700);
        
        Score = new Label(0, 40);
        addObject(Score, 27, 27);
        
        Hp = new Label(3, 40);
        addObject(Hp, 373, 27);
    }
    
    public void act(){
        count++;
        if(count > 59){
            createOneUfo();
            count = 0;
        }
        if(Greenfoot.getRandomNumber(100) < 1) createAlien();
    }
    
    public void increaseScore(){
        score++;
        Score.setValue(score);
    }
    
    public void takeDamage(){
        life--;
        Hp.setValue(life);
    }
    
    public void createOneUfo(){
        addObject(new Ufo(), Greenfoot.getRandomNumber(400), 0);
    }
    
    public void createAlien(){
        addObject(new Alien(), Greenfoot.getRandomNumber(400), 0);
    }
    
    public void gameOver(){
        Label gameOver = new Label("mission failed :(", 40);
        addObject(gameOver, 200, 400);
        Greenfoot.stop();
    }
}
