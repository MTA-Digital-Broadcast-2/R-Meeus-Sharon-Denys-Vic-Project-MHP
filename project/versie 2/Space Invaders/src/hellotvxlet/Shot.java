package hellotvxlet;

public class Shot extends Sprite2
{    
    public Shot(int width, int height, String img, Farmer fr)
    {
        this.image = img;
        this.width = width;
        this.height = height;
        this.component = new MyComponent(this.image, this.x, this.y, this.width, this.height);
        this.component.setVisible(false);
    }
    
    public void Shoot(Farmer farmer){
        this.x = farmer.getX() + (farmer.getWidth()/2);
        this.y = farmer.getY()*2;
        this.component.setLocation(this.x, this.y);
        this.component.setVisible(true);
    }
}
