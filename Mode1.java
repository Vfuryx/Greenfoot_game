import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mode1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mode1 extends World
{

    /**
     * Constructor for objects of class Mode1.
     * 
     */
    public Mode1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800,600, 1); 
        setBackground(new GreenfootImage("images/bg2.png"));//设置背景
        Action a = new Action();
        addObject(a,0,0);
        a.setUpBox();
        a.setUpScore();
        a.setUpCoins();
        a.setUpClear();
        a.setUpLife();
        a.setUpHP(); 
        a.setUpFire();//要放在setUpLife()和setUpHP()下面；
        a.setUpLast();
        a.setUpButton4();
        a.setUpButton6();
        a.generateOneNumber();
        a.generateOneNumber();
    }
}
