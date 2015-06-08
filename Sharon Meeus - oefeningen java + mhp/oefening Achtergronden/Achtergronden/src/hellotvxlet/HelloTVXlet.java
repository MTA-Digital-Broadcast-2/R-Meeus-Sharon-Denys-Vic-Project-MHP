package hellotvxlet;

import java.awt.event.KeyEvent;
import javax.tv.xlet.*;
import org.havi.ui.*;
import org.davic.resources.*;
import org.dvb.event.*;
import org.havi.ui.event.*;

public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, UserEventListener {

    
    private HScreen screen;
    private HBackgroundDevice bgDevice;
    private HBackgroundConfigTemplate bgTemplate;
    private HStillImageBackgroundConfiguration bgConfiguration;
    private HBackgroundImage bgimg1 = new HBackgroundImage("pizza_1.jpg");
    private HBackgroundImage bgimg2 = new HBackgroundImage("pizza_2.jpg");
    private HBackgroundImage bgimg3 = new HBackgroundImage("pizza_3.jpg");
    private HBackgroundImage bgimg4 = new HBackgroundImage("pizza_4.jpg");
    
    public void notifyRelease(ResourceProxy proxy){};
    public void release(ResourceProxy proxy){};
    public boolean requestRelease(ResourceProxy proxy, Object requestData){return false;}
    
    private int number_pizza = 1;
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        bgimg1.flush();
        bgimg2.flush();
        bgimg3.flush();
        bgimg4.flush();
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        screen = HScreen.getDefaultHScreen();
        
        bgDevice = screen.getDefaultHBackgroundDevice();
        
        if(bgDevice.reserveDevice(this))
        {
            System.out.println("BackgroundImage device has been reserverd");
        }
        else
        {
            System.out.println("Background image device cannot be reserved");
        }
        
        bgTemplate = new HBackgroundConfigTemplate();
        
        bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
        
        bgConfiguration = (HStillImageBackgroundConfiguration)bgDevice.getBestConfiguration(bgTemplate);
        
        try{
            bgDevice.setBackgroundConfiguration(bgConfiguration);
        }
        catch(java.lang.Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public void pauseXlet() {
    }

    public void startXlet() throws XletStateChangeException {
       bgimg1.load(this);
       bgimg2.load(this);
       bgimg3.load(this);
       bgimg4.load(this);
       
       EventManager manager = EventManager.getInstance();
        
        UserEventRepository repository = new UserEventRepository ("Pizza");
        
        repository.addKey(HRcEvent.VK_UP);
        repository.addKey(HRcEvent.VK_DOWN);
        repository.addKey(HRcEvent.VK_LEFT);
        repository.addKey(HRcEvent.VK_RIGHT);
        
        manager.addUserEventListener(this, repository);
    }

    public void LoadPizza(HBackgroundImageEvent e) {
        try{
            bgConfiguration.displayImage(bgimg1);
        }
        catch(Exception s)
        {
            System.out.println(s.toString());
        }
    }
    
    public void ChangePizza(int count){
        String image = "bgimg" + count;
  
        if(image.equals("bgimg1"))
        {
            try{
            bgConfiguration.displayImage(bgimg1);
            }
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        
        if(image.equals("bgimg2"))
        {
            try{
            bgConfiguration.displayImage(bgimg2);
            }
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        
        if(image.equals("bgimg3"))
        {
            try{
            bgConfiguration.displayImage(bgimg3);
            }
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        
        if(image.equals("bgimg4"))
        {
            try{
            bgConfiguration.displayImage(bgimg4);
            }
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        System.out.println("Image kan niet geladen worden");
    }

    public void userEventReceived(UserEvent e) {
        if(e.getType() == KeyEvent.KEY_PRESSED)
        {
            switch(e.getCode())
            {
                case HRcEvent.VK_UP:
                    number_pizza++;
                    break;
                case HRcEvent.VK_DOWN:
                    number_pizza--;
                    break;
                case HRcEvent.VK_LEFT:
                    number_pizza--;
                    break;
                case HRcEvent.VK_RIGHT:
                    number_pizza++;
                    break;
            }
            
            if(number_pizza < 1)
            {
                number_pizza = 4;
            }
            if(number_pizza > 4)
            {
                number_pizza = 1;
            }
            
            ChangePizza(number_pizza);
        }
    }

    public void imageLoaded(HBackgroundImageEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}