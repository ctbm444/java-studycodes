package com.example.designpatterns.type1_constructpatterns.pattern_01_factorymethod;

import java.util.Calendar;

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



        //源码查看
        Calendar calendar=Calendar.getInstance();
    }
}
