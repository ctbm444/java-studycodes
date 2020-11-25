package com.example.designpatterns.type2_structurepatterns.pattern_06_adapter;

/**
 * @description: 适配器模式测试类
 * @author: yanxiaotian
 * @create: 2020-11-18 15:00
 **/
public class Test6 {
    public static void main(String[] args) {
        Adapter1 adapter1=new Adapter1();
        adapter1.m();
        adapter1.m2();

        Adapter2 adapter2=new Adapter2();
        adapter2.m();
        adapter2.m2();
    }
}

