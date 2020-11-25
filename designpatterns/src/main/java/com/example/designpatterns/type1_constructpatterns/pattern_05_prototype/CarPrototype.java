package com.example.designpatterns.type1_constructpatterns.pattern_05_prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @description: 原型模式 实现类
 * @author: yanxiaotian
 * @create: 2020-11-18 14:26
 **/
public class CarPrototype implements Cloneable, Serializable {

    private static final long serialVersionUID = 259945030576839396L;
    private  String name;
    private PropertyObject object;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PropertyObject getObject() {
        return object;
    }

    public void setObject(PropertyObject object) {
        this.object = object;
    }

    public CarPrototype(){};

    @Override
    public String toString() {
        return "CarPrototype{" +
                "name='" + name + '\'' +
                ", object=" + object +
                '}';
    }

    /*浅复制*/
    @Override
    public CarPrototype clone() throws CloneNotSupportedException {
        return (CarPrototype)super.clone();
    }
    /*深复制*/
    public CarPrototype deepClone() throws IOException,ClassNotFoundException{
        /* 写入当前对象的二进制流 */
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bos);
        oos.writeObject(this);
        /* 读出二进制流产生的新对象 */
        ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        return (CarPrototype)ois.readObject();
    }

}
