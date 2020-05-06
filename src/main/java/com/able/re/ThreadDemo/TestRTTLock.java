package com.able.re.ThreadDemo;

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
             x += deltaX;
             y += delraY;
        }finally {
            writeLock.unlock();
        }
    }
}
