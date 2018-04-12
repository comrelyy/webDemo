package com.able.re.designMode.strategy;

/**
 * Created by relyy on 2018/3/10.
 */
public class Tire {

    Integer num;
    String type;
    String brand;

    public Tire() {
    }

    public Tire(Integer num, String type, String brand) {
        this.num = num;
        this.type = type;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Tire{" +
                "num=" + num +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
