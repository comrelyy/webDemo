package com.relyy.designpattern.factorymethod;

import com.able.re.designmode.Car;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-03-12
 */
public class FactoryMethodDemo {

    public static void main(String[] args) {
        FactoryMethod fudeFactory = new FudeFactory();
        Car car = fudeFactory.createCar();
        car.printName();
        FactoryMethod bmwFactory = new BMWFactory();
        car = bmwFactory.createCar();
        car.printName();

    }
}
