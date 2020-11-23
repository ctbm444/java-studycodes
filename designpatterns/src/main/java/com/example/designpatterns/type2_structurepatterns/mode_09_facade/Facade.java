package com.example.designpatterns.type2_structurepatterns.mode_09_facade;

/**
 * @description: 外观模式 外观类
 * @author: yanxiaotian
 * @create: 2020-11-18 16:25
 **/
public class Facade {
    private SubSystemA systemA=new SubSystemA();
    private SubSystemB systemB=new SubSystemB();
    private  SubSystemC systemC=new SubSystemC();
    public void methodA(){
        systemA.methodA();
    }
    public void methodB(){
        systemB.methodB();
    }
    public void methodC(){
        systemC.methodC();
    }
}
