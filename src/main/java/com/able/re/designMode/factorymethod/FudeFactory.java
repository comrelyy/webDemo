package com.able.re.designmode.factorymethod;

import com.able.re.designmode.Car;
import com.able.re.designmode.FudeCar;

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
