package hellotvxlet;

import java.awt.Graphics;
import javax.tv.xlet.*;
import org.dvb.ui.*;
import org.havi.ui.*;


public class HelloTVXlet implements Xlet {

    private XletContext actueleXletXontext;
    private HScene scene;

    public HelloTVXlet() {
        
    }
    
    public class MijnComponent extends HComponent
    {
        
        public MijnComponent(int x, int y, int width, int height)
        {
            this.setBounds(x, y, width, height);
        }
        
        public void paint(Graphics g)
        {
            System.out.println("paint");
            g.setColor(new DVBColor(0, 0, 255, 150));
            g.fillRoundRect(0, 0, 200, 200, 30, 30);
        }
    }
    public void initXlet(XletContext context) throws XletStateChangeException
    {
        this.actueleXletXontext = context;
        
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);   
    
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
        
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
        MijnComponent mc = new MijnComponent(300, 100, 200, 200); /* OEFENING 1 */
        
        System.out.println("init");
        scene.add(mc);
    }
        
        
    public void startXlet() 
    {
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) 
    {
        
    }
}
