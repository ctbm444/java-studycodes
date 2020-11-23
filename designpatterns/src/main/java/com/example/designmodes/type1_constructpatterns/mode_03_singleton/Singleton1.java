package com.example.designmodes.type1_constructpatterns.mode_03_singleton;

/**
 * @description: 饿汉式1  线程安全但不能lazyloading
 * @author: yanxiaotian
 * @create: 2020-11-18 10:32
 **/
public class Singleton1 {
    private static Singleton1 instance=new Singleton1();
    private Singleton1(){};
    public static Singleton1 getInstance(){
        return instance;
    }

}
