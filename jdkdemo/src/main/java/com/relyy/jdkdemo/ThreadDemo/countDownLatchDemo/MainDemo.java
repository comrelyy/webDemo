package com.relyy.jdkdemo.ThreadDemo.countDownLatchDemo;

import com.relyy.jdkdemo.clone.VoDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/8/30
 */
public class MainDemo {

    public static void main(String[] args) {
        List<VoDemo> voDemos = new ArrayList<VoDemo>();
        voDemos.add(new VoDemo("2"));
        voDemos.add(new VoDemo("3"));
        voDemos.add(new VoDemo("4"));
        voDemos.add(new VoDemo("5"));
        voDemos.add(new VoDemo("6"));
        voDemos.add(new VoDemo("7"));
        voDemos.add(new VoDemo("8"));
        voDemos.add(new VoDemo("9"));
        voDemos.add(new VoDemo("10"));
        voDemos.add(new VoDemo("11"));
        voDemos.add(new VoDemo("12"));
        voDemos.add(new VoDemo("13"));
        voDemos.add(new VoDemo("14"));
        //System.out.println("执行前："+voDemos.toString());
        long time1 = System.currentTimeMillis();
        System.out.println("执行时间："+time1);
        CountDownLatch countDownLatch = new CountDownLatch(voDemos.size());

        ExecutorService executorService = Executors.newFixedThreadPool(voDemos.size());
        for (VoDemo voDemo : voDemos) {
            Integer count = 0;

            Future<Integer> submit = executorService.submit(new Runnable() {
                @Override
                public void run() {
                    String name = voDemo.getName();
                    try {
                        long v = (long)(Math.random() * (10000 - 1000) + 1000);
                        Thread.sleep(v);
                        System.out.println("执行了-----"+v);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    voDemo.setId(Integer.parseInt(name));
                    if (voDemo.getId() == 3){
                        throw new NullPointerException();
                    }
                    countDownLatch.countDown();
                    System.out.println(countDownLatch.getCount());
                }
            }, count);

        }

        try {
            System.out.println("等待子任务执行完成");
            countDownLatch.await();
            System.out.println("子任务执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("执行时间："+(System.currentTimeMillis()-time1));
        System.out.println("执行后："+voDemos.toString());


    }
}
