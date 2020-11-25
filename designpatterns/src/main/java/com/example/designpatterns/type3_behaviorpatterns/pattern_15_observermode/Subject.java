package com.example.designpatterns.type3_behaviorpatterns.pattern_15_observermode;

/**
 * @description: 通知者接口
 * @author: yanxiaotian
 * @create: 2020-11-23 11:12
 **/
public interface Subject {
    //增加观察者
    public void attach(Observer observer);
    //解除观察者
    public void detach(Observer observer);
    //通知
    public void notifyObservers();
    public String getStatus();

    public void setStatus(String status);
}
