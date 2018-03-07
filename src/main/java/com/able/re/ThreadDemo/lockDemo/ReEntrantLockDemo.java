package com.able.re.ThreadDemo.lockDemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by relyy on 2018/3/3.
 */
public class ReEntrantLockDemo implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            lock.lock();
            try{
                i++;
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ReEntrantLockDemo tlock = new ReEntrantLockDemo();
        Thread t1 = new Thread(tlock);
        Thread t2 = new Thread(tlock);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(i);

    }
}
