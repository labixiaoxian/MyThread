package threadcoreknowledge.startthread;

/**
 * Created by XiaoXian on 2020/7/28.
 * 调用start方法和run方法作比较
 */
public class StartAndRunMethod {
    public static void main(String[] args) {
        Runnable runnable = () ->{
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run();

        new Thread(runnable).start();
    }
}
