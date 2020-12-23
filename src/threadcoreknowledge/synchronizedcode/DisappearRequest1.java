package threadcoreknowledge.synchronizedcode;

/**
 * Created by XiaoXian on 2020/10/21.
 */
public class DisappearRequest1 implements Runnable{
    static DisappearRequest1 instance = new DisappearRequest1();

    static int i;

    @Override
    public void run() {
        for (int j = 0;j<100000;j++){
            i++;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }
}
