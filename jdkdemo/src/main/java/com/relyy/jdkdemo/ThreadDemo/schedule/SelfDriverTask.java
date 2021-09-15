package com.relyy.jdkdemo.ThreadDemo.schedule;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class SelfDriverTask<P,R> extends Thread {

    /** 调度间隔(单位是时间片,时间片单位是50ms) */
    private final int intervalNo;

    /** 该自驱使用的调度线程池名 */
    private final String poolName;

    /** SchedulerService */
    private final ISchedulerService service;

    /** 自驱 */
    private final ISchedulerSelfDriver<P, R> selfDriver;

    /** 自驱任务状态 */
    private volatile DriverState driverState;

    /** 执行轮次计数器 */
    private AtomicLong cycles = new AtomicLong(0);

    SelfDriverTask(int intervalNo, ISchedulerService service, ISchedulerSelfDriver<P, R> selfDriver,
                   String poolName) {
        this.intervalNo = intervalNo;
        this.service = service;
        this.selfDriver = selfDriver;
        this.poolName = poolName;
        this.driverState = DriverState.STOPPED;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        try {
            if (SchedulerState.OFFLINE_ING == service.getState()) {
                //log.info(service.name() + " set to offline.");
                return;
            }

            if (SchedulerState.OFFLINE == service.getState()) {
                //log.info(service.name() + " offline.");
                return;
            }

            if (SchedulerState.READY != service.getState()) {
                //log.info(service.name() + " is not ready.");
                return;
            }

            if (!selfDriver.call()) {
                //log.info("no need to call selfDriver:" + selfDriver.getClass());
                return;
            }

            this.driverState = DriverState.RUNNING;

            P p = selfDriver.prepare();

            R r = selfDriver.executor(p);

            selfDriver.handle(r);

            long cost = System.currentTimeMillis() - start;
//            log.info("{} {} cycles:{} cost:{}.", selfDriver.getSchedulerName(), selfDriver.getSelfDriverName(),
//                    cycles.incrementAndGet(), cost);
        } catch (Exception e) {
            //log.error(service.name() + " self driver error.", e);
        } finally {
            this.driverState = DriverState.STOPPED;
        }
    }

    /**
     * 轮询能否调度
     * @return boolean
     */
    public boolean executeAble(long cycle) {
        // 轮询时间片到且STOPPED则返回true
        return !Objects.equals(driverState, DriverState.RUNNING) && ((cycle % intervalNo) == 0);
    }

    /**
     * 返回所属scheduler
     * @return ISchedulerService
     */
    public ISchedulerService getService() {
        return service;
    }

    /**
     * 返回使用的调度线程池名
     * @return poolName
     */
    public String getPoolName() {
        return poolName;
    }

    /**
     * 返回自驱状态
     * @return driverState
     */
    public DriverState getDriverState() {
        return driverState;
    }
}
