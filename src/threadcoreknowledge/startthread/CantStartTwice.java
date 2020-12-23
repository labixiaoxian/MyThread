package threadcoreknowledge.startthread;

/**
 * Created by XiaoXian on 2020/7/28.
 */
public class CantStartTwice {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }
}
