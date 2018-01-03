package com.able.re.ThreadDemo.ThreadPool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Executor的生命周期
 *
 * @author cairuirui
 * @date 2017-12-05
 */
public class ExecutorLifeCycle {

    public static void submitDemo() throws ExecutionException,InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "call result";
            }
        });

        System.out.println("任务执行结果："+future.get());

    }

    public static void completionServiceDemo() throws ExecutionException, InterruptedException{

        //创建10个线程
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletionService completionService = new ExecutorCompletionService(executor);
        for (int i = 0; i <10 ; i++) {
            final int result = i;
            completionService.submit(new Callable() {
                @Override
                public Object call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));
                    return result;
                }
            });
            System.out.println(completionService.take().get());
        }
    }

    public static void main(String[] args) throws ExecutionException,InterruptedException {
        //ExecutorLifeCycle.completionServiceDemo();
        ExecutorLifeCycle.submitDemo();
    }
}
