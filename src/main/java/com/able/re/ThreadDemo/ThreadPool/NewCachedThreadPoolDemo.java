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

        int p = Runtime.getRuntime().availableProcessors();
        //ExecutorService threadPool = Executors.newCachedThreadPool();
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        long l = System.currentTimeMillis();
        for (int i = 0; i<10; i++){
            final int task = i;
            System.out.println(i+"----------"+System.currentTimeMillis());

            //为每个任务创建线程
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名字： " + Thread.currentThread().getName() +  "  任务名为： "+task);
                    try{
                        TimeUnit.SECONDS.sleep(10);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("线程名字： " + Thread.currentThread().getName() +  "  任务名为： "+task+"执行结束");
                }
            });
        }
        System.out.println("耗时-----"+(System.currentTimeMillis() - l));
        threadPool.shutdown();
    }
}
