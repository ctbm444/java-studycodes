package com.example.designpatterns.type2_structurepatterns.mode_12_flyweight.demo2;

/**
 * @description: 棋子享元抽象类
 * @author: yanxiaotian
 * @create: 2020-11-19 10:52
 **/
public interface Chesspiece {

    //棋子移动方法，m为横坐标变化，n为纵坐标变化
    public abstract void put(int x,int y);

}
