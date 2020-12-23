package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * Created by XiaoXian on 2020/8/8.
 */
public class WaitNotifyPrintOddEvenSyn {

    private static int count;

    private static Object lock = new Object();

    public static void main(String[] args) {
        //新建两个线程  奇数  偶数
          // 使用 syn锁 判断奇偶
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100){
                    synchronized (lock) {
                        if ((count & 1) == 0){
                            System.out.println(Thread.currentThread().getName()+":"+count++);
                        }
                    }
                }
            }
        },"偶数").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100){
                    synchronized (lock) {
                        if ((count & 1) == 1){
                            System.out.println(Thread.currentThread().getName()+":"+count++);
                        }
                    }
                }
            }
        },"奇数").start();
    }
}
