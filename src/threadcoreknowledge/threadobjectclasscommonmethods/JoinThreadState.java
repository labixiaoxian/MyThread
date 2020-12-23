package threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.concurrent.TimeUnit;

/**
 * Created by XiaoXian on 2020/10/11.
 */
public class JoinThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread main = Thread.currentThread();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(main.getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        System.out.println("等待子线程执行完毕");
        thread.join();
        System.out.println("等待子线程执行完毕");
    }
}
