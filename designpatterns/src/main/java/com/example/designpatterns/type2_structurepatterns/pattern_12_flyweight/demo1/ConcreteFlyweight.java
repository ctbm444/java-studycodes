package com.example.designpatterns.type2_structurepatterns.pattern_12_flyweight.demo1;

/**
 * @description: 共享实现类
 * @author: yanxiaotian
 * @create: 2020-11-19 10:18
 **/
public class ConcreteFlyweight extends Flyweight {
    public ConcreteFlyweight(String extrinsic) {
        super(extrinsic);
    }

    @Override
    public void operate(int extrinsic) {
        System.out.println("具体Flyweight:"+extrinsic);
    }
}
