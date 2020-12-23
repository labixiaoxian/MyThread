package threadcoreknowledge.createthread;

/**
 * Created by XiaoXian on 2020/7/9.
 * 用Thread方法创建线程
 */
public class ThreadStyle extends Thread {
    @Override
    public void run() {
        System.out.println("用Thread方法实现线程");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}
