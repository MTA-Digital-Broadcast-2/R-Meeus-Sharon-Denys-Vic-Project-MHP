
package hellotvxlet;

import java.awt.event.*;

public class Player extends Sprite implements Values
{
    private final int Start_position_X = 50;
    private final int Start_position_Y = Screen_height - Player_height;
    private final String playersrc = "Farmer.png";
    
    public Player()
    {
        setImageString(playersrc);
        setX(Start_position_X);
        setY(Start_position_Y);
    }
    
    public int Boundaries(int x, int screenwidth)
    {
        if(x < 1)
        {
            x = 1;
        }
        
        else if( x > screenwidth - Player_width)
        {
            x = screenwidth - Player_width - 1;
        }
        
        return x;
    }
    
    public int keyPressed(int keypressed)
    {
        int key = keypressed;
        
        switch(key)
        {
            case 37: 
                step = -5;
                break;
            case 39:
                step = 5;
                break;
            default:
                step = 0;

        }
        
        return step;
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
