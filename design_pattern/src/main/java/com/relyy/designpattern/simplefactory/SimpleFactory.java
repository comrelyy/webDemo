package com.relyy.designpattern.simplefactory;


import com.relyy.designpattern.BMWCar;
import com.relyy.designpattern.Car;
import com.relyy.designpattern.FudeCar;

/**
 * 简单工厂
 *
 * @author cairuirui
 * @create 2018-03-12
 */
public class SimpleFactory {

    private static SimpleFactory simpleFactory = null;

    public static SimpleFactory getSimpleFactory(){
        if (null == simpleFactory) {
            simpleFactory = new SimpleFactory();
        }

        return simpleFactory;
    }

    public Car createCar(String carType){
        switch (carType){
            case "fude" :
                return new FudeCar();
            case "BMW" :
                return new BMWCar();
        }
        return null;
    }
}
