package threadcoreknowledge.stopthread.volitile;

/**
 * Created by XiaoXian on 2020/8/3.
 * 使用volitile的方法来停止线程，看似可行
 */
public class WrongWayVolitile implements Runnable{

    private volatile boolean cancle = false;

    @Override
    public void run() {
        int num = 0;
        while (num <= 500 && !cancle){
            if (num % 100 == 0){
                System.out.println(num + "是100的倍数");
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num++;
        }
    }

    public static void main(String[] args) {
        WrongWayVolitile wrongWayVolitile = new WrongWayVolitile();
        Thread thread = new Thread(wrongWayVolitile);
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wrongWayVolitile.cancle=true;
    }
}
