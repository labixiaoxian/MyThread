package threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by XiaoXian on 2020/8/8.
 */
public class ProductConsumerModel {

    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage();
        Producer producer = new Producer(eventStorage);
        Consumer consumer = new Consumer(eventStorage);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

}


class Producer implements Runnable{

    EventStorage eventStorage;

    public Producer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @Override
    public void run() {
        for (int i = 0; i<100;i++){
            eventStorage.put();
        }
    }
}


class Consumer implements Runnable{

    EventStorage eventStorage;

    public Consumer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @Override
    public void run() {
        for (int i = 0; i<100;i++){
            eventStorage.take();
        }
    }
}

class EventStorage{
    int maxSize;

    LinkedList<Date> storage;

    public EventStorage() {
        this.maxSize = 10;
        this.storage = new LinkedList<>();
    }

    public synchronized void put(){
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.println("仓库里有了" + storage.size() + "个产品");
        notify();
    }


    public synchronized void take(){
        while (storage.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("拿到了" + storage.poll() + ",现在仓库还剩下" + storage.size());
        notify();
    }
}
