import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mode3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mode3 extends World
{

    /**
     * Constructor for objects of class Mode3.
     * 
     */
    public Mode3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800,600, 1); 
        setBackground(new GreenfootImage("images/massage.png"));//设置背景
        Action a = new Action();
        addObject(a,0,0);
        a.setUpButton4();
        
    }
}
