package com.example.designpatterns.type3_behaviorpatterns.pattern_15_observermode;

/**
 * @description: 具体观察者   看股票的同事
 * @author: yanxiaotian
 * @create: 2020-11-23 13:43
 **/
public class StockObserver extends Observer {

    public StockObserver(String name,Subject subject){
        super(name,subject);
    }

    @Override
    public void update() {
        System.out.println(subject.getStatus()+name+"关闭股市行情，继续工作！");
    }
}
