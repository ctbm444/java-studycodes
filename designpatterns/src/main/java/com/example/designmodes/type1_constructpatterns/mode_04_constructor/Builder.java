package com.example.designmodes.type1_constructpatterns.mode_04_constructor;

/**
 * @description: 建造者模式 产品建造者抽象类
 * @author: yanxiaotian
 * @create: 2020-11-18 13:44
 **/
public abstract  class Builder {
    abstract Builder name(String name);
    abstract Builder color(String color);
    abstract Builder weight();
    abstract Builder height();
    abstract Car getCar();
}
