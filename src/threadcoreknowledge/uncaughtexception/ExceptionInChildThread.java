package threadcoreknowledge.uncaughtexception;

/**
 * Created by XiaoXian on 2020/11/2.
 */
public class ExceptionInChildThread implements Runnable {

    public static void main(String[] args) {
        new Thread(new ExceptionInChildThread()).start();

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
