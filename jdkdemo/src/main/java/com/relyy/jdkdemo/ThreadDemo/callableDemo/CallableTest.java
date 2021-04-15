package com.relyy.jdkdemo.ThreadDemo.callableDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-03-19
 */
public class CallableTest implements Callable<Integer> {
    Integer sum = 0;
    @Override
    public Integer call() throws Exception {

        System.out.println("call子线程启动-------------");
        Thread.sleep(2000);
        for (int i = 0; i < 5000; i++) {
            sum = sum+i;
        }
        System.out.println("call子线程结束-------------");
        return sum;
    }

    public static void main(String[] args) {
        try{
            ExecutorService es = Executors.newSingleThreadExecutor();

            CallableTest callableTest = new CallableTest();

            Future<Integer> future = es.submit(callableTest);

            es.shutdown();

            Thread.sleep(2000);
            System.out.println("主线程执行其他任务");

            if (null != future.get()) {
                System.out.println("子线程计算结果为----"+future.get());
            }else {
                System.out.println("子线程计算结果还未完成！");
            }


        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("主线程在执行完成");
    }
}
