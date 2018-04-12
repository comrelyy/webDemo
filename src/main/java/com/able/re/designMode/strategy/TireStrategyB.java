package com.able.re.designMode.strategy;

/**
 * Created by relyy on 2018/3/10.
 */
public class TireStrategyB implements TireStrategy {
    @Override
    public Tire toFitEnve() {
        return new Tire(4,"可以让你在雨雪天，拥有轻松的驾驶体验","普利司通");
    }
}
