package com.example.designpatterns.type1_constructpatterns.pattern_03_singleton;

/**
 * @description:  静态内部类型单例模式 线程安全且有lazyloading
 * @author: yanxiaotian
 * @create: 2020-11-18 11:05
 **/
public class Singleton3 {
    private static boolean flag=false;
    private static class Holder{
        private static Singleton3 instance=new Singleton3();
    }
    private Singleton3(){
        if(!flag){
            flag=!flag;
        }else{
            throw new RuntimeException();
        }
    };
    public static Singleton3 getInstance(){
        return Holder.instance;
    }
}
