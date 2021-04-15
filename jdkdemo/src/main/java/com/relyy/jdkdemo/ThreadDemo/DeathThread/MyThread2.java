package com.relyy.jdkdemo.ThreadDemo.DeathThread;

public class MyThread2 extends Thread {

    private TestService service;

    public MyThread2(TestService service){
        this.service = service;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" begin........" + System.currentTimeMillis());

        service.methodB();

//        service.methodA();

        System.out.println(Thread.currentThread().getName()+" end........" + System.currentTimeMillis());

    }
}
