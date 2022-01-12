package com.relyy.jdkdemo.ThreadDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestRTTLock {

    private double x, y;

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    //读锁
    private Lock readLock = lock.readLock();
    //写锁
    private Lock writeLock = lock.writeLock();

    public double read(){
        //获取读锁
        readLock.lock();
        try{
            return Math.sqrt(x * x + y * y);
        }finally {
            readLock.unlock();
        }
    }

    public void move(double deltaX,double delraY){
        //获取写锁
        writeLock.lock();
        try{
            System.out.println("进入写锁-------------"+Thread.currentThread().getName());
             x += deltaX;
             y += delraY;
             readLock.lock();
            System.out.println(Thread.currentThread().getName()+"在写锁中进入读锁："+(x+y));
            System.out.println("释放写锁-----"+Thread.currentThread().getName());
            writeLock.unlock();
            Thread.sleep(5000L);
            readLock.unlock();
            System.out.println(Thread.currentThread().getName()+"释放读锁");
        }catch (Exception e){

        } finally {
//            System.out.println("释放写锁-----"+Thread.currentThread().getName());
//            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        TestRTTLock testRTTLock = new TestRTTLock();
        new Thread(() -> {
            testRTTLock.move(4,3);//虽然写锁降级成读锁，但是降级之后并不是共享的
        },"writeThread").start();
        new Thread(() -> {
            double read = testRTTLock.read();
            System.out.println("read方法读取结果.........."+read);
        },"readThread").start();

//        new Thread(() -> {
//            testRTTLock.move(6,8);
//        },"writeThread2").start();
    }
}
