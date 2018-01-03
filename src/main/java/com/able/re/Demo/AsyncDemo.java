package com.able.re.Demo;

public class AsyncDemo {

    public static void main(String[] args){

        int i = 0;
        new Thread(){
            public void run(){
                System.out.println();
            }
        }.start();


        new Thread(){
            public void run(){
                System.out.println();
            }
        }.start();
    }

}
