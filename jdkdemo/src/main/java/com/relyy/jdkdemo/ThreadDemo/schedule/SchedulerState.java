package com.relyy.jdkdemo.ThreadDemo.schedule;

import java.util.HashMap;
import java.util.Map;

public enum SchedulerState {
    /** 服务刚创建 */
    NEW,
    /** 服务初始化中 */
    INIT,
    /** 服务初始化完成 */
    INIT_DONE,
    /** 服务自驱启动完成 */
    DRIVER_DONE,
    /** 服务就绪*/
    READY,
    /** 服务出错*/
    ERROR,
    /** 下线中 */
    OFFLINE_ING,
    /** 服务下线*/
    OFFLINE,
    ;

    private static Map<String, SchedulerState> states = new HashMap<>();

    static {
        for (SchedulerState state : values()) {
            states.put(state.name(), state);
        }
    }

    public static SchedulerState get(String name) {
        return states.get(name);
    }

}
