package threadcoreknowledge.sixstates;

import java.util.concurrent.TimeUnit;

/**
 * Created by XiaoXian on 2020/8/6.
 */
public class BlockedWaitingTimedWaiting implements Runnable {
    @Override
    public void run() {
        syn();
    }

    private synchronized void syn(){
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BlockedWaitingTimedWaiting runnable = new BlockedWaitingTimedWaiting();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出Time_waiting状态，正在执行Thread.sleep(1000)
        System.out.println(thread1.getState());
        //打印出blocked状态，thread2想拿到sync()的锁
        System.out.println(thread2.getState());
        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出waiting状态，因为thread1正在执行wait()
        System.out.println(thread1.getState());
    }
}
