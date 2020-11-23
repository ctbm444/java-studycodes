package com.example.designpatterns.type2_structurepatterns.mode_08_proxy;

/**
 * @description: 服务实现类
 * @author: yanxiaotian
 * @create: 2020-11-18 15:45
 **/
public class BuyHouseImpl implements BuyHouse {
    @Override
    public void buyHouse() {
        System.out.println("手动买房操作");
    }
}
