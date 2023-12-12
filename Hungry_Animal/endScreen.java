import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class endScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class endScreen extends World
{

    /**
     * Constructor for objects of class endScreen.
     * 
     */
    
    public Label goodGame;
    public Label scoreCount;
    public endScreen(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        goodGame = new Label("Game Over", 70);
        addObject(goodGame, getWidth() / 2, getHeight() / 2 - 75);
        scoreCount = new Label("score: "+score, 70);
        addObject(scoreCount, 125, 35);
        prepare();
    }
    
    public void act(){
        reStart();
    }
    
    public void reStart(){
        if(Greenfoot.isKeyDown("space")){
            Greenfoot.setWorld(new MyWorld());
        }
        if(Greenfoot.isKeyDown("enter")){
            Greenfoot.stop();
        }
    }
    
    public void prepare(){
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 200);
        Label a = new Label("Press <space> to restart", 40);
        addObject(a, 300, 268);
        Label b = new Label("Press <enter> to quit", 40);
        addObject(b, 300, 320);
    }
}
