import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;
/**
 * Write a description of class Last here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Last extends Actor
{
    public ArrayList<Box> boxs = new ArrayList<Box>();
    public Score coins_field =null;
    public int num[] = new int[16];
    /**
     * Act - do whatever the Last wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Last(){
    }    

    public void setMs(ArrayList<Box> boxs,Score coins_field){
        this.boxs=boxs;
        this.coins_field=coins_field;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                this.num[j+i*4]=boxs.get(j+i*4).getNumber();
            }
        }
    }

    public void act() 
    {
        // Add your action code here.
        mouse();
    }    

    public void mouse(){

        if(Greenfoot.mouseClicked(this)&& coins_field.getNumber() >=300){
            if(isSame()){
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        this.boxs.get(j+i*4).setNumber(this.num[j+i*4]);
                    }
                }
                this.coins_field.setNumber("Coins: ",-300);
                Greenfoot.playSound("1.mp3");
            }
        }
    }

    public boolean isSame(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(this.boxs.get(j+i*4).getNumber()!=this.num[j+i*4])
                    return true;
            }
        }
        return false;
    }
}
