package com.bdqn.bean;

import java.util.function.ToIntBiFunction;

/*
 * @创建人   zby
 * @创建时间 2022/8/31---19:03
 * @描述信息
 */
//汽车
public class Car {
    //品牌
    private String brand;
    //颜色
    private String color;

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public Car() {
    }
}
