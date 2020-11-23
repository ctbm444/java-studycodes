package com.example.designmodes.type3_behaviorpatterns.mode_14_templatemethod;

/**
 * @description: 吃午饭实现类
 * @author: yanxiaotian
 * @create: 2020-11-19 15:38
 **/
public class BuyLunch extends HaveLunch {
    @Override
    public void getLunch() {
        System.out.println("从美团上订一份外卖");
    }
}
