package com.relyy.utils;

import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class MisUtils {

    /**
     * 创建线程池，
     * @param name 线程池名称
     * @param sz 大小
     * @return
     */
    public static TaskExecutor createTaskExecutor (String name, int sz) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(sz);
        executor.setMaxPoolSize(sz * 2);
        executor.setQueueCapacity(20);
        executor.setKeepAliveSeconds(60);

        //如果是调度runnable, 将最老的一个runnable 清除，  如果是其他的runnable ， 直接拒绝接受
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                if (r.getClass().getCanonicalName().toLowerCase().contains("bootstrap")) {
                    //调度线程不能被丢弃
                    if (!e.isShutdown()) {
                        Runnable old = e.getQueue().poll();
                        e.execute(r);
                        if (old != null) {
                            //log.warn("for receive job: " + r.getClass().getName() + ", rejectOldest: " + old.getClass().getName());
                        }
                    }
                } else {
                    //log.warn("reject " + r.getClass().getName());
                    super.rejectedExecution(r, e);
                }
            }
        });
        executor.setThreadFactory(new ThreadFactory() {
            private AtomicInteger counter = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(Thread.currentThread().getThreadGroup(), r, name + "-" + counter.getAndIncrement(), 0);
            }
        });
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }

    public static void doInTransaction(DataSourceTransactionManager transactionManager, Runnable callback) {
        DefaultTransactionDefinition transDefinition = new DefaultTransactionDefinition();
        transDefinition.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus transStatus = transactionManager.getTransaction(transDefinition);
        try {
            callback.run();
            transactionManager.commit(transStatus);
        } catch (Exception e) {
            transactionManager.rollback(transStatus);
            //log.error(e.getMessage(), e);
            //throw e;
        }
    }
}
