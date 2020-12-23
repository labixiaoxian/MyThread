package threadcoreknowledge.createthread.wrongways;

/**
 * Created by XiaoXian on 2020/9/5.
 */
public class Lambda {
    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
