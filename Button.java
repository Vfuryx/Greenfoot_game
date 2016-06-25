import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public GreenfootImage img =null;
    public String s1;
    public String s2;
    public String mode;
    public Button(String s1, String s2,String mode){
        this.s1=s1;
        this.s2=s2;
        this.mode=mode;
        img =new GreenfootImage(s1);
        setImage(img);
    }

    public void act() 
    {
        // Add your action code here.
        move();
    }    

    public void move(){
        try{
            int x,sx,mx,y,sy,my;
            x=Greenfoot.getMouseInfo().getX();          
            y=Greenfoot.getMouseInfo().getY();
            sx=this.getX()-this.getImage().getWidth()/2;
            sy=this.getY()-this.getImage().getHeight()/2;
            mx=this.getX()+this.getImage().getWidth()/2;
            my=this.getY()+this.getImage().getHeight()/2;
            if((x>=sx&&x<=mx&&y>=sy&&y<=my)||Greenfoot.getMouseInfo().getActor()==this){
                img =new GreenfootImage(this.s2);
                setImage(img);

            }else{
                img =new GreenfootImage(this.s1);
                setImage(img);
            }
            if(Greenfoot.mouseClicked(this)){
                if(this.mode=="mode1"){
                    Greenfoot.setWorld(new Mode1());
                }
                if(this.mode=="mode2"){
                    Greenfoot.setWorld(new Mode2());
                }
                if(this.mode=="mode3"){
                    Greenfoot.setWorld(new Mode3());
                }
                if(this.mode=="mode0"){
                    Greenfoot.setWorld(new Table());
                }
                Greenfoot.playSound("1.mp3");
            }
        }
        catch(Exception e){
        }

    }
}

