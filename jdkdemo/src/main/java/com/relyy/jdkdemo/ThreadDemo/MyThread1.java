package com.relyy.jdkdemo.ThreadDemo;

public class MyThread1 extends Thread {

    private int count = 50000;

    public MyThread1(String threadName){
        super();
        this.setName(threadName);
    }

    @Override
    public void run(){
        //super.run();
try{
    while (count > 0){
        if (Thread.interrupted()){
            System.out.println("已经停止了，我要退出了！");
            //break;
            throw new InterruptedException();
        }
        count--;

        System.out.println("由"+this.currentThread().getName()+
                "计算得, count="+count);
    }

    System.out.println("我还是被输出了，如果我是循环，将会继续执行");
}catch(Exception e){
    e.printStackTrace();
    System.out.println("我属于异常处理，被中断了");
}


    }
}
