package com.example.designpatterns.type1_constructpatterns.mode_03_singleton;

/**
 * @description: 懒汉型单例模式 线程安全，lazyloading,单效率很低
 * @author: yanxiaotian
 * @create: 2020-11-18 13:14
 **/
public class Singleton7 {
    private static Singleton7 instance;
    private Singleton7(){};
    public static synchronized Singleton7 getInstance(){
        if(instance==null){
            instance=new Singleton7();
        }
        return instance;
    }
}
