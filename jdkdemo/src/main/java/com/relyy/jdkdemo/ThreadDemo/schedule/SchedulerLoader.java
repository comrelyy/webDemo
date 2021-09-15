package com.relyy.jdkdemo.ThreadDemo.schedule;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SchedulerLoader {

    private static final int SIZE = 1;

    private static final long KEEP_ALIVE_TIME = 0L;

    private static ExecutorServiceTask executorServiceTask;

    /**
     * 线程池
     * 整体单线程 <warehouseID, executor>
     * Scheduler单线程 <warehouseID-SchedulerName, executor>
     * 自驱实例单线程 <warehouseID-SchedulerName-SelfDriverName, executor>
     */
    private static Map<String, ExecutorService> executorServiceMap = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    public static boolean register(SelfDriverRegisterBo selfDriverRegisterBO) {
        String poolName;
        Long warehouseID = selfDriverRegisterBO.getWarehouseId();
        String zoneID = selfDriverRegisterBO.getZoneCode();
        String schedulerName = selfDriverRegisterBO.getSchedulerName();
        String selfDriverName = selfDriverRegisterBO.getSelfDriverName();
        // 匹配自驱模式
        switch (selfDriverRegisterBO.getSelfDriverMode()) {
            case GlobalSingleThread:
                poolName = warehouseID.toString();
                break;
            case SchedulerSingleThread:
                poolName = warehouseID + "-" + zoneID + "-" + schedulerName;
                break;
            case SelfDriverSingleThread:
                poolName = warehouseID + "-" + zoneID + "-" + schedulerName + "-" + selfDriverName;
                break;
            default:
                return false;
        }

        if (null == executorServiceTask) {
            executorServiceTask = new ExecutorServiceTask();
            executorServiceTask.start();
        }

        // 获取自驱对应的线程池调度
        applyExecutorPool(poolName);

        // 初始化自驱调度
        SelfDriverTask selfDriverTask = new SelfDriverTask(
                selfDriverRegisterBO.getIntervalNo(),
                selfDriverRegisterBO.getService(),
                selfDriverRegisterBO.getSelfDriver(),
                poolName
        );
        // 自驱调度 添加到 线程池调度
        executorServiceTask.add(selfDriverTask);

        return true;
    }

    /**
     * 获取对应线程池任务
     * @param poolName poolName
     * @return ExecutorServiceTask
     */
    public static synchronized ExecutorService applyExecutorPool(String poolName) {
        if(executorServiceMap.containsKey(poolName)) {
            return executorServiceMap.get(poolName);
        }

        // 初始化线程池
        ExecutorService singleThreadExecutor = new ThreadPoolExecutor(
                SIZE,
                SIZE * 2,
                KEEP_ALIVE_TIME,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        SecurityManager s = System.getSecurityManager();
                       ThreadGroup group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();


                       String poolName = "pool";

                        AtomicInteger threadNumber = new AtomicInteger(1);
                        AtomicInteger poolNumber = new AtomicInteger(1);

                        String namePrefix = poolName + "-" + poolNumber.getAndIncrement() + "-thread-";
                        Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
                        // 非守护线程
                        if (t.isDaemon()) {
                            t.setDaemon(false);
                        }
                        // 设置线程优先级
                        if (t.getPriority() != Thread.NORM_PRIORITY) {
                            t.setPriority(Thread.NORM_PRIORITY);
                        }

                        return t;
                    }
                },
                new ThreadPoolExecutor.AbortPolicy()
        );

        // 新线程池任务添加到线程池任务缓存中
        executorServiceMap.put(poolName, singleThreadExecutor);

        return singleThreadExecutor;
    }
}
