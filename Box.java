import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Box here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Box extends Actor
{
    private int width=100;
    private int height=100;
    public Color color;
    public int x=0;//getX
    public int y=0;//getY
    public int num=0; //数字
    public int b=0;
    public Box(int num , int getX,int getY){
        this.num=num;
        this.x=getX;
        this.y=getY;
        updateImage();

    }

    public Box(int num){
        this.num=num;
        updateImage();
    }

    public int getNumber(){
        return this.num;
    }

    public void setNumber(int num){
        this.num=num;
        updateImage();
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void updateImage(){
        GreenfootImage image = new GreenfootImage(getNumberBackgroundColor(this.num));
        if(this.num==0){
            image.setTransparency(0);
        }
        setImage(image);
        
    }

    public  String getNumberBackgroundColor(int number){//按数字获取颜色
        switch(number){
            case 2:
            return "images/LV1.png";
            case 4:return "images/LV2.png";
            case 8:return "images/LV3.png";
            case 16:return "images/LV4.png";
            case 32:return "images/LV5.png";
            case 64:return "images/LV6.png";
            case 128:return "images/LV7.png";
            case 256:return "images/LV8.png";
            case 512:return "images/LV9.png";
            case 1024:return "images/LV10.png";
            case 2048:return "images/LV11.png";
            case 4096:return "images/LV12.png";
            case 8192:return "images/LV13.png";
            default:
            return "images/LV0.png";
        }  
    }

    public Color getColor(){
        return this.color;
    }
}
