package threadcoreknowledge.synchronizedcode;

import java.util.concurrent.TimeUnit;

/**
 * Created by XiaoXian on 2020/10/24.
 */
public class SynchronizedStaticAndNormal8 implements Runnable {
    static SynchronizedStaticAndNormal8 instance = new SynchronizedStaticAndNormal8();

    @Override
    public void run() {
        if (Thread.currentThread().getName().equalsIgnoreCase("Thread-0")){
            mehtod1();
        }else {
            mehtod2();
        }
    }

    private synchronized static void mehtod1(){
        System.out.println("静态方法加锁形式1，我叫："+Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"执行完毕");
    }


    private synchronized void mehtod2(){
        System.out.println("非静态加锁形式2，我叫："+Thread.currentThread().getName());
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
