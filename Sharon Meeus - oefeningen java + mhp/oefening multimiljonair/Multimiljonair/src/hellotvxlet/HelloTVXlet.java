package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import org.havi.ui.event.*;
import java.awt.event.*;


public class HelloTVXlet implements Xlet, HActionListener {

    private XletContext actueleXletXontext;
    private HScene scene;
    
    private boolean debug = true;
    
    private HStaticText tekstLabel;
    private HStaticText JuistAntwoord;
    private HStaticText FoutAntwoord;
    private HTextButton knop1, knop2, knop3, knop4, keerterug, hulplijn;
    private int rnd;
  
    public HelloTVXlet() {
        
        rnd = 1 + (int)(Math.random() * 4);
        
        
    }
    
    public void actionPerformed(ActionEvent e)
    {   
        if(rnd == 1 && e.getActionCommand().toString() == "IK-active" || rnd == 2 && e.getActionCommand().toString() == "VRIEND-active" || 
                rnd == 3 && e.getActionCommand().toString() == "MOEDER-active" || rnd == 4 && e.getActionCommand().toString() == "VIJAND-active")
        {
            JuistAntwoord.setVisible(true);
            keerterug.setVisible(true);
            keerterug.requestFocus();
            rnd = 1 + (int)(Math.random() * 4);
            knop1.setVisible(true);
            knop2.setVisible(true);
            knop3.setVisible(true);
            knop4.setVisible(true);
        }
        
        else
        {
            if(e.getActionCommand().toString() != "HULP")
            {
                FoutAntwoord.setVisible(true);
                keerterug.setVisible(true);
                keerterug.requestFocus();
            }
        }
        
        if(e.getActionCommand().toString() == "TERUG")
            {
                JuistAntwoord.setVisible(false);
                FoutAntwoord.setVisible(false);
                keerterug.setVisible(false);
                hulplijn.requestFocus();
                knop1.setFocusTraversal(null, knop3, null, knop2);
                knop2.setFocusTraversal(null, knop4, knop1, null);
                knop3.setFocusTraversal(knop1, hulplijn, null, knop4);
                knop4.setFocusTraversal(knop2, hulplijn, knop3, null);
            }
        
        if(e.getActionCommand().toString() == "HULP")
        {
            switch(rnd)
            {
                case 1: case 3: 
                        knop2.setVisible(false);
                        knop1.setFocusTraversal(null, knop3, null, null);
                        knop4.setVisible(false);
                        knop3.setFocusTraversal(knop1, null, null, null);
                        hulplijn.setFocusTraversal(knop3, null, null, null);
                        break;
                case 2: case 4: 
                        knop1.setVisible(false);
                        knop2.setFocusTraversal(null, knop4, null, null);
                        knop3.setVisible(false);
                        knop4.setFocusTraversal(knop2, null, null, null);
                        hulplijn.setFocusTraversal(knop4, null, null, null);
                        break;
            }
        }    
        
    }

    public void initXlet(XletContext context) throws XletStateChangeException
    {
        this.actueleXletXontext = context;
        
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);   
    
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
        
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
        
        
        tekstLabel = new HStaticText("Wie wordt multimiljonair?");
        
        tekstLabel.setLocation(150, 50);
        tekstLabel.setSize(400, 50);
        tekstLabel.setBackground(new DVBColor(94, 93, 92, 220));
        tekstLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
        knop1 = new HTextButton("IK");
        knop1.setLocation(50, 200);
        knop1.setSize(100, 50);
        knop1.setBackground(new DVBColor(0, 0, 0, 179));
        knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        
        knop2 = new HTextButton("JE BESTE VRIEND");
        knop2.setLocation(350, 200);
        knop2.setSize(300, 50);
        knop2.setBackground(new DVBColor(0, 0, 0, 179));
        knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        
        knop3 = new HTextButton("JE MOEDER");
        knop3.setLocation(50, 300);
        knop3.setSize(200, 50);
        knop3.setBackground(new DVBColor(0, 0, 0, 179));
        knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        
        knop4 = new HTextButton("JE ERGSTE VIJAND");
        knop4.setLocation(350, 300);
        knop4.setSize(300, 50);
        knop4.setBackground(new DVBColor(0, 0, 0, 179));
        knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        hulplijn = new HTextButton("Bel de hulplijn");
        hulplijn.setLocation(200, 400);
        hulplijn.setSize(300, 50);
        hulplijn.setBackground(new DVBColor(59, 121, 41, 179));
        hulplijn.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        keerterug = new HTextButton("Terug");
        keerterug.setLocation(300, 400);
        keerterug.setSize(100, 50);
        keerterug.setBackground(new DVBColor(94, 93, 92, 255));
        keerterug.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(keerterug);
        keerterug.setVisible(false);
        
        JuistAntwoord = new HStaticText("JUIST! Goed geraden!");
        
        JuistAntwoord.setLocation(0, 0);
        JuistAntwoord.setSize(700, 575);
        JuistAntwoord.setBackground(new DVBColor(0, 0, 0, 255));
        JuistAntwoord.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(JuistAntwoord);
        JuistAntwoord.setVisible(false);
        
        FoutAntwoord = new HStaticText("Helaas... Probeer opnieuw.");
        
        FoutAntwoord.setLocation(0, 0);
        FoutAntwoord.setSize(700, 575);
        FoutAntwoord.setBackground(new DVBColor(0, 0, 0, 255));
        FoutAntwoord.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(FoutAntwoord);
        FoutAntwoord.setVisible(false);
        
        knop1.setFocusTraversal(null, knop3, null, knop2);
        knop2.setFocusTraversal(null, knop4, knop1, null);
        knop3.setFocusTraversal(knop1, hulplijn, null, knop4);
        knop4.setFocusTraversal(knop2, hulplijn, knop3, null);
        hulplijn.setFocusTraversal(knop4, null, knop3, null);
        
        scene.add(tekstLabel);
        scene.add(knop1);
        scene.add(knop2);
        scene.add(knop3);
        scene.add(knop4);
        scene.add(hulplijn);
        
        knop1.requestFocus();
        
        knop1.setActionCommand("IK-active");
        knop2.setActionCommand("VRIEND-active");
        knop3.setActionCommand("MOEDER-active");
        knop4.setActionCommand("VIJAND-active");
        keerterug.setActionCommand("TERUG");
        hulplijn.setActionCommand("HULP");
        
        knop1.addHActionListener(this);
        knop2.addHActionListener(this);
        knop3.addHActionListener(this);
        knop4.addHActionListener(this);
        keerterug.addHActionListener(this);
        hulplijn.addHActionListener(this);
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
