package com.able.re.ThreadDemo.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * newCachedThreadPool:创建可缓存的线程池，如果线程池中的线程在60秒未被使用就将被移除，
 * 在执行新的任务时，当线程池中有之前创建的可用线程就重用可用线程，否则就新建一条线程
 *
 * @author cairuirui
 * @date 2017-12-05
 */
public class NewCachedThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i<3; i++){
            final int task = i;
            TimeUnit.SECONDS.sleep(1);

            //为每个任务创建线程
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名字： " + Thread.currentThread().getName() +  "  任务名为： "+task);
                }
            });
        }
    }
}
