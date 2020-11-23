package com.example.designmodes.type2_structurepatterns.mode_12_flyweight.demo2;

/**
 * @description: 棋子享元具体类 为其内部状态增加存储空间
 * @author: yanxiaotian
 * @create: 2020-11-19 11:04
 **/
public class ChesspieceConcrete implements Chesspiece{

    private String color;

    ChesspieceConcrete(String color){
        this.color=color;
    }

    @Override
    public void put(int x,int y) {
        System.out.println("将"+this.color+"棋子放在下面位置：x="+x+",y="+y);
    }

}
