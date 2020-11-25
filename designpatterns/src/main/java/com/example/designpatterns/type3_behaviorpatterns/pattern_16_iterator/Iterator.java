package com.example.designpatterns.type3_behaviorpatterns.pattern_16_iterator;

/**
 * @description: 抽象迭代器
 * @author: yanxiaotian
 * @create: 2020-11-23 18:39
 **/
public interface Iterator {
    Object first();
    Object next();
    boolean hasNext();
}
