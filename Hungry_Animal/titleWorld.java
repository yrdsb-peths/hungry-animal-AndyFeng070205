import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class titleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class titleWorld extends World
{

    /**
     * Constructor for objects of class titleWorld.
     * 
     */
    Label title = new Label("Hungry Animal", 65);
    public titleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(title, getWidth() / 2, 100);
        prepare();
    }

    public void act(){
        if(Greenfoot.isKeyDown("space")){
            Greenfoot.setWorld(new MyWorld());
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,300,182);
        Label label = new Label("press <a> and <d> to move", 35);
        addObject(label,306,262);
        elephant.setLocation(300,200);
        Label label2 = new Label("press <w> to jump", 30);
        addObject(label2,300,306);
        Label label3 = new Label("press <space> to start", 30);
        addObject(label3,300,348);
    }
}
