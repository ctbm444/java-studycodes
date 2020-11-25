package com.example.designpatterns.type2_structurepatterns.pattern_09_facade;

/**
 * @description: 外观模式 测试类
 * @author: yanxiaotian
 * @create: 2020-11-18 16:27
 **/
public class Test9 {
    public static void main(String[] args) {
        Facade facade=new Facade();
        facade.methodA();
        facade.methodB();
        facade.methodC();
    }
}
