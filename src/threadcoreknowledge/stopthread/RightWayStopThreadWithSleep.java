package threadcoreknowledge.stopthread;

/**
 * Created by XiaoXian on 2020/7/28.
 * 带有sleep的中断线程的写法
 */
public class RightWayStopThreadWithSleep {

    public static void main(String[] args) {
        Runnable runnable = ()->{
            int num = 0;
            try {
                while (num < 500 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                }

                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };

        Thread thread = new Thread(runnable);
        thread.start();
        try {
            Thread.sleep(500);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
