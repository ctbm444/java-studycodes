package com.example.designmodes.type3_behaviorpatterns.mode_14_templatemethod;

/**
 * @description: 模板方法模式 吃午饭抽象类
 * @author: yanxiaotian
 * @create: 2020-11-19 15:35
 **/
public abstract class HaveLunch {
    /*定义为final类型，防止子类重写*/
    final void haveLunch(){
        this.getLunch();
        this.eat();
    }
    /*获取午饭的方式有很多实现方法*/
    public abstract void getLunch();
    public void eat(){
        System.out.println("亲自用嘴吃饭");
    }
}
