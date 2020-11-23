package com.example.designmodes.type2_structurepatterns.mode_12_flyweight.demo2;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 棋子享元工厂类
 * @author: yanxiaotian
 * @create: 2020-11-19 11:12
 **/
public class ChesspieceFactory {
    public static ConcurrentHashMap<String,ChesspieceConcrete> pool=new ConcurrentHashMap(16);
    public static ChesspieceConcrete getChesspiece(String color){
        ChesspieceConcrete chesspiece=null;
        if(pool.containsKey(color)){
            System.out.println(color+"棋子对象已存在，从池中取出");
            chesspiece=pool.get(color);
        }else{
            System.out.println(color+"棋子对象不存在，新建并放入池中");
            chesspiece=new ChesspieceConcrete(color);
            pool.put(color,chesspiece);
        }
        return chesspiece;
    }
}
