package hellotvxlet;

import java.awt.event.*;

public class Player extends Sprite implements Values
{
    private final int Start_position_X = 390;
    private final int Start_position_Y = 240;
    private final String player = "player.png";
    private int width;
    
    public Player()
    {
        
    }
    
    public void Boundaries()
    {
        x += step;
        if(x <= 5)
        {
            x = 5;
        }
        if(x >= Game_width - (width + 5))
        {
            x = Game_width - (width + 5);
        }
    }
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT)
        {
            step = -2;
        }
        
        else if(key == KeyEvent.VK_RIGHT)
        {
            step = 2;
        }
    }
    
    public void KeyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT)
        {
            step = 0;
        }
    }
            
}