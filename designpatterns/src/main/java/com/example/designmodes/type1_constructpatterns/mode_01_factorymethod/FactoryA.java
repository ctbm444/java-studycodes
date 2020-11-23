package com.example.designmodes.type1_constructpatterns.mode_01_factorymethod;

/**
 * @description: 工厂实现类1
 * @author: yanxiaotian
 * @create: 2020-11-18 09:46
 **/
public class FactoryA implements IFactory {
    @Override
    public IProduct getProduct() {
        return new ProductA();
    }
}
