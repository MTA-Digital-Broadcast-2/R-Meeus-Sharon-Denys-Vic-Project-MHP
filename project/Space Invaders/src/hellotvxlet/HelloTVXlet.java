package hellotvxlet;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Timer;
import org.dvb.ui.*;
import javax.tv.xlet.*;
import org.havi.ui.*;
import org.dvb.event.*;
import org.havi.ui.event.HActionListener;

public class HelloTVXlet implements Xlet, HActionListener, UserEventListener, Values {

    private XletContext actueleXletXontext;
    private HScene scene;
    private HTextButton startBtn, retry;
    private HStaticText infoLabel, Titel, gameOver, scoreLabel;
    private Timer timer;
    private int posy = 50;
    private int shitTimer = 0;
    private int eggTimer = 0;
    private int score = 0;
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
        drawStartScreen();
        
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
    
    public void drawStartScreen(){
        Titel = new HStaticText("EGG FRENZY");
        Titel.setLocation((Screen_width - 250)/2, (Screen_height - 30)/2 - 200);
        Titel.setSize(250,30);
        Titel.setBackground(new DVBColor(255,229,70,255));
        Titel.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(Titel);
        
        infoLabel = new HStaticText("try to catch all the eggs.\n But be carefull if the excrement of\n the chicken touches the ground,\n you LOST the game!");
        infoLabel.setLocation((Screen_width - 350)/2, (Screen_height - 30)/2 - 160);
        infoLabel.setSize(350, 160);
        infoLabel.setBackground(new DVBColor(255,229,70,255));
        infoLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(infoLabel);
        
        startBtn = new HTextButton("Start Game");
        startBtn.setLocation((Screen_width - 200)/2,(Screen_height - 30)/2 + 20);
        startBtn.setSize(200,30);
        startBtn.setBackground(new DVBColor(173,15,0,255));
        startBtn.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(startBtn);
        
        startBtn.setActionCommand("startKnop");
        startBtn.addHActionListener(this);
        
        startBtn.requestFocus();
       
    }

    public void startGame(){
        score = 0;
        
        enemy = new Enemy(0, 0, 50, 50, "right", "Chicken.png", scene);
        farmer = new Farmer(0, 0, 100, 100, "Farmer.png", scene);
        
        MyTimer mtt = new MyTimer(this);
        timer = new Timer();
        timer.scheduleAtFixedRate(mtt,0, 24);
    }
    
    public void endGame(){
        scene.removeAll();
        timer.cancel();
        
        gameOver = new HStaticText("Game Over");
        gameOver.setLocation((Screen_width - 250)/2, (Screen_height - 30)/2 - 200);
        gameOver.setSize(250,30);
        gameOver.setBackground(new DVBColor(255,229,70,255));
        gameOver.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(gameOver);
        
        scoreLabel = new HStaticText("Score = " + Integer.toString(score));
        scoreLabel.setLocation((Screen_width - 350)/2, (Screen_height - 30)/2 - 160);
        scoreLabel.setSize(350, 160);
        scoreLabel.setBackground(new DVBColor(255,229,70,255));
        scoreLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(scoreLabel);
        
        retry = new HTextButton("Replay");
        retry.setLocation((Screen_width - 200)/2,(Screen_height - 30)/2 + 20);
        retry.setSize(200,30);
        retry.setBackground(new DVBColor(173,15,0,255));
        retry.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(retry);
        
        retry.setActionCommand("retry");
        retry.addHActionListener(this);
        
        retry.requestFocus();
        
        scene.repaint();
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
        enemy.MoveEgg(farmer, -3);
        if(enemy.MoveShit(-3)){
            endGame();
        }
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

    public void actionPerformed(ActionEvent event) {
        String btn = event.getActionCommand();
        if(btn == "startKnop" || btn == "retry"){
            scene.removeAll();
            startGame();
        }

    }
}
