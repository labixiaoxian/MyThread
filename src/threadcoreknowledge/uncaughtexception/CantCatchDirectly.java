package threadcoreknowledge.uncaughtexception;

/**
 * Created by XiaoXian on 2020/11/2.
 */
public class CantCatchDirectly implements Runnable {

    public static void main(String[] args) {
        try {
            new Thread(new CantCatchDirectly(),"MyThread-1").start();
            new Thread(new CantCatchDirectly(),"MyThread-2").start();
            new Thread(new CantCatchDirectly(),"MyThread-3").start();
            new Thread(new CantCatchDirectly(),"MyThread-4").start();
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
