package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * Created by XiaoXian on 2020/8/8.
 */
public class WaitNotifyPrintOddEvenWait implements Runnable{

    private static int count;

    private static Object lock = new Object();

    @Override
    public void run() {
        while (count <=100){
            //打印
            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + ":" + count++);
                //唤醒其他线程
                lock.notifyAll();
                if (count <= 100){
                    try {
                        //释放锁，进入阻塞
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
    }

    public static void main(String[] args) {
        new Thread(new WaitNotifyPrintOddEvenWait(),"偶数").start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new WaitNotifyPrintOddEvenWait(),"奇数").start();
    }

}
