import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class HP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HP extends Life
{
    /**
     * Act - do whatever the HP wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int life =39800;
    public int num ;
    public int height=398;
    
    public HP(){
        GreenfootImage lifeImg = new GreenfootImage(29,398);
        lifeImg.setColor(new Color(255,0,0));
        lifeImg.fillRect(1,0,27,this.height);
        setImage(lifeImg);
    }

    public void act() 
    {
        // Add your action code here.
    }    

    public void setNumber(int num1){
        this.life-=num1;
        //System.out.println("1212");
        this.num+=num1;
        //this.height-=(this.num/1);
        getWorld().addObject(new ShowLife(num1),120,200+Greenfoot.getRandomNumber(300));
        updateNum();
    }
    
    public int getNumber(){
        return this.life;
    }

    public void updateNum(){
        GreenfootImage img_field = getImage();
        img_field.clear();
        img_field.fillRect(1,0,27,this.height-(this.num/100));
        setImage(img_field);
    } 


}
