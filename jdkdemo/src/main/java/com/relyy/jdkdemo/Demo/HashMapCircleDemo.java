package com.relyy.jdkdemo.Demo;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 模拟高并发情况下HashMap的死循环
 * 使用jdk1.7,1.8以后HashMap实现有很大改动
 * @author cairuirui
 * @create 2018-08-10
 */
public class HashMapCircleDemo extends Thread {

    static HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(2);
    static AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        while(count.get() < 100000){
            map.put(count.get(),count.get());
            count.incrementAndGet();
            System.out.println(count.get());
        }
    }

    public static void main(String[] args) {
            HashMapCircleDemo d1 = new HashMapCircleDemo();
            HashMapCircleDemo d2 = new HashMapCircleDemo();
            HashMapCircleDemo d3 = new HashMapCircleDemo();
            HashMapCircleDemo d4 = new HashMapCircleDemo();
            HashMapCircleDemo d5 = new HashMapCircleDemo();
            d1.start();
            d2.start();
            d3.start();
            d4.start();
            d5.start();
    }
}
