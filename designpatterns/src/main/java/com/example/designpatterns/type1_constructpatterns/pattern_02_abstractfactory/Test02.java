package com.example.designpatterns.type1_constructpatterns.pattern_02_abstractfactory;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 * @description: 抽象工厂模式测试类
 * @author: yanxiaotian
 * @create: 2020-11-18 10:09
 **/
public class Test02 {
    /*一个工厂实现类可以制造多种产品*/
    public static void main(String[] args) {
        IFactory factoryA=new FactoryA();
        IProduct1 product1A=factoryA.getProduct1();
        IProduct2 product2A=factoryA.getProduct2();
        IFactory factoryB=new FactoryB();
        IProduct1 product1B=factoryB.getProduct1();
        IProduct2 product2B=factoryB.getProduct2();
        System.out.println(product1A==product2A);
        System.out.println(product1B==product2B);

        //源码查看
        DocumentBuilderFactory.newInstance();
    }
}
