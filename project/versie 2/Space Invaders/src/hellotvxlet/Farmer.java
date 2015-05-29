package hellotvxlet;

import org.havi.ui.HScene;

public class Farmer extends Sprite2 implements Values {

    private Shot bullet;
    
    public Farmer(int x, int y, int width, int height, String img, HScene sc){
        this.image = img;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.bullet = new Shot(30, 40, "Cleaner.png");
        this.component = new MyComponent(this.image, this.x, this.y, this.width, this.height);
        
        this.y = Screen_height - this.height;
        this.component.setLocation(this.x, this.y);
        
        sc.add(this.component);
        sc.add(this.bullet.component);
    }
    
    public void Shoot(){
        this.bullet.Shoot(this.x + (this.width/2), this.y);
    }
    
    public void MoveBullet(Shot shit){
        if(this.bullet.x + this.bullet.width >= shit.getX() 
                && this.bullet.x <= shit.getX() + shit.getWidth() 
                && this.bullet.y + this.bullet.height >= shit.getY()
                && this.bullet.y <= shit.getY() + shit.getHeight()){
            shit.getComponent().setVisible(false);
            shit.setIsGoing(false);
        }
        this.bullet.Move(15);
    }
    
    public int Move(int keypressed)
    {   
        switch(keypressed)
        {
            case 37: 
                if(this.x >= 0){
                    this.x -= 15;
                    this.component.setLocation(this.x, this.y);
                }
                break;
            case 39:
                if(this.x < Screen_width - Player_width){
                    this.x += 15;
                    this.component.setLocation(this.x, this.y);
                }
                break;
            default:
                step = 0;
        }
        return step;
    }
}
