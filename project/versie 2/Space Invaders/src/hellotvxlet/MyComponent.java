package hellotvxlet;

import java.awt.*;
import org.havi.ui.*;

public class MyComponent extends HComponent
    {
        private Image bmap;
        private MediaTracker mtrack;
        private int x;
        private int y;
        private int width;
        private int height;

        public MyComponent(String bitmapnaam, int x, int y, int width, int height)
        {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            bmap = this.getToolkit().getImage(bitmapnaam);
            mtrack = new MediaTracker(this);
            mtrack.addImage(bmap, 0);
            try
            {
                mtrack.waitForAll();
            }
            catch (Exception e)
            {
                System.out.println(e.toString());
            }
            this.setBounds(x, y, bmap.getWidth(null), bmap.getWidth(null));
        }
        
        public void paint(Graphics g)
        {
            g.drawImage(this.bmap, this.x, this.y, this.width, this.height, null);
        }
        
        
    }
