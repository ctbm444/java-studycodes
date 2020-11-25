package com.example.designpatterns.type3_behaviorpatterns.pattern_13_strategy;

/**
 * @description: 策略模式 上下文类 屏蔽高层模块对策略、算法的直接访问
 * @author: yanxiaotian
 * @create: 2020-11-19 15:25
 **/
public class Context {
    Strategy strategy;
    public Context(Strategy strategy){
        this.strategy=strategy;
    }
    /*在上下文类中调用算法接口*/
    public void  method(){
        strategy.algorithm();
    }
}
