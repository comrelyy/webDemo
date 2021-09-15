package com.relyy.designpattern.factorymethod;


import com.relyy.designpattern.Car;
import com.relyy.designpattern.FudeCar;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-03-12
 */
public class FudeFactory extends FactoryMethod{
    @Override
    public Car createCar() {
        return new FudeCar();
    }
}
