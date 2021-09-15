package com.relyy.jdkdemo.ThreadDemo.schedule;

public abstract class AbstractSchedulerSelfDriver<P,R> implements ISchedulerSelfDriver<P, R> {
    @Override
    public void init(Long warehouseId, String zoneCode) {
        //获取仓库及库区上下文加载
        return;
    }

    @Override
    public void register() {

    }


}
