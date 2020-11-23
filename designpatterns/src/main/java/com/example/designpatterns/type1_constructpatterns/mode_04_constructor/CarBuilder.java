package com.example.designpatterns.type1_constructpatterns.mode_04_constructor;

/**
 * @description: 建造者模式 产品建造者类
 * @author: yanxiaotian
 * @create: 2020-11-18 13:33
 **/
public class CarBuilder extends Builder {
    private Car car;
    public CarBuilder(String name,String color){
        car=new Car();
        car.setName(name);
        car.setColor(color);
    }

    public Builder name(String name) {
        this.car.setName(name);
        return this;
    }

    public Builder color(String color) {
        this.car.setColor(color);
        return this;
    }

    public Builder weight() {
        this.car.setWeight(100);
        return this;
    }

    public Builder height() {
        this.car.setHeight(20);
        return this;
    }

    public  Car getCar(){
        return car;
    }
}
