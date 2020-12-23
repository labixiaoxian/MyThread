package threadcoreknowledge.synchronizedcode;

import java.util.concurrent.TimeUnit;

/**
 * Created by XiaoXian on 2020/10/24.
 */
public class SynchronizedClassStatic4 implements Runnable {

    static SynchronizedClassStatic4 instance1 = new SynchronizedClassStatic4();
    static SynchronizedClassStatic4 instance2 = new SynchronizedClassStatic4();

    @Override
    public void run() {
        method();
    }

    public static synchronized void method(){
        System.out.println("类锁之静态方法锁形式，我叫："+Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"执行完毕");
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
