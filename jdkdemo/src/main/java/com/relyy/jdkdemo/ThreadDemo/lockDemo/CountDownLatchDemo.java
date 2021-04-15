package com.relyy.jdkdemo.ThreadDemo.lockDemo;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch是基于AQS的共享锁实现
 *
 * @author cairuirui
 * @create 2019/2/27
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
    }
}
