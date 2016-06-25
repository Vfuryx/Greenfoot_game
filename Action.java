import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a description of class Action here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Action extends Actor
{
    public ArrayList<Box> boxs = new ArrayList<Box>();
    public int x;
    public int y;
    public Score score_field =null;
    public Score coins_field = null;
    public Fire fire_field =null;
    public Clear clear_field =null;
    public Last last_field = null;
    public HP hp_field  =null;
    /**
     * Act - do whatever the Action wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        try{
            keyDown();
        }
        catch(Exception e){
        }

    }    

    public Action(){ 

    }

    public void setUpButton1(){
        Button button_field = new Button("images/mode1.1.png","images/mode1.png","mode1");
        getWorld().addObject(button_field, 400, 250);
    }

    public void setUpButton2(){
        Button button_field = new Button("images/mode2.1.png","images/mode2.png","mode2");
        getWorld().addObject(button_field, 400, 350);
    }

    public void setUpButton3(){
        Button button_field = new Button("images/mode3.1.png","images/mode3.png","mode3");
        getWorld().addObject(button_field, 400, 450);
    }

    public void setUpButton4(){
        Button button_field = new Button("images/backspace.png","images/backspace2.png","mode0");
        getWorld().addObject(button_field, 725, 35);
    }

    public void setUpButton5(){
        Button button_field = new Button("images/logo.png","images/logo.png","11");
        getWorld().addObject(button_field, 400, 120);
    }

    public void setUpButton6(){
        Button button_field = new Button("images/clear2.png","images/clear2.png","11");
        getWorld().addObject(button_field, 720, 310);
    }

    public void setUpBox(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                x = 150+70+120*j;
                y = 50+70+120*i;
                boxs.add(new Box(0,x,y));
                getWorld().addObject(boxs.get(j+i*4),x,y);
            }
        }
    } 

    public void setUpScore(){
        score_field = new Score("Score: ",0);
        getWorld().addObject(score_field, 290, 28);
    }

    public void setUpCoins(){
        coins_field = new Score("Coins: ",0);
        getWorld().addObject(coins_field, 530, 28);
    }

    public void setUpFire(){
        fire_field = new Fire(coins_field,hp_field);
        getWorld().addObject(fire_field, 720, 135);
    }

    public void setUpClear(){
        clear_field = new Clear(coins_field);
        getWorld().addObject(clear_field, 720, 250);
    }

    public void setUpLife(){
        Life life_field = new Life();
        getWorld().addObject(life_field, 75, 360);
    }

    public void setUpHP(){
        hp_field = new HP();
        getWorld().addObject(hp_field,75, 360);
    }

    public void setUpLast(){
        last_field = new Last();
        //Last last_field = new Last(boxs ,coins_field);
        getWorld().addObject(last_field, 720, 390);
    }

    //获取随机数
    public boolean generateOneNumber(){
        if(nospace())
            return false;
        int randX =Greenfoot.getRandomNumber(4);
        int randY =Greenfoot.getRandomNumber(4);
        int cout = 0; //纪录次数
        while(++cout<10){
            if(boxs.get(randY+randX*4).getNumber()==0)
                break;
            randX =Greenfoot.getRandomNumber(4);
            randY =Greenfoot.getRandomNumber(4);
        }
        if(cout>=10){
            int [] arr = getNospaceArr();
            int rankey=Greenfoot.getRandomNumber(getNospacecut());
            randX=arr[rankey]/4;
            randY=arr[rankey]%4;
        }
        int randNumber=Math.random()<0.9?2:4;
        boxs.get(randY+randX*4).setNumber(randNumber);
        return true;
    }

    public boolean nospace(){
        for(int i=0; i<4;i++){
            for(int j=0;j<4;j++){
                if(boxs.get(j+i*4).getNumber()==0)
                    return false;
            }
        }
        return true;
    }

    public  int[] getNospaceArr(){
        int key = getNospacecut();
        int [] Arr=new int[key];
        int k=0;
        for(int i=0; i<4;i++){
            for(int j=0;j<4;j++){
                if(boxs.get(j+i*4).getNumber()==0){
                    Arr[k]=i*4+j;
                    k++;
                }
            }
        }
        return Arr;
    }

    public  int getNospacecut(){
        int c=0;
        for(int i=0; i<4;i++){
            for(int j=0;j<4;j++){
                if(boxs.get(j+i*4).getNumber()==0){
                    c++;
                }
            }
        }
        return c;
    }

    //控制代码
    public void keyDown(){
        String key = Greenfoot.getKey(); //判断按下放开后的键是什么

        if(key=="left"){
            last_field.setMs(boxs ,coins_field);
            if(moveLeft()){
                Greenfoot.playSound("2.mp3");
                generateOneNumber();
                isGameOver(); 
            }
        }
        else if(key=="up"){
            last_field.setMs(boxs ,coins_field);
            if(moveUp()){
                Greenfoot.playSound("2.mp3");
                generateOneNumber();
                isGameOver();
            }
        }
        else if(key=="right"){
            last_field.setMs(boxs ,coins_field);
            if(moveRight()){
                Greenfoot.playSound("2.mp3");
                generateOneNumber();
                isGameOver();
            }
        }
        else if(key=="down"){
            last_field.setMs(boxs ,coins_field);
            if(moveDown()){
                Greenfoot.playSound("2.mp3");
                generateOneNumber();
                isGameOver();

            }
        }
        if(getWorld().getObjects(HP.class)!=null){ //判断是否有对象生成
            if(hp_field.getNumber()<=0){
                gameover();
            }
        }
    }

    public void isGameOver(){
        if(nospace() && nomove()){
            gameover();
        }
    }

    public boolean nomove(){
        if( canMoveLeft() || canMoveRight() || canMoveDown() || canMoveUp())
            return false;
        return true;
    }

    public void gameover(){
        getWorld().addObject(new Text("gameover",100),getWorld().getWidth()/2,getWorld().getHeight()/2);
    }

    public  boolean moveLeft(){
        if(!canMoveLeft()){
            return false;
        }

        for(int i=0; i<4;i++){
            for(int j=0;j<4;j++){
                if(boxs.get(j+i*4).getNumber()!=0)
                    for(int k=0;k<j;k++){

                        if(boxs.get(k+i*4).getNumber()==0 && noBlockHorizontal(i,k,j)){
                            if(boxs.get(j+i*4).getNumber()!=0){//判断只要要生成一个
                                coins_field.setNumber("Coins: ",boxs.get(j+i*4).getNumber());
                                getWorld().addObject(new CA(boxs.get(j+i*4),boxs.get(k+i*4),1,1),boxs.get(j+i*4).getX(),boxs.get(j+i*4).getY());
                            }
                            continue;
                        }
                        else if(boxs.get(k+i*4).getNumber()==boxs.get(j+i*4).getNumber() && noBlockHorizontal(i,k,j)){
                            if(boxs.get(j+i*4).getNumber()!=0){
                                if(getWorld().getObjects(HP.class)!=null){
                                    try{
                                        hp_field.setNumber(boxs.get(j+i*4).getNumber()*2);
                                    }catch(Exception e){
                                    }
                                }
                                coins_field.setNumber("Coins: ",boxs.get(j+i*4).getNumber()*2);
                                score_field.setNumber("Score: ",boxs.get(j+i*4).getNumber()*2);//分数
                                getWorld().addObject(new CA(boxs.get(j+i*4),boxs.get(k+i*4),2,1),boxs.get(j+i*4).getX(),boxs.get(j+i*4).getY());
                            }
                            continue;
                        }
                    }
            }
        }
        return true;
    }

    public  boolean moveRight(){
        if(!canMoveRight()){
            return false;
        }

        for(int i=0; i<4;i++){
            for(int j=2;j>=0;j--){
                if(boxs.get(j+i*4).getNumber()!=0)
                    for(int  k=3;k>j;k--){
                        if(boxs.get(k+i*4).getNumber()==0 && noBlockHorizontal(i,j,k)){
                            if(boxs.get(j+i*4).getNumber()!=0){
                                coins_field.setNumber("Coins: ",boxs.get(j+i*4).getNumber());
                                getWorld().addObject(new CA(boxs.get(j+i*4),boxs.get(k+i*4),1,2),boxs.get(j+i*4).getX(),boxs.get(j+i*4).getY());
                            }
                            continue;
                        }
                        else if(boxs.get(k+i*4).getNumber()==boxs.get(j+i*4).getNumber() && noBlockHorizontal(i,j,k)){
                            if(boxs.get(j+i*4).getNumber()!=0){
                                coins_field.setNumber("Coins: ",boxs.get(j+i*4).getNumber()*2);
                                score_field.setNumber("Score: ",boxs.get(j+i*4).getNumber()*2);//分数
                                if(getWorld().getObjects(HP.class)!=null){
                                    try{
                                        hp_field.setNumber(boxs.get(j+i*4).getNumber()*2);
                                    }catch(Exception e){
                                    }
                                }
                                getWorld().addObject(new CA(boxs.get(j+i*4),boxs.get(k+i*4),2,2),boxs.get(j+i*4).getX(),boxs.get(j+i*4).getY());
                            }
                            continue;
                        }
                    }
            }
        }
        return true;
    }

    public  boolean moveUp(){
        if(!canMoveUp()){
            return false;
        }

        for(int i=0; i<4;i++){
            for(int j=0;j<4;j++){
                if(boxs.get(j+i*4).getNumber()!=0)
                    for(int  k=0;k<i;k++){
                        if(boxs.get(j+k*4).getNumber()==0 && noBlockVertical(k,i,j)){
                            if(boxs.get(j+i*4).getNumber()!=0){
                                coins_field.setNumber("Coins: ",boxs.get(j+i*4).getNumber());
                                getWorld().addObject(new CA(boxs.get(j+i*4),boxs.get(j+k*4),1,3),boxs.get(j+i*4).getX(),boxs.get(j+i*4).getY());
                            }
                            continue;
                        }
                        else if(boxs.get(j+k*4).getNumber()==boxs.get(j+i*4).getNumber() && noBlockVertical(k,i,j)){
                            if(boxs.get(j+i*4).getNumber()!=0){
                                coins_field.setNumber("Coins: ",boxs.get(j+i*4).getNumber()*2);
                                score_field.setNumber("Score: ",boxs.get(j+i*4).getNumber()*2);//分数
                                if(getWorld().getObjects(HP.class)!=null){
                                    try{
                                        hp_field.setNumber(boxs.get(j+i*4).getNumber()*2);
                                    }catch(Exception e){
                                    }
                                }
                                getWorld().addObject(new CA(boxs.get(j+i*4),boxs.get(j+k*4),2,3),boxs.get(j+i*4).getX(),boxs.get(j+i*4).getY());
                            }
                            continue;
                        }
                    }
            }
        }
        return true;
    }

    public  boolean moveDown(){
        if(!canMoveDown()){
            return false;
        }

        for(int i=2; i>=0;i--){
            for(int j=0;j<4;j++){
                if(boxs.get(j+i*4).getNumber()!=0)
                    for(int  k=3;k>i;k--){
                        if(boxs.get(j+k*4).getNumber()==0 && noBlockVertical(i,k,j)){
                            if(boxs.get(j+i*4).getNumber()!=0){
                                coins_field.setNumber("Coins: ",boxs.get(j+i*4).getNumber());
                                getWorld().addObject(new CA(boxs.get(j+i*4),boxs.get(j+k*4),1,4),boxs.get(j+i*4).getX(),boxs.get(j+i*4).getY());
                            }
                            continue;
                        }
                        else if(boxs.get(j+k*4).getNumber()==boxs.get(j+i*4).getNumber() && noBlockVertical(i,k,j)){
                            if(boxs.get(j+i*4).getNumber()!=0){
                                coins_field.setNumber("Coins: ",boxs.get(j+i*4).getNumber()*2);
                                score_field.setNumber("Score: ",boxs.get(j+i*4).getNumber()*2);//分数
                                if(getWorld().getObjects(HP.class)!=null){
                                    try{
                                        hp_field.setNumber(boxs.get(j+i*4).getNumber()*2);
                                    }catch(Exception e){
                                    }
                                }
                                getWorld().addObject(new CA(boxs.get(j+i*4),boxs.get(j+k*4),2,4),boxs.get(j+i*4).getX(),boxs.get(j+i*4).getY());
                            }
                            continue;
                        }
                    }
            }
        }
        return true;
    }
    //i      k       j   
    //i,     j,      k
    public boolean noBlockHorizontal(int row,int col1, int col2){ 
        for(int i=col1+1;i<col2;i++){
            if (boxs.get(i+row*4).getNumber() !=0)
                return false;
        }
        return true;
    }

    public boolean noBlockVertical(int row1,int row2, int col){
        for(int i=row1+1;i<row2;i++){
            if(boxs.get(col+i*4).getNumber()!=0){
                return false;
            }
        }
        return true;
    }

    public boolean canMoveLeft(){
        for(int i=0;i<4;i++){
            for(int j=1;j<4;j++){
                if(boxs.get(j+i*4).getNumber()!=0){
                    if(boxs.get(j-1+i*4).getNumber() == 0 || boxs.get(j-1+i*4).getNumber()==boxs.get(j+i*4).getNumber()){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean canMoveRight(){
        for(int i=0;i<4;i++){
            for(int j=2;j>=0;j--){
                if(boxs.get(j+i*4).getNumber()!=0){
                    if(boxs.get(j+1+i*4).getNumber()==0 ||boxs.get(j+1+i*4).getNumber()==boxs.get(j+i*4).getNumber()){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean canMoveUp(){
        for(int j=0;j<4;j++){
            for(int i=1;i<4;i++){
                if(boxs.get(j+i*4).getNumber()!=0){
                    if(boxs.get(j+(i-1)*4).getNumber()==0 || boxs.get(j+(i-1)*4).getNumber()==boxs.get(j+i*4).getNumber()){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean canMoveDown(){
        for(int j=0;j<4;j++){
            for(int i=2;i>=0;i--){
                if(boxs.get(j+i*4).getNumber()!=0){
                    if(boxs.get(j+(i+1)*4).getNumber()==0 || boxs.get(j+(i+1)*4).getNumber()==boxs.get(j+i*4).getNumber()){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
