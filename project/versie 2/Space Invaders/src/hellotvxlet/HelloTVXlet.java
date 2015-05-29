package hellotvxlet;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Timer;
import org.dvb.ui.*;
import javax.tv.xlet.*;
import org.havi.ui.*;
import org.dvb.event.*;

public class HelloTVXlet extends Player implements Xlet, UserEventListener, Values {

    private XletContext actueleXletXontext;
    private HScene scene;
    private int posy = 50;
    private int shitTimer = 0;
    private int eggTimer = 0;
    private Enemy enemy;
    private Farmer farmer;

    public HelloTVXlet() 
    {
        
    }
    
    public void initXlet(XletContext context) throws XletStateChangeException
    {
        this.actueleXletXontext = context;
        
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);   
    
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
        
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
        // hier alles toevoegen aan scene (scene.add(...)
        enemy = new Enemy(0, 0, 50, 50, "right", "Chicken.png", scene);
        farmer = new Farmer(0, 0, 100, 100, "Farmer.png", scene);
        
        MyTimer mtt = new MyTimer(this);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(mtt,0, 24);
    }
        
        
    public void startXlet() 
    {
        EventManager manager = EventManager.getInstance();
        
        UserEventRepository repository = new UserEventRepository("Farmer");
        
        repository.addKey(org.havi.ui.event.HRcEvent.VK_LEFT);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_RIGHT);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_SPACE);
        
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
        
        farmer.Move(e.getCode());
        if(e.getType() == KeyEvent.KEY_PRESSED)
        {
            switch(e.getCode())
            {
                case org.havi.ui.event.HRcEvent.VK_SPACE:
                    farmer.Shoot();
                    break;
            }
        }
    }
    
    public void timerCallback(){
        shitTimer += 1;
        eggTimer += 1;
        
        enemy.Move(4);
        enemy.MoveShit();
        enemy.MoveEgg(farmer);
        farmer.MoveBullet(enemy.getShit());
        
        if(shitTimer >= 200) {
            enemy.ThrowShit();
            shitTimer = 0;
        }
        if(eggTimer >= 116){
            enemy.ThrowEgg();
            eggTimer = 0;
        }
        
    }
}
