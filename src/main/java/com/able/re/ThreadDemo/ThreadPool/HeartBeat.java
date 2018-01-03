package com.able.re.ThreadDemo.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 使用newScheduledThreadPool来模拟心跳机制
 *
 * @author cairuirui
 * @date 2017-12-05
 */
public class HeartBeat {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("-----------------heartbeat");
            }
        };

        //5秒后执行，之后每3秒执行一次
        executor.scheduleAtFixedRate(task,5,3, TimeUnit.SECONDS);
    }
}
