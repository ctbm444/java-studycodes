package com.example.designpatterns.type1_constructpatterns.mode_04_constructor;

/**
 * @description: 建造者模式测试类
 * @author: yanxiaotian
 * @create: 2020-11-18 14:06
 **/
public class Test4 {
    public static void main(String[] args) {
        Builder builder=new CarBuilder("出租车","蓝色");
        Director director=new Director(builder);
        director.construct();
        Car taxi=builder.getCar();
        System.out.println(taxi);
    }
}
