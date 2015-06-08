/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import org.dvb.ui.*;
import org.havi.ui.*;
import java.awt.*;

public class MijnComponent extends HComponent{
    private int x, y, width, height;
    
    public MijnComponent(int xPos, int yPos, int w, int h){
        this.x = xPos;
        this.y = yPos;
        this.width = w;
        this.height = h;
        
        this.setBounds(0,0,1000,1000);
    }
    
    public void paint(Graphics g){
        g.setColor(new DVBColor(0,0,0,50));
        g.fillRoundRect(this.x + 5, this.y + 5, this.width, this.height, 15, 15);
        g.setColor(new DVBColor(0,0,255,100));
        g.fillRoundRect(this.x, this.y, this.width, this.height, 15, 15);
        g.setColor(new DVBColor(255,255,0,255));
        g.drawString("Tekst1", this.x + (this.width/2), this.y + (this.height/2));
    }
    
}
