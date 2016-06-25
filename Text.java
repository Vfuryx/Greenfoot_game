import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */  
    public void setText(String t1){
        setImage(new GreenfootImage(t1,70, Color.WHITE,null));;
    }
    public Text(){
        
    }
    public Text(String text) {
        setImage(new GreenfootImage(text,70, Color.WHITE,null));
    }
    public Text(String text,int i) {
        setImage(new GreenfootImage(text,i, Color.RED,null));
    }
    
    
}
