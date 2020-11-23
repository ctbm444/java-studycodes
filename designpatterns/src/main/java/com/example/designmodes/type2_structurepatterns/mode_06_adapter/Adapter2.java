package com.example.designmodes.type2_structurepatterns.mode_06_adapter;

/**
 * @description: 适配器
 * @author: yanxiaotian
 * @create: 2020-11-18 15:02
 **/
public class Adapter2 implements Target{
    private Adaptee adaptee=new Adaptee();

    public void m(){
        adaptee.m();
    }

    @Override
    public void m2() {
        System.out.println("目标接口方法2");
    }
}
