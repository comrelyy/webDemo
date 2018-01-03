package com.able.re.ThreadDemo.DeathThread;

public class DeathDemoTest {

    public static void main(String[] args){

        TestService service = new TestService();

        MyThread1 t1 = new MyThread1(service);
        t1.setName("t1");
        t1.start();

        MyThread2 t2 = new MyThread2(service);
        t2.setName("t2");
        t2.start();
    }
}
