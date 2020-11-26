package com.example.designpatterns.type1_constructpatterns.pattern_04_constructor;

import java.io.IOException;

/**
 * @description: 建造者模式测试类
 * @author: yanxiaotian
 * @create: 2020-11-18 14:06
 **/
public class Test4 implements Appendable{
    public static void main(String[] args) {
        Builder builder=new CarBuilder("出租车","蓝色");
        Director director=new Director(builder);
        director.construct();
        Car taxi=builder.getCar();
        System.out.println(taxi);

        //源码查看
        StringBuilder sb=new StringBuilder();
    }

    @Override
    public Appendable append(CharSequence csq) throws IOException {
        return null;
    }

    @Override
    public Appendable append(CharSequence csq, int start, int end) throws IOException {
        return null;
    }

    @Override
    public Appendable append(char c) throws IOException {
        return null;
    }
}
