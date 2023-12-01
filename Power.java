import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Power here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Power extends Actor
{
    /**
     * Act - do whatever the Power wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int time = 0;
    private String type;
    
    public Power(String idk, int a){
        type = idk;
        time = a;
    }
    
    public int getTime(){
        return time;
    }
    
    public String getTypeOfPower(){
        return type;
    }
    
    public int rounds(){
        time--;
        return time;
    }
}
