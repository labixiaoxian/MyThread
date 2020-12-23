package threadcoreknowledge.stopthread;

/**
 * Created by XiaoXian on 2020/8/3.
 * 用stop停止线程，这是一种错误的停止线程的方法，他会使数据不安全，出现脏数据，多了或者少了，数据不一致。
 */
public class StopThread implements Runnable {
    @Override
    public void run() {
        //模拟连队领取弹药，以连队为单位，一共有5个连队，每个连队10个人
        for (int i =1;i <= 5;i++){
            System.out.println("连队" + i + "开始领取弹药");
            for (int j = 1;j <= 10;j++){
                System.out.println("士兵" + j + "领取弹药");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("连队" + i + "领取弹药完毕");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new StopThread());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();
    }
}
