package com.relyy.jdkdemo.ThreadDemo.lockDemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by relyy on 2018/3/3.
 */
public class InterruptLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    /**
     * 控制加锁顺序，方便构造死锁
     * @param lock
     */
    public InterruptLock (int lock){
        this.lock = lock;
    }
    @Override
    public void run() {
        try{
            if(lock == 1){
                lock1.lockInterruptibly();//获取锁，除非当前线程是interrupted
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                lock2.lockInterruptibly();
            }else {
                lock2.lockInterruptibly();
                try{
                   Thread.sleep(500);
                }catch(Exception e){
                 e.printStackTrace();
                }
                lock1.lockInterruptibly();
            }
        }catch(Exception e){
         e.printStackTrace();
        }finally {
            //查询锁是否由当前线程持有
            if (lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId()+":线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        InterruptLock r1 = new InterruptLock(1);
        InterruptLock r2 = new InterruptLock(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        Thread.sleep(1000);

        t2.interrupt();
    }
}
