package threadcoreknowledge.stopthread;

/**
 * Created by XiaoXian on 2020/7/29.
 */
public class RightWayStopThreadInProd implements Runnable {
    @Override
    public void run() {
        while (true && !Thread.currentThread().isInterrupted()){
            System.out.println("go");
            try {
                throeInMethod();
            } catch (InterruptedException e) {
                System.out.println("保存日志");
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }

    private void throeInMethod() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
