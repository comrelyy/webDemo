package com.able.re.ThreadDemo;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/10/14
 */
public class RunableDemo implements Runnable{
    @Override
    public void run(){
        System.out.println("实现Runnable接口，实现run方法,创建线程");
    }

    public static void main(String[] args){

        RunableDemo de = new RunableDemo();
        new Thread(de).start();
    }
}
