package com.example.designmodes.type2_structurepatterns.mode_10_bridge;

/**
 * @description: 具体角色抽象类
 * @author: yanxiaotian
 * @create: 2020-11-18 16:37
 **/
public abstract class Vehicle {
    Color color;
    public void setColor(Color color){
        this.color=color;
    };
}
