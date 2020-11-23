package com.example.designmodes.type1_constructpatterns.mode_03_singleton;

/**
 * @description: 懒汉型单例模式 线程不安全，lazyloading
 * @author: yanxiaotian
 * @create: 2020-11-18 13:11
 **/
public class Singleton6 {
    private static Singleton6 instance;
    private Singleton6(){};
    public static Singleton6 getInstance(){
        if(instance==null){
            instance=new Singleton6();
        }
        return instance;
    }
}
