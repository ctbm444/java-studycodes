package com.example.designpatterns.type3_behaviorpatterns.mode_15_observermode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 具体通知者 秘书
 * @author: yanxiaotian
 * @create: 2020-11-23 13:39
 **/
public class Secretary implements Subject {
    //同事列表
    private List<Observer> list=new LinkedList<>();
    private String status;

    @Override
    public void attach(Observer observer) {
        list.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        list.remove(observer);
    }

    @Override
    public String getStatus() {
        return this.status;
    }

    @Override
    public void setStatus(String status) {
        this.status=status;
    }

    @Override
    public void notifyObservers() {
        System.out.println("前台打开qq，准备告诉所有观察者！");
        for(Observer observer:list){
            observer.update();
        }
    }

}
