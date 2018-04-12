package com.able.re.designMode.strategy;

/**
 * Created by relyy on 2018/3/10.
 */
public class Vehicle {

    private TireStrategy tireStrategy;

    public void getRunMeans(String weather){
        if ("sun".equals(weather)){
            tireStrategy = new TireStrategyA();
        }else if ("rain".equals(weather)){
            tireStrategy = new TireStrategyB();
        }else if ("romatic".equals(weather)){
            tireStrategy = new TireStrategyC();
        }


    }

    public void run(){
        if (tireStrategy != null) {
            System.out.println(tireStrategy.toFitEnve().toString());
        }else {
            System.out.println("Notthing to user only for walk!");
        }

    }

}
