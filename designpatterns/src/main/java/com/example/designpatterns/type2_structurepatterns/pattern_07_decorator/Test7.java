package com.example.designpatterns.type2_structurepatterns.pattern_07_decorator;

/**
 * @description: 装饰器模式测试类
 * @author: yanxiaotian
 * @create: 2020-11-18 15:23
 **/
public class Test7 {
    public static void main(String[] args) {
        Vehicle v=new Car();
        v.run();
        v=new ConcreteDecorator(v);
        v.run();
    }
}
