package threadcoreknowledge.uncaughtexception;

/**
 * Created by XiaoXian on 2020/11/2.
 */
public class UseOwnUncaughtExceptionHandler implements Runnable {
    public static void main(String[] args) {

        MyUncaughtExceptionHandler myUncaughtExceptionHandler = new MyUncaughtExceptionHandler("捕获器1");
        Thread.setDefaultUncaughtExceptionHandler(myUncaughtExceptionHandler);

            new Thread(new CantCatchDirectly(),"MyThread-1").start();
            new Thread(new CantCatchDirectly(),"MyThread-2").start();
            new Thread(new CantCatchDirectly(),"MyThread-3").start();
            new Thread(new CantCatchDirectly(),"MyThread-4").start();

    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
