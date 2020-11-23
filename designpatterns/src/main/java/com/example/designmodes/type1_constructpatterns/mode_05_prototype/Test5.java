package com.example.designmodes.type1_constructpatterns.mode_05_prototype;

import java.io.IOException;

/**
 * @description: 原型模式测试类
 * @author: yanxiaotian
 * @create: 2020-11-18 14:38
 **/
public class Test5 {
    public static void main(String[] args) {
        CarPrototype c1=new CarPrototype();
        c1.setName("自行车");
        PropertyObject object=new PropertyObject();
        object.setName("属性");
        c1.setObject(object);
        CarPrototype c2=null;
        CarPrototype c3=null;
        try {
            c2=c1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        try {
            c3=c1.deepClone();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c1==c2);
        System.out.println(c1==c3);
        System.out.println(c1.getName()==c2.getName());
        System.out.println(c1.getName()==c3.getName());
        System.out.println(c1.getObject()==c2.getObject());
        System.out.println(c1.getObject()==c3.getObject());
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }
}
