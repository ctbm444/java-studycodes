package com.example.designpatterns.type2_structurepatterns.pattern_07_decorator;

/**
 * @description: 装饰器抽象类
 * @author: yanxiaotian
 * @create: 2020-11-18 15:16
 **/
public abstract class Decorator extends Vehicle {
    private Vehicle vehicle;
    public Decorator(Vehicle vehicle){
        this.vehicle=vehicle;
    }
    abstract  void fly();
    public  void dive(){
        System.out.println("潜水功能");
    };
}
