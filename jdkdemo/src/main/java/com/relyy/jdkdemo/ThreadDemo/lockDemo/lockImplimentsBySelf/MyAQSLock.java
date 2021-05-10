package com.relyy.jdkdemo.ThreadDemo.lockDemo.lockImplimentsBySelf;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * AQS：AbstractQueuedSynchronizer 队列同步器，是一个抽象类，
 * 其子类一般会被定义为一个内部类，经典实现是 ReentrantLock类
 *
 * @author cairuirui
 * @create 2018/9/3
 */
public class MyAQSLock implements Lock {

    private final MyAQS myAQS = new MyAQS();

    private static class MyAQS extends AbstractQueuedSynchronizer{

        @Override
        protected boolean tryAcquire(int arg) {
            int state = getState();
            if (state == 0){
                if(compareAndSetState(0,arg)){
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            }else if(Thread.currentThread() == getExclusiveOwnerThread()) {
                setState(state + 1);
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if (Thread.currentThread() != getExclusiveOwnerThread()) {
                return false;
            }
            int state = getState() - arg;
            setState(state);
            if (state == 0){
                setExclusiveOwnerThread(null);
                return true;
            }
            return false;
        }

        @Override
        protected int tryAcquireShared(int arg) {
            return super.tryAcquireShared(arg);
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            return super.tryReleaseShared(arg);
        }

        @Override
        protected boolean isHeldExclusively() {
            return super.isHeldExclusively();
        }

        Condition newCondition(){
            return new ConditionObject();
        }
    }

    public void MyAQSLock(){

    }

    @Override
    public void lock() {
        myAQS.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        myAQS.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return myAQS.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return myAQS.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        myAQS.release(1);
    }

    @Override
    public Condition newCondition() {
        return myAQS.newCondition();
    }
}
