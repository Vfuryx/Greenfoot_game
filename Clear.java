import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Clear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clear extends Actor
{
    public boolean i=true;
    public int x;
    public int y;
    public Score coins_field =null;
    /**
     * Act - do whatever the Clear wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Clear(Score coins_field){
        this.coins_field=coins_field;
    }    

    public void act() 
    {
        // Add your action code here.
        if(i){
            this.x=getX();
            this.y=getY();
            i=false;
        }
        mouse();
    }    

    public void mouse(){
        
        if(Greenfoot.mouseDragged(this)&& coins_field.getNumber() >=500){
            setLocation(Greenfoot.getMouseInfo().getX(),Greenfoot.getMouseInfo().getY());

        }else if(Greenfoot.mouseDragEnded(this)){
            Box b = (Box) getOneIntersectingObject(Box.class);
            if(b!=null){
                b.setNumber(0);
                coins_field.setNumber("Coins: ",-500);
                Greenfoot.playSound("1.mp3");
            }
            setLocation(this.x,this.y);
        }

    }
}
