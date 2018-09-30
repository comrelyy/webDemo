package com.able.re.ThreadDemo;

public class RunDemo {

    public static void main(String[] args) throws Exception{

        MyThread1 t1 = new MyThread1("A");
        //MyThread1 t2 = new MyThread1("B");
//        MyThread1 t3 = new MyThread1("C");
//
        t1.start();

        Thread.sleep(20);
        t1.interrupt();
        System.out.println("是否已中断："+t1.getName()+"--"+t1.isInterrupted());
        //t2.start();
//        t3.start();
//
//        MyThread2 myThread = new MyThread2();
//        Thread p1 = new Thread(myThread,"甲");
//        //Thread p2 = new Thread(myThread,"乙");
//        //Thread p3 = new Thread(myThread,"丙");
//       // Thread p4 = new Thread(myThread,"丁");
//        //Thread p5 = new Thread(myThread,"戊");
//        p1.start();
//        p1.interrupt();
//        //p2.start();
//        //p3.start();
//        //p4.start();
//        //p5.start();




    }
}
