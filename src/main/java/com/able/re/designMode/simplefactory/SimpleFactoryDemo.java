package com.able.re.designmode.simplefactory;

import com.able.re.designmode.Car;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-03-12
 */
public class SimpleFactoryDemo {

    public static void main(String[] args) {

        SimpleFactory simpleFactory = SimpleFactory.getSimpleFactory();
        Car car = simpleFactory.createCar("fude");
        car.printName();
        car = simpleFactory.createCar("BMW");
        car.printName();
    }
}
