package com.relyy.jdkdemo.ThreadDemo.schedule;

public interface ISchedulerSelfDriver<P,R>{
    void init(Long warehouseId,String zoneCode);

    void register();

    P prepare();

    R executor(P request);

    boolean handle(R result);

    String getSelfDriverName();

    String getSchedulerName();

    Long interval();

    default boolean call(){
        return true;
    }


}
