package com.relyy.designpattern.strategy;

/**
 * Created by relyy on 2018/3/10.
 */
public class TireStrategyA implements TireStrategy {
    @Override
    public Tire toFitEnve() {
        return new Tire(4,"听说和太阳很配","米其林");
    }
}
