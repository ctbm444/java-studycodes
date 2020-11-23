package com.example.designpatterns.type2_structurepatterns.mode_06_adapter;

/**
 * @description: 适配器
 * @author: yanxiaotian
 * @create: 2020-11-18 14:59
 **/
public class Adapter1 extends Adaptee implements Target {
    @Override
    public void m() {
        super.m();
    }

    @Override
    public void m2() {
        System.out.println("目标接口方法");
    }
}
