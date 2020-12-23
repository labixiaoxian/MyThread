package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * Created by XiaoXian on 2020/10/11.
 */
public class CurrentThread implements Runnable {

    public static void main(String[] args) {
        new CurrentThread().run();
        new Thread(new CurrentThread()).start();
        new Thread(new CurrentThread()).start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
