package threadcoreknowledge.createthread.wrongways;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by XiaoXian on 2020/9/5.
 */
public class DemoTimerTask {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },1000,1000);
    }
}
