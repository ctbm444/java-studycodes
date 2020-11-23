package com.example.designmodes.type2_structurepatterns.mode_08_proxy;

import java.lang.reflect.Proxy;

/**
 * @description: 静态代理测试类
 * @author: yanxiaotian
 * @create: 2020-11-18 15:48
 **/
public class Test8 {
    public static void main(String[] args) {
        BuyHouse buyHouse=new BuyHouseImpl();
        StaticProxy staticProxy=new StaticProxy(buyHouse);
        staticProxy.buyHouse();

        BuyHouse buyHouse1=(BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(),new Class[]{BuyHouse.class},new DynamicProxy(buyHouse));
        buyHouse1.buyHouse();

        BuyHouse buyHouse2=new BuyHouseImpl();
        CglibProxy cglibProxy=new CglibProxy();
        BuyHouseImpl buyHouseCglibProxy=(BuyHouseImpl)cglibProxy.getInstance(buyHouse2);
        buyHouseCglibProxy.buyHouse();
    }
}
