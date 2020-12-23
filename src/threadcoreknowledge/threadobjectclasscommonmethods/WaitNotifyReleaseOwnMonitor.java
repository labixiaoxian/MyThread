package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * Created by XiaoXian on 2020/8/7.
 * wait只释放当前的锁
 */
public class WaitNotifyReleaseOwnMonitor {

    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();


    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("ThreadA got resourceA lock.");
                    synchronized (resourceB) {
                        System.out.println("ThreadA got resourceB lock.");
                        try {
                            System.out.println("ThreadA releases resourceA lock.");
                            resourceA.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });


        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourceA) {
                    System.out.println("ThreadB got resourceA lock.");
                    System.out.println("ThreadB try to got resourceB lock.");
                    synchronized (resourceB) {
                        System.out.println("ThreadB got resourceB lock.");
                    }
                }
            }
        });

        threadA.start();
        threadB.start();

    }

}
