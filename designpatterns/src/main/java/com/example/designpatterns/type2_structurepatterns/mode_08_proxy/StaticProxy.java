package com.example.designpatterns.type2_structurepatterns.mode_08_proxy;

/**
 * @description: 代理类
 * @author: yanxiaotian
 * @create: 2020-11-18 15:45
 **/
public class StaticProxy implements BuyHouse {
    private BuyHouse buyHouse;
    public StaticProxy(final BuyHouse buyHouse){
       this.buyHouse=buyHouse;
    }
    @Override
    public void buyHouse() {
        buyHouse.buyHouse();
    }
}
