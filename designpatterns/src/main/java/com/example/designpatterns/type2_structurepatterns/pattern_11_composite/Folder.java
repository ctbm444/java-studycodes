package com.example.designpatterns.type2_structurepatterns.pattern_11_composite;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 组合模式 文件夹实现类
 * @author: yanxiaotian
 * @create: 2020-11-19 09:08
 **/
public class Folder extends File {
    List<File> files=new LinkedList<>();

    public Folder(String name) {
        super(name);
    }

    @Override
    public void display() {
        for(File file:files){
            file.display();
        }
    }
    public void addFile(File file){
        files.add(file);
    }

    public void removeFile(File file){
        files.remove(file);
    }
}
