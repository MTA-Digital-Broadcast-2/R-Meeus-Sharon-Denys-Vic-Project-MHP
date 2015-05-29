package hellotvxlet;

public class Enemy extends Sprite2 implements Values {
    
    private String direction;
    
    public Enemy(int x, int y, int width, int height, String dir, String img){
        this.direction = dir;
        this.image = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.component = new MyComponent(this.image, this.x, this.y, this.width, this.height);
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
}
