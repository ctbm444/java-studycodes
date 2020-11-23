package com.example.designpatterns.type1_constructpatterns.mode_02_abstractfactory;

/**
 * @description: 工厂实现类
 * @author: yanxiaotian
 * @create: 2020-11-18 10:12
 **/
public class FactoryB implements IFactory{
    @Override
    public IProduct1 getProduct1() {
        return new Product1B();
    }

    @Override
    public IProduct2 getProduct2() {
        return new Product2B();
    }
}
