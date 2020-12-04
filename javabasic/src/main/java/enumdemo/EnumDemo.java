package enumdemo;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 枚举示例
 * @author: yanxiaotian
 * @create: 2020-12-02 10:23
 **/
public enum EnumDemo{
    INSTANCE("abc"),GOOD("sss");
    private String name;
    EnumDemo(String str){
        this.name=str;
    }
    private static final Map<String,EnumDemo> map=new HashMap<>();
    static {
        for(EnumDemo demo:EnumDemo.values()){
            map.put(demo.name,demo);
        }
    }

    private static EnumDemo fromString(String symbol){
        return map.get(symbol);
    }

    public static void main(String[] args) {
        //enumset的使用
        EnumSet<EnumDemo> set=EnumSet.allOf(EnumDemo.class);
        for(EnumDemo demo:set){
            System.out.println(demo.name);
        }
    }

}
//用实例域代替序数
enum EnumDemo2{
    A,B,C;
    //不推荐使用ordinal方法
    public int getNumber(){
        return ordinal()+1;
    }
}
//可以改用这种方法
enum EnumDemo3{
    A(1),B(2),C(3);

    private final int number;
    EnumDemo3(int size){
        number=size;
    }
    public int EnumDemo3(){
        return number;
    }
}

