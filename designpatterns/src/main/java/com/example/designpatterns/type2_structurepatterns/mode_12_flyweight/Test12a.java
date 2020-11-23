package com.example.designpatterns.type2_structurepatterns.mode_12_flyweight;

import com.example.designpatterns.type2_structurepatterns.mode_12_flyweight.demo2.ChesspieceConcrete;
import com.example.designpatterns.type2_structurepatterns.mode_12_flyweight.demo2.ChesspieceFactory;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.util.Properties;


/**
 * @description: 享元模式测试类
 * @author: yanxiaotian
 * @create: 2020-11-19 14:03
 **/
public class Test12a {
    public static void main(String[] args) throws Exception{
        ChesspieceConcrete c1= ChesspieceFactory.getChesspiece("白色");
        c1.put(6,6);
        ChesspieceConcrete c2=ChesspieceFactory.getChesspiece("黑色");
        c2.put(6,7);
        ChesspieceConcrete c3= ChesspieceFactory.getChesspiece("白色");
        c3.put(6,8);
        ChesspieceConcrete c4=ChesspieceFactory.getChesspiece("黑色");
        c4.put(8,6);

        System.out.println(c1==c2);
        System.out.println(c1==c3);
        System.out.println(c2==c4);

        String s=new String();
       BasicDataSource dataSource= BasicDataSourceFactory.createDataSource(new Properties());
    }

}
