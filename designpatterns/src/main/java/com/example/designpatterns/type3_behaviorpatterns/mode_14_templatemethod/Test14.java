package com.example.designpatterns.type3_behaviorpatterns.mode_14_templatemethod;

/**
 * @description: 模板方法测试类
 * @author: yanxiaotian
 * @create: 2020-11-19 15:42
 **/
public class Test14 {
    public static void main(String[] args) {
        BuyLunch buyLunch=new BuyLunch();
        buyLunch.haveLunch();
        GoToRestaurant goLunch=new GoToRestaurant();
        goLunch.haveLunch();
    }
}
