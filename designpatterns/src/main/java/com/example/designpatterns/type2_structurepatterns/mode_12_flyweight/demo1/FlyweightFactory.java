package com.example.designpatterns.type2_structurepatterns.mode_12_flyweight.demo1;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 享元模式 工厂类
 * @author: yanxiaotian
 * @create: 2020-11-19 10:20
 **/
public class FlyweightFactory {
    private static ConcurrentHashMap<String,Flyweight> pool=new ConcurrentHashMap<>();

    public static Flyweight getFlyweight(String extrinsic){
        Flyweight flyweight=null;
        if(pool.containsKey(extrinsic)){
            flyweight=pool.get(extrinsic);
            System.out.println("已有"+extrinsic+",直接从池中取出");
        }else{
            flyweight=new ConcreteFlyweight(extrinsic);
            pool.put(extrinsic,flyweight);
            System.out.println("创建"+extrinsic+",并从池中取出");
        }
        return flyweight;
    }
}
