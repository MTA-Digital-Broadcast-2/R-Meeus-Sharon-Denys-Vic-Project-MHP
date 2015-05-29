package hellotvxlet;

public class Shot extends Sprite2 implements Values
{    
    private boolean isGoing;
    
    public Shot(int width, int height, String img)
    {
        this.image = img;
        this.width = width;
        this.height = height;
        this.isGoing = false;
        this.component = new MyComponent(this.image, this.x, this.y, this.width, this.height);
        this.component.setVisible(false);
    }
    
    public void Shoot(int x, int y){
        if(!this.isGoing){
            this.isGoing = true;
            this.x = x;
            this.y = y;
            this.component.setLocation(this.x, this.y);
            this.component.setVisible(true);
        }
    }
    
    public void Move(int speed){
        if (this.component.isVisible()){
            this.y -= speed;
            this.component.setLocation(this.x, this.y);
        }
        if (this.y <= 0 - this.height || this.y >= Screen_height){
            this.isGoing = false;
            this.component.setVisible(false);
        }
    }
    
    public boolean isGoing(){
        return this.isGoing;
    }
    
    public void setIsGoing(boolean d){
        this.isGoing = d;
    }
}
