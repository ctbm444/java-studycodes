package com.example.designpatterns.type2_structurepatterns.pattern_12_flyweight.demo1;

/**
 * @description: 享元模式 抽象类
 * @author: yanxiaotian
 * @create: 2020-11-19 09:55
 **/
public abstract  class Flyweight {
    //内部状态
    public String intrinsic;
    //外部状态
    protected final String extrinsic;

    public Flyweight(String extrinsic){
        this.extrinsic=extrinsic;
    }
    //业务操作
    public abstract void operate(int extrinsic);

    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}
