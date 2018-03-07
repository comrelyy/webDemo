package com.able.re.ThreadDemo.ThreadPool;

import java.util.concurrent.*;

/**
 * Created by relyy on 2018/3/5.
 */
public class RejectDemo {

    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis()+":thread Id :"+Thread.currentThread().getId());

            try{
               Thread.sleep(100);
            }catch(Exception e){
             e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)throws Exception {
        MyTask task = new MyTask();
        //自定义拒绝策略
//        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>(10),
//                Executors.defaultThreadFactory(),
//                new RejectedExecutionHandler() {
//                    @Override
//                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//                        System.out.println(r.toString() + " is discard");
//                    }
//                });
        //自定义线程创建
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setDaemon(true);
                        System.out.println("create" + t);
                        return t;
                    }
                });

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            es.submit(task);
        }
        Thread.sleep(200);
    }
}
