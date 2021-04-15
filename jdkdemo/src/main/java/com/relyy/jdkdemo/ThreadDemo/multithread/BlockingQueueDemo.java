package com.relyy.jdkdemo.ThreadDemo.multithread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Random;

/**
 * 阻塞队列的简单实现
 *
 * @author cairuirui
 * @date 2017-11-23
 */
public class BlockingQueueDemo {

    protected final Logger log = LoggerFactory.getLogger(BlockingQueueDemo.class);

    private LinkedList<Object> queueList = new LinkedList<Object>();

    private int limit = 10;

    public BlockingQueueDemo(int limit){
        this.limit = limit;
    }

    public synchronized void put(Object item) throws InterruptedException{

        while (this.queueList.size() == this.limit){
            wait();
        }

        this.queueList.add(item);
        log.debug("添加元素后:"+this.queueList.size());
        //System.out.println("添加元素后："+this.queueList.size());
        notifyAll();
    }

    public synchronized void take() throws InterruptedException{

        while (this.queueList.size() == 0){
            wait();
        }
        this.queueList.remove(0);
        log.info("删除元素后:"+this.queueList.size());
        //System.out.println("删除元素后："+this.queueList.size());
        notifyAll();
    }

    public static void main(String[] args) {
        final BlockingQueueDemo demo = new BlockingQueueDemo(20);

        new Thread(){
            @Override
            public void run(){
                try{
                    while(true) {
                        demo.take();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                Random random = new Random();
                int item = random.nextInt(50)%(50-0+1) + 0;
                try{
                    while(true) {
                        demo.put(item);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
