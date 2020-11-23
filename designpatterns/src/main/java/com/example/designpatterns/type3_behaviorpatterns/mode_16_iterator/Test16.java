package com.example.designpatterns.type3_behaviorpatterns.mode_16_iterator;

/**
 * @description: 迭代器模式测试类
 * @author: yanxiaotian
 * @create: 2020-11-23 18:50
 **/
public class Test16 {
    public static void main(String[] args) {
        ConcreteColletion list=new ConcreteColletion();
        list.add("苹果");
        list.add("橘子");
        list.add("香蕉");
        Iterator iterator=list.getIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(iterator.first());
    }
}
