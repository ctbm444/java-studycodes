package com.example.designpatterns.type3_behaviorpatterns.pattern_16_iterator;

import java.util.List;
import java.util.Vector;

/**
 * @description: 具体集合类
 * @author: yanxiaotian
 * @create: 2020-11-23 18:41
 **/
public class ConcreteColletion implements ICollection {
    private List<Object> vector=new Vector<>();

    @Override
    public void add(Object obj) {
        vector.add(obj);
    }

    @Override
    public void remove(Object obj) {
        vector.remove(obj);
    }

    @Override
    public Iterator getIterator() {
        return new ConcretreIterator(vector);
    }
}
