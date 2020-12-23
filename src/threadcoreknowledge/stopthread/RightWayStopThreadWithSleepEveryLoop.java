package threadcoreknowledge.stopthread;

/**
 * Created by XiaoXian on 2020/7/28.
 */
public class RightWayStopThreadWithSleepEveryLoop {
    public static void main(String[] args) {
        Runnable runnable = () ->{
            int num = 0;
            try {
                while (num < 5000) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    Thread.sleep(10);
                    num++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };

        Thread thread = new Thread(runnable);
        thread.start();
        try {
            Thread.sleep(5000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
