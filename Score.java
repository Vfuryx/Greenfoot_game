import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.applet.*;
import java.awt.*;
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    public int num=0;
    Font font1=new Font("Helvetica",Font.BOLD,35);

    public Score(String text,int num)
    {
        this.num-=num;
        GreenfootImage img_field = new GreenfootImage(248,50);
        img_field.setFont(font1);
        img_field.setColor(new Color(255,255,255));
        img_field.drawString(text+this.num, 5, 45);
        setImage(img_field);
    }

    public void setNumber(String text,int num)
    {
        this.num+=num;
        GreenfootImage img_field = getImage();
        img_field.clear();
        img_field.drawString(text+this.num, 5, 45);     
    }

    public int getNumber(){
        return this.num;
    }

}
