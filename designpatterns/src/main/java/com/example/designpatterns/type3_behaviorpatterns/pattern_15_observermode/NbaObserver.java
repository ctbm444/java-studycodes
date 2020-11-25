package com.example.designpatterns.type3_behaviorpatterns.pattern_15_observermode;

/**
 * @description: 观察者实现类 看nba的员工
 * @author: yanxiaotian
 * @create: 2020-11-23 14:00
 **/
public class NbaObserver extends Observer {

    public NbaObserver(String name, Subject subject) {
        super(name, subject);
    }

    @Override
    public void update() {
        System.out.println(subject.getStatus()+name+"关掉nba，继续工作。");
    }
}
