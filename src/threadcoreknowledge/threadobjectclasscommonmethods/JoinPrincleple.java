package threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.concurrent.TimeUnit;

/**
 * Created by XiaoXian on 2020/10/11.
 */
public class JoinPrincleple {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            }
        });

        thread.start();

        System.out.println("开始等待所有子线程执行完毕");
        thread.join();
       /* synchronized (thread){
            thread.wait();
        }*/
        System.out.println("所有子线程执行完毕");
    }
}
