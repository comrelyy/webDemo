package com.relyy.jdkdemo.ThreadDemo.schedule;

public interface ISchedulerService {

    SchedulerState getState();

    void setState(SchedulerState state);

    String name();
}
