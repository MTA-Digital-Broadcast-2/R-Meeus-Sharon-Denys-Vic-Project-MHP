package hellotvxlet;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Timer;
import org.dvb.ui.*;
import org.davic.resources.*;
import javax.tv.xlet.*;
import org.havi.ui.*;
import org.dvb.event.*;
import org.havi.ui.event.*;

public class HelloTVXlet implements Xlet, HActionListener, UserEventListener, Values, ResourceClient, HBackgroundImageListener {

    private XletContext actueleXletXontext;
    private HScreen screen;
    private HBackgroundDevice bgDevice;
    private HBackgroundConfigTemplate bgTemplate;
    private HStillImageBackgroundConfiguration bgConfiguration;
    private HBackgroundImage agrondimg = new HBackgroundImage("farm.jpg");
    private HScene scene;
    private HTextButton startBtn, retry, continueGame, endGame;
    private HStaticText infoLabel, Titel, gameOver, scoreLabel, pauseText;
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
    
    public void notifyRelease(ResourceProxy proxy){ }
    public void release(ResourceProxy proxy){ }
    public boolean requestRelease(ResourceProxy proxy, Object requestData){ return false; }
    
    public void imageLoaded(HBackgroundImageEvent e){
        try{
            bgConfiguration.displayImage(agrondimg);
        }
        catch(Exception s){
            System.out.println(s.toString());
        }
    }
    
    public void imageLoadFailed(HBackgroundImageEvent e){
        System.out.println("Image kan niet geladen worden");
    }
    
    public void initXlet(XletContext context) throws XletStateChangeException
    {
        screen = HScreen.getDefaultHScreen();
        
        bgDevice = screen.getDefaultHBackgroundDevice();
        
        if(bgDevice.reserveDevice(this)){
             System.out.println("BackgroundImage device has been reserved");
        } else {
            System.out.println("Background image device cannot be reserved");
        }
        
        bgTemplate = new HBackgroundConfigTemplate();
        bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
        
        bgConfiguration = (HStillImageBackgroundConfiguration)bgDevice.getBestConfiguration(bgTemplate);
        try{
            bgDevice.setBackgroundConfiguration(bgConfiguration);
        }
        catch(java.lang.Exception e){
            System.out.println(e.toString());
        }
        
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
        agrondimg.load(this);
        
        EventManager manager = EventManager.getInstance();
        
        UserEventRepository repository = new UserEventRepository("Farmer");
        
        repository.addKey(org.havi.ui.event.HRcEvent.VK_LEFT);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_RIGHT);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_SPACE);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_ESCAPE);
        
        manager.addUserEventListener(this, repository);
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException 
    {
       agrondimg.flush(); 
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
    
    public void pauseScreen() {
     timer.cancel();
     //farmer.component.setVisible(false);
     
     pauseText = new HStaticText("PAUSE");
     pauseText.setSize(300, 100);
     pauseText.setLocation( (Screen_width - 300)/2, Screen_height/2 - 200 );
     pauseText.setBackground(new DVBColor(255,229,70,255));
     pauseText.setBackgroundMode(HVisible.BACKGROUND_FILL);
     scene.add(pauseText);
     
     continueGame = new HTextButton("Continue");
     continueGame.setSize(200, 50);
     continueGame.setLocation( (Screen_width - 200)/2, Screen_height/2 - 70 );
     continueGame.setBackground(new DVBColor(173,15,0,255));
     continueGame.setBackgroundMode(HVisible.BACKGROUND_FILL);
     scene.add(continueGame);
     
     endGame = new HTextButton("Exit Game");
     endGame.setSize(200, 50);
     endGame.setLocation( (Screen_width - 200)/2, Screen_height/2 );
     endGame.setBackground(new DVBColor(173,15,0,255));
     endGame.setBackgroundMode(HVisible.BACKGROUND_FILL);
     scene.add(endGame);
     
     endGame.setActionCommand("EndGame");
     endGame.setFocusTraversal(continueGame, null, null, null);
     endGame.addHActionListener(this);
     continueGame.setActionCommand("ContinueGame");
     continueGame.setFocusTraversal(null, endGame, null, null);
     continueGame.addHActionListener(this);
     continueGame.requestFocus();
     
     scene.repaint();
    
    }

    public void startGame(){
        score = 0;
        
        enemy = new Enemy(0, 0, 50, 50, "right", "Chicken.png", scene);
        farmer = new Farmer(0, 0, 100, 100, "Farmer.png", scene);
        
        MyTimer mtt = new MyTimer(this);
        timer = new Timer();
        timer.scheduleAtFixedRate(mtt,0, 24);
    }
    
    public void continueGame()
    {
        scene.remove(pauseText);
        pauseText = null;
        scene.remove(continueGame);
        scene.remove(endGame);
        
        //farmer.component.setVisible(true);
        
        MyTimer mtt = new MyTimer(this);
        timer = new Timer();
        timer.scheduleAtFixedRate(mtt,0, 24);
        
        scene.repaint();
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
        if(pauseText == null){
        farmer.Move(e.getCode());
        }
        if(e.getType() == KeyEvent.KEY_PRESSED)
        {
            switch(e.getCode())
            {
                case org.havi.ui.event.HRcEvent.VK_SPACE:
                    farmer.Shoot();
                    break;
                case org.havi.ui.event.HRcEvent.VK_ESCAPE:
                    if(retry == null){
                        pauseScreen();
                    }
                    break;
            }
        }
    }
    
    public void timerCallback(){
        shitTimer += 1;
        eggTimer += 1;
        
        enemy.Move(4);
        enemy.MoveEgg(farmer, -3);
        if(enemy.MoveEgg(farmer, 0) == 1){
            score += 10;
            System.out.println(score);
        }
        if(enemy.MoveShit(-3)){
            endGame();
        }
        if(score >= 100){
            enemy.MoveEgg(farmer, -2);
            enemy.MoveShit(-2);
        }
        else if(score >= 200){
            enemy.MoveEgg(farmer, -3);
            enemy.MoveShit(-3);
        }
        else if(score >= 300){
            enemy.MoveEgg(farmer, -4);
            enemy.MoveShit(-4);
        }
        else if(score >= 500){
            enemy.Move(5);
            enemy.MoveEgg(farmer, -8);
            enemy.MoveShit(-8);
        }
        else if(score >= 1000){
            enemy.Move(8);
            enemy.MoveEgg(farmer, -10);
            enemy.MoveShit(-10);
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
        
        else if(btn == "EndGame")
        {
            scene.removeAll();
            drawStartScreen();
            scene.repaint();
        }
        
        else if(btn == "ContinueGame")
        {
            continueGame();
        }
        

    }

}
