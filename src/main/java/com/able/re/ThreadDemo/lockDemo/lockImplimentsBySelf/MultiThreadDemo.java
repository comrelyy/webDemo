package com.able.re.ThreadDemo.lockDemo.lockImplimentsBySelf;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/9/3
 */
public class MultiThreadDemo {
    private int value = 0;

   // Lock lock = new ReentrantLock();
   Lock lock = new MyLock();
    public int getValue(){

        lock.lock();
        int a = value++;
        lock.unlock();
        return a;
    }

    public synchronized void a(){
        lock.lock();
        System.out.println("a执行了");
        b();
        lock.unlock();
    }

    public synchronized void b(){
        lock.lock();
        System.out.println("b执行了");
        lock.unlock();
    }

    public static void main(String[] args) {
        MultiThreadDemo multiThreadDemo = new MultiThreadDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    multiThreadDemo.a();
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    System.out.println(multiThreadDemo.getValue() + "--" + Thread.currentThread().getName());
//                    try {
//                        Thread.sleep(300);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    System.out.println(multiThreadDemo.getValue() + "--" + Thread.currentThread().getName());
//                    try {
//                        Thread.sleep(300);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
    }
}
