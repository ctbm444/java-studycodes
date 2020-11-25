package com.example.designpatterns.type3_behaviorpatterns.pattern_16_iterator;

import java.util.List;

/**
 * @description: 具体迭代器类
 * @author: yanxiaotian
 * @create: 2020-11-23 18:44
 **/
public class ConcretreIterator implements Iterator {
    private List<Object> vector=null;
    private int index=-1;
    protected ConcretreIterator(List list){
        vector=list;
    }
    @Override
    public Object first() {
        return vector.get(0);
    }

    @Override
    public Object next() {
        if(this.hasNext()){
            return vector.get(++index);
        }else{
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        if(index<vector.size()-1){
            return true;
        }else {
            return false;
        }
    }
}
