package com.example.designpatterns.type3_behaviorpatterns.pattern_15_observermode;

/**
 * @description: 观察者接口
 * @author: yanxiaotian
 * @create: 2020-11-23 11:13
 **/
public abstract class Observer {
    protected String name;
    protected Subject subject;

    public Observer(String name,Subject subject){
        this.name=name;
        this.subject=subject;
    }
    public abstract  void update();
}
