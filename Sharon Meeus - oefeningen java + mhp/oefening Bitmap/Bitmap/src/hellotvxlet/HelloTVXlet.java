package hellotvxlet;

import java.awt.*;
import java.awt.event.*;
import javax.tv.xlet.*;
import org.havi.ui.*;
import org.dvb.event.*;

public class HelloTVXlet implements Xlet, UserEventListener {

    private XletContext actueleXletXontext;
    private HScene scene;
    private MijnComponent mc;
    private int posx = 50;
    private int posy = 50;

    public HelloTVXlet() {
        
    }
    
    public class MijnComponent extends HComponent
    {
        private Image bmap;
        private MediaTracker mtrack;
        
        public MijnComponent(String bitmapnaam, int x, int y)
        {
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
            g.drawImage(bmap, 0, 0, null);
        }
    }
    public void initXlet(XletContext context) throws XletStateChangeException
    {
        this.actueleXletXontext = context;
        
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);   
    
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
        
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
        mc = new MijnComponent("img.png", posx, posy); /* OEFENING 1 */
        
        scene.add(mc);
    }
        
        
    public void startXlet() 
    {
        EventManager manager = EventManager.getInstance();
        
        UserEventRepository repository = new UserEventRepository("Voorbeeld");
        
        repository.addKey(org.havi.ui.event.HRcEvent.VK_LEFT);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_RIGHT);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_UP);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_DOWN);
        
        manager.addUserEventListener(this, repository);
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException 
    {
        
    }

    public void userEventReceived(org.dvb.event.UserEvent e) {
        if(e.getType() == KeyEvent.KEY_PRESSED)
        {
            System.out.println("Pushed Button");
            System.out.println(e.getCode());
            switch(e.getCode())
            {
                case org.havi.ui.event.HRcEvent.VK_LEFT:
                    System.out.println("Left Key was Pressed");
                    mc.setLocation(posx, posy);
                    posx-= 5;
                    break;
                case org.havi.ui.event.HRcEvent.VK_RIGHT:
                    System.out.println("Right Key was Pressed");
                    mc.setLocation(posx, posy);
                    posx+= 5;
                    break;
                case org.havi.ui.event.HRcEvent.VK_UP:
                    System.out.println("Up Key was Pressed");
                    mc.setLocation(posx, posy);
                    posy -= 5;
                    break;
                case org.havi.ui.event.HRcEvent.VK_DOWN:
                    System.out.println("Down Key was Pressed");
                    mc.setLocation(posx, posy);
                    posy+= 5;
                    break;
            }
        }
    }
}
