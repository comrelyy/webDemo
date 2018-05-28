package com.able.re.ThreadDemo.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 多线程 fork/join框架
 *
 * @author cairuirui
 * @create 2018-05-11
 */
public class ForkJoinDemo {

    private static final Integer MAX = 200;

    static class MyForkJoinTask extends RecursiveTask<Integer>{
        private Integer startValue;
        private Integer endValue;

        public MyForkJoinTask(Integer startValue, Integer endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        protected Integer compute() {

            if (endValue - startValue < MAX){
                System.out.println("开始计算部分：startValue:"+startValue+",endValue:"+endValue);
                Integer totalValue = 0;
                for (int index = this.startValue; index <= this.endValue; index++){
                        totalValue += index;
                }
                return totalValue;
            }else {
                MyForkJoinTask subTask1 = new MyForkJoinTask(this.startValue, (this.startValue+this.endValue)/2);
                subTask1.fork();
                MyForkJoinTask subTask2 = new MyForkJoinTask((this.startValue+this.endValue)/2+1,this.endValue);
                subTask2.fork();
                return subTask1.join() + subTask2.join();
            }
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> taskFuture = pool.submit(new MyForkJoinTask(1,10001));
        try{
            Integer result = taskFuture.get();
            System.out.println("result:"+result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
