import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class CA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CA extends Action
{
    public Box b1 =null;
    public Box b2 =null;
    public int m=3;
    public int mc;
    public int ver; 
    public int number ;
    public int fang;
    /**
     * Act - do whatever the CA wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //int i = 0;          var 是否融合 1/2   fang 方向 左1 右2 上3 下4
    public CA(Box b1,Box b2,int ver,int fang){
        this.b1=b1;
        this.b2=b2;
        this.ver=ver;
        this.fang =fang;
        this.number=b1.getNumber(); 
        GreenfootImage image = new GreenfootImage(b1.getImage());
        //image.setColor(b1.getColor());
        //image.fillRect(0,0,100,100);
        setImage(image);
        this.b1.setNumber(0);
        if( fang == 1){
            mc=b1.getX()-b2.getX();
        }else if (fang == 2){
            mc=b2.getX()-b1.getX();
        }else if (fang == 3){
            mc=b2.getY()-b1.getY();
        }else if (fang == 4){
            mc=b1.getY()-b2.getY();
        }

        mc/=m;
        if(this.ver==1){
            b2.setNumber(this.number);
            b2.getImage().setTransparency(0);
            
        }
        else if (this.ver==2){
            b2.setNumber(this.number*2);
            b2.getImage().setTransparency(0);
            
        }

    }

    public void act() 
    {
        move();
    }    

    public void move(){   
        if(m>0){
            m--;
            if(fang==1){
                setLocation(this.getX()-this.mc,this.getY());
            }else if(fang==2){
                setLocation(this.getX()+this.mc,this.getY());
            }else if(fang==3){
                setLocation(this.getX(),this.getY()+this.mc);
            }else if(fang==4){
                setLocation(this.getX(),this.getY()-this.mc);
            }
        }
        else if(m<=0){
            if(b2.getNumber()!=0)
                b2.getImage().setTransparency(255);
            getWorld().removeObject(this);
        }
    }
}
