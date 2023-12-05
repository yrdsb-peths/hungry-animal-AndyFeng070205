import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Andy
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public int score = 0;
    public Label Score;
    public int life = 3;
    public Label Life;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, true); 
        
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        Score = new Label(0, 45);
        addObject(Score, 20, 20);
        
        Life = new Label("3", 45);
        addObject(Life, 580, 20);
        
        createApple();
    }
    
    public void createApple(){
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
    
    public void increaseScore(){
         score++;
         Score.setValue(score);
    }
    
    public void damage(){
        life--;
        Life.setValue(life);
    }
    
    public void gameOver1(){
        Label lol = new Label("Game Over, You Suck :(", 50);
        addObject(lol, getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
    }
    
    public void gameOver2(){
        Label win = new Label("you got lucky :>", 60);
        addObject(win, getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
    }
}
