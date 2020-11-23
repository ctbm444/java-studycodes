package com.example.designmodes.type1_constructpatterns.mode_02_abstractfactory;

/**
 * @description: 抽象工厂模式 工厂接口
 * @author: yanxiaotian
 * @create: 2020-11-18 10:01
 **/
public interface IFactory {
    public IProduct1 getProduct1();
    public IProduct2 getProduct2();
}
