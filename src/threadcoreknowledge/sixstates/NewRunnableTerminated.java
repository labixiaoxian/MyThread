package threadcoreknowledge.sixstates;

/**
 * Created by XiaoXian on 2020/8/6.
 *展示线程的new、runnable、terminated状态
 */
public class NewRunnableTerminated implements Runnable{
    @Override
    public void run() {
        for (int i=0;i < 1000;i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        //打印出new状态
        System.out.println(thread.getState());
        thread.start();

        System.out.println(thread.getState());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());
    }
}
