import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class ShowLife here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShowLife extends Actor
{
    /**
     * Act - do whatever the ShowLife wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int delay =0;
    //Text tx =null;
    //public GreenfootImage img =null;
    public ShowLife(int num){
        GreenfootImage img = new GreenfootImage("-"+num,40,new Color(255,0,0),null);
        setImage(img);
    }

    public void act() 
    {
        // Add your action code here.
        rember();
        delay++;
    }    

    public void rember(){
        if(delay>10){
            getWorld().removeObject(this);
            delay=0;
        }
    }

}