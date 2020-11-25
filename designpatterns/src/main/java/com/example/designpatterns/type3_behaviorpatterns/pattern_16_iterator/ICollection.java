package com.example.designpatterns.type3_behaviorpatterns.pattern_16_iterator;

/**
 * @description: 抽象聚合类
 * @author: yanxiaotian
 * @create: 2020-11-23 18:38
 **/
public interface ICollection {

    void add(Object obj);
    void remove(Object obj);
    Iterator getIterator();
}
