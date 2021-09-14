package com.relyy.jdkdemo.ThreadDemo;

public class JoinDemo {
    public volatile static  int i = 0;

    public static class AddThread extends Thread{

        @Override
        public void run() {
            for (; i < 10000; i++) {
                System.out.println(i+":::"+Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) throws Exception{
        AddThread addThread = new AddThread();
        addThread.start();
        addThread.join();
        System.out.println(i+":::"+Thread.currentThread().getName());
    }

}
