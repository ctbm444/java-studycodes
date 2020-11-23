package com.example.designmodes.type1_constructpatterns.mode_03_singleton;

/**
 * @description: 饿汉式2 线程安全但不能lazyloading
 * @author: yanxiaotian
 * @create: 2020-11-18 10:43
 **/
public class Singleton2 {
    private static Singleton2 instance;
    static {
        instance=new Singleton2();
    }
    public static Singleton2 getInstance(){
        return instance;
    }
}
