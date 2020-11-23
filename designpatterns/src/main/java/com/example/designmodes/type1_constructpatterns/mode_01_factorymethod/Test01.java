package com.example.designmodes.type1_constructpatterns.mode_01_factorymethod;

/**
 * @description: 工厂方法模式测试类
 * @author: yanxiaotian
 * @create: 2020-11-18 09:53
 **/
public class Test01 {
    public static void main(String[] args) {
        /*一个工厂实现类只能制造一种产品*/
        IFactory factoryA=new FactoryA();
        IFactory factoryB=new FactoryB();
        IProduct productA=factoryA.getProduct();
        IProduct productB=factoryB.getProduct();
        System.out.println(productA.equals(productB));
    }
}
