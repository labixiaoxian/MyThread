package threadcoreknowledge.synchronizedcode;

import java.util.concurrent.TimeUnit;

/**
 * Created by XiaoXian on 2020/10/24.
 */
public class SynchronizedObjectCodeBlock3 implements  Runnable {

    static SynchronizedObjectCodeBlock3 instance = new SynchronizedObjectCodeBlock3();

    @Override
    public void run() {
        mehtod();
    }

    private synchronized void mehtod(){
        System.out.println("对象锁之方法锁形式，我叫："+Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"执行完毕");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        while(thread1.isAlive()||thread2.isAlive()){

        }
        System.out.println("finish......");
    }
}
