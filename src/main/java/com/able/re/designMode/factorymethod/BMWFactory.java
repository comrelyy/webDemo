package com.able.re.designmode.factorymethod;

import com.able.re.designmode.BMWCar;
import com.able.re.designmode.Car;

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
