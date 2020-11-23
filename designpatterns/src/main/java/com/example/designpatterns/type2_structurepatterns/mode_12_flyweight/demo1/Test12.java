package com.example.designpatterns.type2_structurepatterns.mode_12_flyweight.demo1;

/**
 * @description: 享元模式测试类
 * @author: yanxiaotian
 * @create: 2020-11-19 10:24
 **/
public class Test12 {
    public static void main(String[] args) {
        int extrinsic=10;
        Flyweight flyweightA=FlyweightFactory.getFlyweight("A");
        flyweightA.operate(extrinsic++);
        Flyweight flyweightB=FlyweightFactory.getFlyweight("B");
        flyweightB.operate(extrinsic++);
        Flyweight flyweightC=FlyweightFactory.getFlyweight("C");
        flyweightC.operate(extrinsic++);
        Flyweight flyweightA1=FlyweightFactory.getFlyweight("A");
        flyweightA1.operate(extrinsic++);

        Flyweight unsharedFlyweight=new UnsharedConcreteFlyweight("A");
        unsharedFlyweight.operate(extrinsic++);

        Flyweight flyweightD=new ConcreteFlyweight("D");

    }
}
