package com.example.designpatterns.type2_structurepatterns.mode_11_composite;

/**
 * @description: 文件实现类
 * @author: yanxiaotian
 * @create: 2020-11-19 09:13
 **/
public class ImageFile extends File {
    public ImageFile(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("这是"+this.name);
    }
}
