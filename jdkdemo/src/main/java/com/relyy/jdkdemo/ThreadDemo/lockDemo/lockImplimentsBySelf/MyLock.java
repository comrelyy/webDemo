package com.relyy.jdkdemo.ThreadDemo.lockDemo.lockImplimentsBySelf;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自己实现Lock锁
 * 加锁/释放锁
 * 重入锁
 * @author cairuirui
 * @create 2018/9/3
 */
public class MyLock implements Lock {

    private boolean isLocked = false;
    private int lockCount = 0;
    private  Thread lockThread = null;
    @Override
    public synchronized void lock() {
        //第一个线程进来直接获取锁
        //第二的线程进来需要判断锁资源是否释放

        //可重入锁：需要判断是否是当前线程
        Thread thread = Thread.currentThread();
        while (isLocked && thread != lockThread){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        lockThread = thread;
        lockCount++;
    }
    @Override
    public synchronized void unlock() {
        Thread thread = Thread.currentThread();
        if (thread == lockThread){
            lockCount--;
            if (lockCount == 0) {
                notifyAll();
                isLocked = false;
            }
        }

    }
    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
