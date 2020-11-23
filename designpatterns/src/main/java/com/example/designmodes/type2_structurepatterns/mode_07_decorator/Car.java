package com.example.designmodes.type2_structurepatterns.mode_07_decorator;

/**
 * @description: 原组件实现类
 * @author: yanxiaotian
 * @create: 2020-11-18 15:14
 **/
public class Car extends Vehicle {

    @Override
    public void run() {
        System.out.println("汽车开始跑");
    }
}
