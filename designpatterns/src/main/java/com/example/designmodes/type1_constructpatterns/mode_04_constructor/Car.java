package com.example.designmodes.type1_constructpatterns.mode_04_constructor;

/**
 * @description: 建造者模式 产品类
 * @author: yanxiaotian
 * @create: 2020-11-18 13:25
 **/
public class Car {
    private String name;//可选
    private String color;//可选
    private int weight;
    private int height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
