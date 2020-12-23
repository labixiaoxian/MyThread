package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * Created by XiaoXian on 2020/8/6.
 * 展示wait和notify的基本用法
 * wait释放锁
 */
public class Wait {

    public static Object object = new Object();

    static class Thread1 extends Thread {

        @Override
        public void run() {
           synchronized (object) {
               System.out.println(Thread.currentThread().getName()+"开始执行了");
               try {
                   object.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread().getName()+"获得了锁");
           }
        }
    }

    static class Thread2 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                object.notify();
                System.out.println(Thread.currentThread().getName()+"调用了notify()方法");
            }
        }
    }

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }

}
