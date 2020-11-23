package com.example.designmodes.type1_constructpatterns.mode_01_factorymethod;

/**
 * @description: 工厂实现类
 * @author: yanxiaotian
 * @create: 2020-11-18 09:52
 **/
public class FactoryB implements IFactory {
    @Override
    public IProduct getProduct() {
        return new ProductB();
    }
}
