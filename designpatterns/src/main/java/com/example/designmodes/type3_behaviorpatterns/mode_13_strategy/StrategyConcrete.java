package com.example.designmodes.type3_behaviorpatterns.mode_13_strategy;

/**
 * @description: 策略具体类
 * @author: yanxiaotian
 * @create: 2020-11-19 15:28
 **/
public class StrategyConcrete extends Strategy {
    @Override
    public void algorithm() {
        System.out.println("此处调用具体算法");
    }
}
