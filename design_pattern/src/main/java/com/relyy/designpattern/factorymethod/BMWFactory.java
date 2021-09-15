package com.relyy.designpattern.factorymethod;

import com.relyy.designpattern.BMWCar;
import com.relyy.designpattern.Car;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-03-12
 */
public class BMWFactory extends FactoryMethod{
    @Override
    public Car createCar() {
        return new BMWCar();
    }
}
