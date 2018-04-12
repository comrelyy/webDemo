package com.able.re.designMode.strategy;

/**
 * Created by relyy on 2018/3/10.
 */
public class TireStrategyC implements TireStrategy {
    @Override
    public Tire toFitEnve() {
        return new Tire(2,"自行车专用","朝阳");
    }
}
