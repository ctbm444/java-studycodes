package com.example.designpatterns.type3_behaviorpatterns.pattern_14_templatemethod;

/**
 * @description: 吃午饭实现类
 * @author: yanxiaotian
 * @create: 2020-11-19 15:41
 **/
public class GoToRestaurant extends HaveLunch {
    @Override
    public void getLunch() {
        System.out.println("去饭店点一份快餐");
    }
}
