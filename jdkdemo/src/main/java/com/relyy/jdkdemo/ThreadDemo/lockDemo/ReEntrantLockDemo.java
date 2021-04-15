package com.relyy.jdkdemo.ThreadDemo.lockDemo;

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
            /**
             * lock()
             * 1、sync.lock();  AQS的实现类，ReentrantLock的内部类
             * 2、sync.lock()的方法由子类NonfairSync.lock()来实现（模板方法）
             * 3、compareAndSetState(0, 1) 返回true，将state设置为1，表示获取到cpu执行权，结束；
             * 4、如果没有获取到cpu执行权 AQS.acquire()方法
             * 5、调用NonfairSync.tryAcquire()方法，其实现是sync.nonfairTryAcquire()方法
             *      方法中进行了是否重入的判断，通过state的值来判断锁重入次数，获取锁成功返回ture
             * 6、AQS.addWaiter() 在当前线程和给定的模式下，创建一个队列
             * 7、通过自旋+CAS的方式获取锁，否则会被挂起
             *
             */
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
