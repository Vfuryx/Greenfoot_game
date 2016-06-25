import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Table here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Table extends World
{
    public static int loop =0;
    /**
     * Constructor for objects of class Table.
     * 
     */
    GreenfootSound sound = new GreenfootSound("3.mp3");
    public Table()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800,600, 1); 
        setBackground(new GreenfootImage("images/bg.png"));//设置背景
        Action a = new Action();
        addObject(a,0,0);
        a.setUpButton1();
        a.setUpButton2();
        a.setUpButton3();
        a.setUpButton5();
        //System.out.println(sound.isPlaying());       
        if(loop++==0){
            sound.playLoop();
        }
    }
}
