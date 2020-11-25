package com.example.designpatterns.type2_structurepatterns.pattern_11_composite;

/**
 * @description: 文件实现类
 * @author: yanxiaotian
 * @create: 2020-11-19 09:13
 **/
public class TextFile extends File {
    public TextFile(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("这是"+this.name);
    }
}
