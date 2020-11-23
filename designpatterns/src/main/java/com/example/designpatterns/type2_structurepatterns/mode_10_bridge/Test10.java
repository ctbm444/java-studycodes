package com.example.designpatterns.type2_structurepatterns.mode_10_bridge;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @description: 桥接模式测试类
 * @author: yanxiaotian
 * @create: 2020-11-18 17:23
 **/
public class Test10 {
    public static void main(String[] args) {
        Vehicle car=new Car();
        Color red=new Red();
        Color blue=new Blue();
        car.setColor(red);
        car.setColor(blue);

        Map<String,Object> map=new HashMap<>();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);

        Iterator iterator=map.keySet().iterator();
        while(iterator.hasNext()){
            String key=(String)iterator.next();
            System.out.print(key+":"+map.get(key)+",");
        }
        System.out.println();
        Set<String> set=map.keySet();
        for(String key:set){
            System.out.print(key+":"+map.get(key)+",");
        }
        System.out.println();
        for(Map.Entry entry:map.entrySet()){
            System.out.print(entry.getKey()+":"+entry.getValue()+",");
        }
    }
}
