package hellotvxlet;

import java.awt.*;
import java.awt.event.*;
import org.dvb.ui.*;
import javax.tv.xlet.*;
import org.havi.ui.*;
import org.dvb.event.*;

public class HelloTVXlet extends Player implements Xlet, UserEventListener, Values {

    private XletContext actueleXletXontext;
    private HScene scene;
    private MijnComponent myplayer;
    private MijnComponent myammo;
    private int playerx;
    private int posy = 50;
    private Player player;
    private Shot shot;

    public HelloTVXlet() 
    {
        
    }
    
    public class MijnComponent extends HComponent
    {
        private Image bmap;
        private MediaTracker mtrack;
        
        
        public MijnComponent(String bitmapnaam, int x, int y)
        {
            bmap = this.getToolkit().getImage(bitmapnaam);
            System.out.println(this.getToolkit().getImage(bitmapnaam));
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

        public void drawPlayer(Graphics g, Image bmap)
        {
            if(player.isVisible())
            {
                g.drawImage(bmap, 0, 0, Player_width, Player_height, null);
            }
        }
        
        public void drawPlayerShot(Graphics g, Image bmap)
        {
            if(shot.isVisible())
            {
                g.drawImage(bmap, Player_width/2 - 10, 0, Player_shoot_width, Player_shoot_height, null);
            }
        }
        
        public void paint(Graphics g)
        {
            if(bmap == myplayer.bmap)
            {
                drawPlayer(g, myplayer.bmap);
            }
            else if(bmap == myammo.bmap)
            {
                drawPlayerShot(g, myammo.bmap);
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
        
        // hier alles toevoegen aan scene (scene.add(...)
        player = new Player();
        shot = new Shot();
        shot.setVisible(false);
        myplayer = new MijnComponent(player.getImageString(), player.x, player.y);
        myammo = new MijnComponent(shot.getImageString(), shot.x, shot.y);
        scene.add(myammo);
        scene.add(myplayer);
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
        
        myplayer.setLocation(player.x, player.y);
        myammo.setLocation(shot.x, shot.y);
        player.x += player.keyPressed(e.getCode());
        player.x = Boundaries(player.x, java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
        if(e.getType() == KeyEvent.KEY_PRESSED)
        {
            switch(e.getCode())
            {
                case org.havi.ui.event.HRcEvent.VK_SPACE:
                    shot.setVisible(true);
                    shot.x = player.x;
                    shot.y = player.y - Player_shoot_height;
                    break;
            }
        }
    }
}
