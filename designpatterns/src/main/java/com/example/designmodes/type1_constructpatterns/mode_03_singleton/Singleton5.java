package com.example.designmodes.type1_constructpatterns.mode_03_singleton;

/**
 * @description: 双重锁校验单例
 * @author: yanxiaotian
 * @create: 2020-11-18 13:05
 **/
public class Singleton5 {
    private volatile static Singleton5 instance;
    private Singleton5(){};
    public static Singleton5 getInstance(){
        if(instance==null){
            synchronized (Singleton5.class){
                if(instance==null){
                    instance= new Singleton5();
                }
            }
        }
        return instance;
    }
}
