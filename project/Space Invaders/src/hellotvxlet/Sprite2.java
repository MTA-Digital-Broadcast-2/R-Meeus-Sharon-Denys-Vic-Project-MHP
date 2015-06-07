package hellotvxlet;

public class Sprite2
{
    protected boolean visible;
    protected MyComponent component;
    protected String image;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean is_dying;
    protected int step;
    
    public Sprite2()
    {
        visible = true;
    }
    
    public void die()
    {
        visible = false;
    }
    
    public boolean isVisible()
    {
        return visible;
    }
    
    protected void setVisible(boolean visible)
    {
        this.visible = visible;
    }
    
    public void setImageString(String image)
    {
        this.image = image;
    }
    
    public String getImageString()
    {
        return image;
    }
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    public int getX()
    {
        return x;
    }
    
    public void setY(int y)
    {
        this.y = y;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void setHeight(int h)
    {
        this.height = h;
    }
    
    public int getHeight()
    {
        return this.height;
    }
    
    public void setWidth(int w)
    {
        this.width = w;
    }
    
    public int getWidth()
    {
        return this.width;
    }
    
    public MyComponent getComponent(){
        return component;
    }
    
    public void isDying(boolean is_dying)
    {
        this.is_dying = is_dying;
    }
    
    public boolean isDying()
    {
        return is_dying;
    }
}
