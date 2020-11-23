package com.example.designmodes.type2_structurepatterns.mode_12_flyweight.demo1;

/**
 * @description: 不共享实现类
 * @author: yanxiaotian
 * @create: 2020-11-19 10:19
 **/
public class UnsharedConcreteFlyweight extends Flyweight {
    public UnsharedConcreteFlyweight(String extrinsic) {
        super(extrinsic);
    }

    @Override
    public void operate(int extrinsic) {
        System.out.println("不共享的具体Flyweight:"+extrinsic);
    }
}
