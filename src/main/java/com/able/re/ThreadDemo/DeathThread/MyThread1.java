package com.able.re.ThreadDemo.DeathThread;

public class MyThread1 extends Thread {

    private TestService service;

    public MyThread1(TestService service){
        this.service = service;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" begin........" + System.currentTimeMillis());

        service.methodA();
//        try {
//            sleep(50000L);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        service.methodB();

        System.out.println(Thread.currentThread().getName()+" end........" + System.currentTimeMillis());

    }
}
