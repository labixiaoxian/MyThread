package threadcoreknowledge.synchronizedcode;

import java.util.concurrent.TimeUnit;

/**
 * Created by XiaoXian on 2020/10/24.
 */
public class SynchronizedClassClass5 implements Runnable {

    static SynchronizedClassStatic4 instance1 = new SynchronizedClassStatic4();
    static SynchronizedClassStatic4 instance2 = new SynchronizedClassStatic4();

    @Override
    public void run() {
        try {
            mehtod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void mehtod() throws InterruptedException {
        synchronized (SynchronizedClassClass5.class) {
            System.out.println("我是类锁之代码块形式（*.class）:"+Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName()+"执行完毕");
        }
    }


    public static void main(String[] args) {
        Thread thread1 = new Thread(instance1);
        Thread thread2 = new Thread(instance2);
        thread1.start();
        thread2.start();
        while(thread1.isAlive()||thread2.isAlive()){

        }
        System.out.println("finish......");
    }
}
