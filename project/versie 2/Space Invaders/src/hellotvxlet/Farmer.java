package hellotvxlet;

public class Farmer extends Sprite2 implements Values {

    public Farmer(int x, int width, int height, String img){
        this.image = img;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = 300 - this.height;
        this.component = new MyComponent(this.image, this.x, this.y, this.width, this.height);
    }
    
    public int Move(int keypressed)
    {   
        switch(keypressed)
        {
            case 37: 
                if(this.x >= 0){
                    this.x -= 5;
                    this.component.setLocation(this.x, this.y);
                }
                break;
            case 39:
                if(this.x < Screen_width - Player_width){
                    this.x += 5;
                    this.component.setLocation(this.x, this.y);
                }
                break;
            default:
                step = 0;
        }
        return step;
    }
}
