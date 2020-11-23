package com.example.designpatterns.type2_structurepatterns.mode_08_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description: 动态代理示例类
 * @author: yanxiaotian
 * @create: 2020-11-18 15:53
 **/
public class DynamicProxy implements InvocationHandler {
    private Object object;
    public DynamicProxy(final Object object){
        this.object=object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=method.invoke(object,args);
        return result;
    }
}
