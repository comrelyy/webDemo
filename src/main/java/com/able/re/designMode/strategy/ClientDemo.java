package com.able.re.designMode.strategy;

/**
 * Created by relyy on 2018/3/10.
 */
public class ClientDemo {

    public static void main(String[] args) {
        String weather = "romatic";
       Vehicle vehicle = new Vehicle();

       vehicle.getRunMeans(weather);

       vehicle.run();
    }
}
