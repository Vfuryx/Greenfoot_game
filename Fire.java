import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fire extends Actor
{
    public Score coins_field =null;
    public HP hp_field=null;
    /**
     * Act - do whatever the Fire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Fire(Score coins_field,HP hp_field){
        this.coins_field=coins_field;
        this.hp_field=hp_field;
    }   

    public void act() 
    {
        // Add your action code here.
        mouse();
    }    

    public void mouse(){
        if(Greenfoot.mouseClicked(this)&& coins_field.getNumber() >=500){
            Greenfoot.playSound("1.mp3");
            this.coins_field.setNumber("Coins: ",-500);
            this.hp_field.setNumber(500);
            if(!Greenfoot.mouseClicked(this))
                getWorld().addObject(new ShowLife(500),130,400+Greenfoot.getRandomNumber(200));
        }
    }
}
