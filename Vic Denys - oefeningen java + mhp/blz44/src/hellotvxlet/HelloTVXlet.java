package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;

import org.havi.ui.*;
import org.havi.ui.event.*;
import java.awt.event.*;


public class HelloTVXlet implements Xlet {

    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug = true;
    
    private MijnComponent cm;
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
        this.actueleXletContext = context;
        
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
    
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
        cm = new MijnComponent(100,100,300,50);
        scene.add(cm);
       
    }

    public void startXlet(){
        scene.validate();
        scene.setVisible(true);
    
    }
    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
}
