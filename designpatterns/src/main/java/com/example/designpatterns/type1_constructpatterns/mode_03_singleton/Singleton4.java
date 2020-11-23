package com.example.designpatterns.type1_constructpatterns.mode_03_singleton;

/**
 * @description: 枚举型单例模式 线程安全且lazyloading，且不怕反射。
 * @author: yanxiaotian
 * @create: 2020-11-18 11:07
 **/
public enum Singleton4 {
    INSTANCE;
    public static Singleton4 getInstance(){
        return INSTANCE;
    }
}
