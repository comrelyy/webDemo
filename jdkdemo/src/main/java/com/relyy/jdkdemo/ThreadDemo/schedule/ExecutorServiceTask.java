package com.relyy.jdkdemo.ThreadDemo.schedule;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ExecutorServiceTask extends Thread{

    private static final long INTERVAL = 50L;

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private AtomicLong cycles = new AtomicLong();

    private final Map<ISchedulerService, List<SelfDriverTask>> selfDriversMap = Maps.newHashMap();

    @Override
    public void run() {
        while(true) {
            // 当前轮次
            long times = cycles.incrementAndGet();
            readWriteLock.readLock().lock();
            //log.debug("readWriteLock lock: ExecutorServiceTask run");

            try {
                for (Map.Entry<ISchedulerService, List<SelfDriverTask>> entry : selfDriversMap.entrySet()) {
                    // 服务已下线,跳过自驱
                    if (Objects.equals(entry.getKey().getState(), SchedulerState.OFFLINE)) {
                        continue;
                    }

                    // 服务正在下线
                    if (Objects.equals(entry.getKey().getState(), SchedulerState.OFFLINE_ING)) {
                        // 判断是否该服务所有自驱都已下线
                        boolean allDriverStopped = true;
                        for (SelfDriverTask selfDriverTask : entry.getValue()) {
                            if (Objects.equals(selfDriverTask.getDriverState(), DriverState.RUNNING)) {
                                allDriverStopped = false;
                                break;
                            }
                        }
                        // 所有自驱都已下线,服务置为下线
                        if (allDriverStopped) {
                            entry.getKey().setState(SchedulerState.OFFLINE);
                        }
                        continue;
                    }

                    // 服务未ready,跳过自驱
                    if (!Objects.equals(entry.getKey().getState(), SchedulerState.READY)) {
                        continue;
                    }

                    entry.getValue().forEach(task -> pollSelfDriverTask(task, times));
                }
                Thread.sleep(INTERVAL);
            } catch (Exception e) {
                //log.error("exception.", e);
            }
            finally {
                readWriteLock.readLock().unlock();
                //log.debug("readWriteLock unlock: ExecutorServiceTask run");

            }
        }
    }

    /**
     * 自驱调度轮询
     * @param selfDriverTask selfDriverTask
     */
    private void pollSelfDriverTask(SelfDriverTask selfDriverTask, long cycle) {
        // 轮询自驱能否执行
        if(selfDriverTask.executeAble(cycle)) {
            // 提交执行
            SchedulerLoader.applyExecutorPool(selfDriverTask.getPoolName()).execute(selfDriverTask);
        }
    }

    /**
     * 添加自驱调度
     * @param selfDriverTask selfDriverTask
     */
    public void add(SelfDriverTask selfDriverTask) {
        readWriteLock.writeLock().lock();
        //log.debug("readWriteLock lock: ExecutorServiceTask add");

        try {
            selfDriversMap.computeIfAbsent(selfDriverTask.getService(), service -> selfDriversMap.put(service,
                    Lists.newArrayList()));
            selfDriversMap.get(selfDriverTask.getService()).add(selfDriverTask);
        }
        finally {
            readWriteLock.writeLock().unlock();
            //log.debug("readWriteLock unlock: ExecutorServiceTask add");

        }
    }
}
