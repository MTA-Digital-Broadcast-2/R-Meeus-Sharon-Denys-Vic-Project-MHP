package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;
import org.dvb.event.*;
import java.util.TimerTask;
import org.havi.ui.*;
import org.havi.ui.event.*;
import java.awt.event.*;

import java.util.Timer;


public class HelloTVXlet implements Xlet, UserEventListener {

    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug = true;
    
    private MijnComponent cm, cm2;
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
        this.actueleXletContext = context;
        
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
    
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
        cm = new MijnComponent("sterren.png", 0, 0);
        cm2 = new MijnComponent("sterren.png" , 0, 285);
        scene.add(cm2);
        scene.add(cm); 
        
        MijnTimerTask mtt = new MijnTimerTask(this);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(mtt, 0, 24);
       
    }

    public void startXlet(){
        EventManager manager = EventManager.getInstance();
        UserEventRepository repository = new UserEventRepository("Voorbeeld");
        
        repository.addKey( org.havi.ui.event.HRcEvent.VK_UP);
        repository.addKey( org.havi.ui.event.HRcEvent.VK_DOWN);
        
        manager.addUserEventListener(this, repository);
        
        scene.validate();
        scene.setVisible(true);
        
    }
    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
    
    public void userEventReceived(org.dvb.event.UserEvent e){
        if (e.getType() == KeyEvent.KEY_PRESSED){
            switch(e.getCode()){
                case HRcEvent.VK_UP:
                    cm.moveUp(5);
                    break;
                case HRcEvent.VK_DOWN:
                    cm.moveDown(5);
                    break;
            }
        }
    }
    
    public void callback(){
        cm.CheckYpos();
        cm2.CheckYpos();
        cm2.moveUp(1);
        cm.moveUp(1);
    }
}








