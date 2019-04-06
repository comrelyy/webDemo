package com.able.re.ThreadDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2019/3/29
 */
public class ThreadLocalDemo implements Runnable{
   // private static final AtomicInteger nextId = new AtomicInteger(0);
    ThreadLocal<Integer> integerThreadLocal = new ThreadLocal()
   {
        @Override
        protected Object initialValue() {
            return 0;
        }
    };

    ThreadLocal<String> sThreadLocal = new ThreadLocal()
    {
        @Override
        protected Object initialValue() {
            return "a";
        }
    };
   // private static int i = 0;


    public static void main(String[] args) {
        ThreadLocalDemo t1 = new ThreadLocalDemo();
        ThreadLocalDemo t2 = new ThreadLocalDemo();
        ThreadLocalDemo t3 = new ThreadLocalDemo();
        ThreadLocalDemo t4 = new ThreadLocalDemo();
        new Thread(t1,"a").start();
        new Thread(t2,"b").start();
        new Thread(t3,"c").start();
        new Thread(t4,"d").start();
        //integerThreadLocal
        //integerThreadLocal.set(1);
       // new Thread().
    }

    @Override
    public void run() {
        while (true) {
            //i++;
            //nextId.getAndIncrement();
            integerThreadLocal.set(integerThreadLocal.get()+1);
            sThreadLocal.set(Thread.currentThread().getName());
            try{
             Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println(sThreadLocal.get()+"----------"+integerThreadLocal.get());
        }
    }
}
