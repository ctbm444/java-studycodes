package com.example.designpatterns.type2_structurepatterns.pattern_11_composite;

/**
 * @description: 组合模式 文件抽象类
 * @author: yanxiaotian
 * @create: 2020-11-19 09:06
 **/
public abstract class File {
    String name;

    public File(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void display();
}
