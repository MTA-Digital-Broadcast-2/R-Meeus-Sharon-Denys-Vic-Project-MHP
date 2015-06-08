package hellotvxlet;

import java.util.Random;
import java.util.TimerTask;

public class MyTimer extends TimerTask{
    
    HelloTVXlet xlet;
    
    public MyTimer(HelloTVXlet xlet){
       this.xlet = xlet;
    }
    
    public void run(){
        xlet.timerCallback();
    }
}
