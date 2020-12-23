package threadcoreknowledge.synchronizedcode;

/**
 * Created by XiaoXian on 2020/10/24.
 */
public class SynchronizedRecursion10 {

    int a = 0 ;

    public static void main(String[] args) {
        SynchronizedRecursion10 synchronizedRecursion10 = new SynchronizedRecursion10();
        synchronizedRecursion10.method();
    }

    private synchronized void method() {
        System.out.println("a的值为：" + a);
        if (a==0){
            a++;
            method();
        }
    }
}
