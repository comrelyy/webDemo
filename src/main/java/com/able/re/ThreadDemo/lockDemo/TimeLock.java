package com.able.re.ThreadDemo.lockDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by relyy on 2018/3/3.
 */
public class TimeLock implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        try{
           if (lock.tryLock(5, TimeUnit.SECONDS)){
               Thread.sleep(6000);
           }else {
               System.out.println("get lock failed");
           }
        }catch(Exception e){
         e.printStackTrace();
        }finally{
            if (lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args){
        TimeLock t0 = new TimeLock();
        Thread t1 = new Thread(t0);
        Thread t2 = new Thread(t0);
        t1.start();
        t2.start();
    }
}
