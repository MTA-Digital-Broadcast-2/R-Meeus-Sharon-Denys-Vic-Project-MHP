package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;

import org.havi.ui.*;
import org.havi.ui.event.*;
import java.awt.event.*;


public class HelloTVXlet implements Xlet, HActionListener {

    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug=true;
    
    private HStaticText tekstLabel1, tekstLabel2;
    private HTextButton knop1, knop2, knop3, knop4, knopHulplijn;
    
  
    public HelloTVXlet() {
        
    }
    
    public void actionPerformed(ActionEvent e){
        String hello = e.getActionCommand();
        if(hello == "knop1_actioned"){
            knop1.setBackground(new DVBColor(0,255,0,179));
        }
        else if(hello == "knop2_actioned"){
            knop2.setBackground(new DVBColor(255,0,0,179));
        }
        else if(hello == "knop3_actioned"){
            knop3.setBackground(new DVBColor(255,0,0,179));
        }
        else if(hello == "knop4_actioned"){
            knop4.setBackground(new DVBColor(255,0,0,179));
        }
        else if(hello == "knopHulplijn_actioned"){
            scene.remove(knop4);
            scene.remove(knop3);
        }
    }

    public void initXlet(XletContext context) {
        this.actueleXletContext = context;
        
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
    
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
    
        tekstLabel1 = new HStaticText("Wie wordt mutlimiljonair?");
        tekstLabel1.setLocation(100,30);
        tekstLabel1.setSize(250,30);
        tekstLabel1.setBackground(new DVBColor(255,255,255,179));
        tekstLabel1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(tekstLabel1);
        
        knop1 = new HTextButton("Ik");
        knop1.setLocation(100,150);
        knop1.setSize(200,30);
        knop1.setBackground(new DVBColor(255,255,255,179));
        knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(knop1);
        
        knop2 = new HTextButton("Jij");
        knop2.setLocation(100,200);
        knop2.setSize(200,30);
        knop2.setBackground(new DVBColor(255,255,255,179));
        knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(knop2);
        
        knop3 = new HTextButton("Wij");
        knop3.setLocation(100,250);
        knop3.setSize(200,30);
        knop3.setBackground(new DVBColor(255,255,255,179));
        knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(knop3);
        
        knop4 = new HTextButton("Iedereen");
        knop4.setLocation(100,300);
        knop4.setSize(200,30);
        knop4.setBackground(new DVBColor(255,255,255,179));
        knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(knop4);
        
        knopHulplijn = new HTextButton("Hulplijn");
        knopHulplijn.setLocation(100,350);
        knopHulplijn.setSize(200,30);
        knopHulplijn.setBackground(new DVBColor(0,0,255,179));
        knopHulplijn.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(knopHulplijn);
        
        knop1.setFocusTraversal(knop4, knop2, knop4, knop2);
        knop2.setFocusTraversal(knop1, knop3, knop1, knop3);
        knop3.setFocusTraversal(knop2, knop4, knop2, knop4);
        knop4.setFocusTraversal(knop3, knopHulplijn, knop3, knopHulplijn);
        knopHulplijn.setFocusTraversal(knop4, knop1, knop4, knop1);
        knop1.requestFocus();
        
        knop1.setActionCommand("knop1_actioned");
        knop1.addHActionListener(this);
        knop2.setActionCommand("knop2_actioned");
        knop2.addHActionListener(this);
        knop3.setActionCommand("knop3_actioned");
        knop3.addHActionListener(this);
        knop4.setActionCommand("knop4_actioned");
        knop4.addHActionListener(this);
        knopHulplijn.setActionCommand("knopHulplijn_actioned");
        knopHulplijn.addHActionListener(this);
        
        
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
