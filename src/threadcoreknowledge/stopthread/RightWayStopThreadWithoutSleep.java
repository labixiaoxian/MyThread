package threadcoreknowledge.stopthread;

/**
 * Created by XiaoXian on 2020/7/28.
 * 不带有sleep的中断线程的写法
 */
public class RightWayStopThreadWithoutSleep implements Runnable {
    @Override
    public void run() {
        int num = 0;
        while (!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE/2){
            if (num % 10000 == 0){
                System.out.println(num + "是10000的倍数");
            }
            num++;
        }
        System.out.println("任务完成");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();

        Thread.sleep(1000);
        thread.interrupt();

    }
}
