package com.relyy.jdkdemo.ThreadDemo;

public class MyThread2 extends Thread{

    private int count = 100;

    @Override
   synchronized public void run(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //super.run();
        //while (count > 0){  //去掉循环的目的是因为同步后只会有一个线程调用，去掉之后可以出现线程争用的情况
            count--;
            System.out.println("由"+this.currentThread().getName()+"计算得, count="+count);
        //}
    }
}
