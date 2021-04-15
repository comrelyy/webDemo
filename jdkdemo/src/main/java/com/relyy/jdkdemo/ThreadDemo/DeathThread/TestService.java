package com.relyy.jdkdemo.ThreadDemo.DeathThread;

public class TestService{

    private Object obj1 = new Object();
    private Object obj2 = new Object();

    public void methodA(){

        synchronized (obj1){
            System.out.println("调用方法A,先获取到obj1对象监视器！");

            try {
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }

            synchronized (obj2){
                System.out.println("调用方法A，先获取到obj1对象监视器,后获取到obj2对象监视器！");
            }

        }




    }

    public void methodB(){
        synchronized (obj2){
            System.out.println("调用B方法，获取到obj2对象监视器！");

            synchronized (obj1){
                System.out.println("调用B方法，先获取到obj2，再获取obj1对象监视器！");
            }
        }

    }
}
