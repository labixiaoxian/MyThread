package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * Created by XiaoXian on 2020/10/8.
 * sleep方法不释放synchronized锁
 */
public class SleepDontReleaseMonitor implements Runnable {
    @Override
    public void run() {
        syn();
    }

    private synchronized void syn() {
        System.out.println("线程" + Thread.currentThread().getName() + "获得了monitor");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程" + Thread.currentThread().getName() + "退出同步代码块");
    }


    public static void main(String[] args) {
        SleepDontReleaseMonitor s = new SleepDontReleaseMonitor();
        new Thread(s).start();
        new Thread(s).start();
    }
}
