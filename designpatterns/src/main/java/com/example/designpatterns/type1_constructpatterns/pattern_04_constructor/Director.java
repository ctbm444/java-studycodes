package com.example.designpatterns.type1_constructpatterns.pattern_04_constructor;

/**
 * @description: 建造者模式 指导者类
 * @author: yanxiaotian
 * @create: 2020-11-18 13:48
 **/
public class Director {
    private  Builder  mBuilder;
    public Director(Builder builder){
        mBuilder=builder;
    }
    public void construct(){
        mBuilder.height().weight();
    }
}
