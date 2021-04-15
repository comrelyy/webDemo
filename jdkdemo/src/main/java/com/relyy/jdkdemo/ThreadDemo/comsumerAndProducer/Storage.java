package com.relyy.jdkdemo.ThreadDemo.comsumerAndProducer;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-03-14
 */
public class Storage {

    BlockingQueue<UserVideoStatistics> queues = new LinkedBlockingQueue<>(200);

    /**
     * 产品入库
     * @param list
     * @throws InterruptedException
     */
    public void push(List<UserVideoStatistics> list) throws InterruptedException{

        for (UserVideoStatistics userVideoStatistics : list) {
            queues.put(userVideoStatistics);
        }
    }

    /**
     * 产品出库
     * @return
     * @throws InterruptedException
     */
    public UserVideoStatistics pop() throws InterruptedException{
        return queues.poll(10, TimeUnit.SECONDS);
    }


}
