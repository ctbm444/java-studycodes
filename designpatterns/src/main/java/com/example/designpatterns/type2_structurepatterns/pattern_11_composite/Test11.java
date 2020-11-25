package com.example.designpatterns.type2_structurepatterns.pattern_11_composite;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 组合模式测试类
 * @author: yanxiaotian
 * @create: 2020-11-19 09:19
 **/
public class Test11 {
    public static void main(String[] args) {
        Folder folder = new Folder("文件夹");
        TextFile file1 = new TextFile("文本文件1");
        ImageFile file2 = new ImageFile("图片文件1");
        VideoFile file3 = new VideoFile("视频文件1");
        Folder folderA=new Folder("A文件夹");
        folder.addFile(file1);
        folder.addFile(file2);
        folder.addFile(file3);
        folder.addFile(folderA);
        TextFile file4 = new TextFile("文本文件2");
        ImageFile file5 = new ImageFile("图片文件2");
        VideoFile file6 = new VideoFile("视频文件2");
        folderA.addFile(file4);
        folderA.addFile(file5);
        folderA.addFile(file6);
        folder.display();

        Map map=new HashMap(8);
    }
}
