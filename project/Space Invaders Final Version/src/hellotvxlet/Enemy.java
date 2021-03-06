package hellotvxlet;

import org.havi.ui.HScene;

public class Enemy extends Sprite2 implements Values {
    
    private String direction;
    private Shot shit;
    private Shot egg;
    private int created_egg = 0;
    
    public Enemy(int x, int y, int width, int height, String dir, String img, HScene sc){
        this.direction = dir;
        this.image = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.shit = new Shot(20, 15, "Shit.png");
        this.egg = new Shot(20, 25, "Egg.png");
        this.component = new MyComponent(this.image, this.x, this.y, this.width, this.height);
        
        sc.add(this.shit.component);
        sc.add(this.egg.component);
        sc.add(this.component);
    }
    
    public void ThrowShit(){
        this.shit.Shoot(this.x, this.y);
    }
    
    public boolean MoveShit(int speed){
        if(this.shit.y + this.shit.height >= Screen_height){
            this.shit.getComponent().setVisible(false);
            this.shit.getComponent().setLocation(0, 0);
            this.shit.setIsGoing(false);
            return true;
        }
        this.shit.Move(speed);
        return false;
    }
    
    public void ThrowEgg(){
        this.egg.Shoot(this.x, this.y);
        created_egg = 0;
    }
    
    public int MoveEgg(Farmer fr, int speed){
        if(this.egg.x + this.egg.width >= fr.getX() 
                && this.egg.x <= fr.getX() + fr.getWidth() 
                && this.egg.y + this.egg.height >= fr.getY()
                && this.egg.y <= fr.getY() + fr.getHeight()){
            this.egg.getComponent().setVisible(false);
            this.egg.setIsGoing(false);
            created_egg++;
        }
        this.egg.Move(speed);
        return created_egg;
    }
    
    public void Move(int speed){
        this.CheckBounderies();
        if (this.direction == "left"){
            this.x -= speed;
        }
        else if (this.direction == "right"){
            this.x += speed;
        }
         this.component.setLocation(this.x, this.y);
    }
    
    private void CheckBounderies(){
        if(this.x <= 0){
            this.direction = "right";
        }
        else if(this.x >= Screen_width - this.width){
            this.direction = "left";
        }
    }
    
    public Shot getShit(){
        return this.shit;
    }
    
}
