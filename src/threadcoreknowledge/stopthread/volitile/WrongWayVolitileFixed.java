package threadcoreknowledge.stopthread.volitile;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by XiaoXian on 2020/8/3.
 */
public class WrongWayVolitileFixed {
    public static void main(String[] args) {
        WrongWayVolitileFixed body = new WrongWayVolitileFixed();
        BlockingQueue blockingQueue = new ArrayBlockingQueue(10);
        Producer producer = body.new Producer(blockingQueue);
        Consumer consumer = body.new Consumer(blockingQueue);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        while (consumer.checkIsOk()){
            try {
                System.out.println(consumer.blockingQueue.take()+"被消费了");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //消费结束，生产者中断
        producerThread.interrupt();




    }

    class Producer implements Runnable{



        BlockingQueue blockingQueue;

        public Producer(BlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            int num = 0;
            try {
                while (num <= 50000 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0) {
                        blockingQueue.put(num);
                        System.out.println(num + "被生产出来");
                    }
                    num++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("生产结束");
            }
        }
    }

    class Consumer{
        BlockingQueue blockingQueue;

        public Consumer(BlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        public boolean checkIsOk(){
            if (Math.random() > 0.95){
                return false;
            }
            return true;
        }
    }

}


