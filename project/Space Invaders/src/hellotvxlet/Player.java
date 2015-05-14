
package hellotvxlet;

import java.awt.event.*;

public class Player extends Sprite implements Values
{
    private final int Start_position_X = 250;
    private final int Start_position_Y = 370;
    private final String player = "img.png";
    private int width;
    
    public Player()
    {
        setImageString(player);
        setX(Start_position_X);
        setY(Start_position_Y);
    }
    
    /*public void Boundaries()
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
    }*/
    
    public int keyPressed(int keypressed)
    {
        int key = keypressed;
        
        if(key == 37)
        {
            step = -2;
            return step;
        }
        
        else if(key == 39)
        {
            step = 2;
            return step;
        }
        
        else return 0;
    }
    
    /*public void KeyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT)
        {
            step = 0;
        }
    }*/
            
}
