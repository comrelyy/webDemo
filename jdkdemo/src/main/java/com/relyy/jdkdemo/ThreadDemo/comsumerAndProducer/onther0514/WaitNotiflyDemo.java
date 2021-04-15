package com.relyy.jdkdemo.ThreadDemo.comsumerAndProducer.onther0514;

import java.util.LinkedList;

public class WaitNotiflyDemo {

    //private final Object BLOCkING_Lock = new Object();
    private final int cap;
    private final LinkedList<String> queue = new LinkedList<>();

    public WaitNotiflyDemo(int cap) {
        this.cap = cap;
    }

    public synchronized void increase() {
        while (queue.size() == cap) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.offer("a");
        System.out.println("生成了a");
        notifyAll();
    }

    public synchronized void dcrease() {
        while (queue.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费了"+queue.poll());
        notifyAll();
    }

    public static void main(String[] args) {
        WaitNotiflyDemo demo = new WaitNotiflyDemo(10);
        Consumer consumer1 = new Consumer(demo);
        Consumer consumer2 = new Consumer(demo);
        Producer producer1 = new Producer(demo);
        Producer producer2 = new Producer(demo);
        new Thread(consumer1).start();
        new Thread(consumer2).start();
        new Thread(producer1).start();
        new Thread(producer2).start();

    }

}
class Consumer implements Runnable{
    private WaitNotiflyDemo demo;
    public Consumer(WaitNotiflyDemo demo){
        this.demo = demo;
    }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                demo.dcrease();
            }
        }
}

class Producer implements Runnable{

    private WaitNotiflyDemo demo;
    public Producer(WaitNotiflyDemo demo){
        this.demo = demo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.increase();
        }
    }
}
