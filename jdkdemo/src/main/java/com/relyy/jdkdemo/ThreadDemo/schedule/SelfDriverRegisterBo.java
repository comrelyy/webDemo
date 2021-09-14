package com.relyy.jdkdemo.ThreadDemo.schedule;

public class SelfDriverRegisterBo<P,R> {
    private Long warehouseId;

    private String zoneCode;

    private String schedulerName;

    private String selfDriverName;

    private SelfDriverMode selfDriverMode;

    private int intervalNo;

    private ISchedulerService service;

    private ISchedulerSelfDriver<P, R> selfDriver;

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getSchedulerName() {
        return schedulerName;
    }

    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    public String getSelfDriverName() {
        return selfDriverName;
    }

    public void setSelfDriverName(String selfDriverName) {
        this.selfDriverName = selfDriverName;
    }

    public SelfDriverMode getSelfDriverMode() {
        return selfDriverMode;
    }

    public void setSelfDriverMode(SelfDriverMode selfDriverMode) {
        this.selfDriverMode = selfDriverMode;
    }

    public int getIntervalNo() {
        return intervalNo;
    }

    public void setIntervalNo(int intervalNo) {
        this.intervalNo = intervalNo;
    }

    public ISchedulerService getService() {
        return service;
    }

    public void setService(ISchedulerService service) {
        this.service = service;
    }

    public ISchedulerSelfDriver<P, R> getSelfDriver() {
        return selfDriver;
    }

    public void setSelfDriver(ISchedulerSelfDriver<P, R> selfDriver) {
        this.selfDriver = selfDriver;
    }
}
