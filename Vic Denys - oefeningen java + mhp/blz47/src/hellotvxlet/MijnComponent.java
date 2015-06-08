/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import org.dvb.ui.*;
import org.dvb.event.*;
import org.havi.ui.*;
import java.awt.*;

public class MijnComponent extends HComponent{
    
    private Image bmap;
    private MediaTracker mtrack;
    private int xPos, yPos;
    
    public MijnComponent(String bitmapnaam, int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
        this.bmap = this.getToolkit().getImage(bitmapnaam);
        mtrack = new MediaTracker(this);
        mtrack.addImage(bmap, 0);
        
        try{
            mtrack.waitForAll();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        
        this.setBounds( xPos, yPos, bmap.getWidth(null), bmap.getHeight(null));
    }
    
    public void moveUp(int q){
        this.yPos -= q;
        this.setBounds(xPos, yPos,bmap.getWidth(null), bmap.getHeight(null));
    }
    
    public void moveDown(int q){
        this.yPos += q;
        this.setBounds(xPos, yPos,bmap.getWidth(null), bmap.getHeight(null));
    }
    
    public void paint(Graphics g){
        g.drawImage(bmap, this.xPos, this.yPos, null);
    }
    
}
