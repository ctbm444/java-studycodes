package com.example.designpatterns.type1_constructpatterns.pattern_05_prototype;

import java.io.Serializable;

/**
 * @description: 原型类属性对象
 * @author: yanxiaotian
 * @create: 2020-11-18 14:30
 **/
public class PropertyObject implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PropertyObject{" +
                "name='" + name + '\'' +
                '}';
    }
}
