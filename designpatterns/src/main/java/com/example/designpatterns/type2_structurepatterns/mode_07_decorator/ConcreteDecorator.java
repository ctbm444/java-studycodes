package com.example.designpatterns.type2_structurepatterns.mode_07_decorator;

/**
 * @description: 装饰器实现类
 * @author: yanxiaotian
 * @create: 2020-11-18 15:18
 **/
public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public void fly() {
        System.out.println("飞起来了");
    }

    @Override
    public void run() {
        System.out.println("装饰器组件调用了原组件的跑方法");
        fly();
    }
}
