package threadcoreknowledge.synchronizedcode;

import java.util.concurrent.TimeUnit;

/**
 * Created by XiaoXian on 2020/10/24.
 */
public class SynchronizedObjectCodeBlock2 implements Runnable {

    static SynchronizedObjectCodeBlock2 instance = new SynchronizedObjectCodeBlock2();
    Object lock1 = new Object();
    Object lock2  = new Object();

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println("我是lock1，我叫"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"lock1部分执行完毕");
        }

        synchronized (lock2) {
            System.out.println("我是lock2，我叫"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"lock2部分执行完毕");
        }
    }


    public static void main(String[] args) {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {

        }
        System.out.println("finish.....");
    }
}
