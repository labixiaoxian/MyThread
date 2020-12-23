package threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.concurrent.TimeUnit;

/**
 * Created by XiaoXian on 2020/10/11.
 */
public class JoinInterrupt {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    main.interrupt();
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    System.out.println("子线程停止");
                }
            }
        });

        thread.start();
        System.out.println("主线程等待子线程");
        try {
            thread.join();
        } catch (InterruptedException e) {
            thread.interrupt();
            System.out.println(Thread.currentThread().getName()+"主线程停止");
        }
        System.out.println("子线程执行完毕");
    }
}
