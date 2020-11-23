package com.example.designpatterns.type1_constructpatterns.mode_03_singleton;

import java.lang.reflect.Constructor;

/**
 * @description: 单例模式测试
 * @author: yanxiaotian
 * @create: 2020-11-18 10:42
 **/
public class Test3 {
    public static void main(String[] args) throws Exception {
        Singleton3 s1=Singleton3.getInstance();
        Singleton3 s2=Singleton3.getInstance();
        Constructor<Singleton3> constructor=Singleton3.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton3 s3=constructor.newInstance();
        System.out.println(s1==s2);
        System.out.println(s1==s3);
    }

}
