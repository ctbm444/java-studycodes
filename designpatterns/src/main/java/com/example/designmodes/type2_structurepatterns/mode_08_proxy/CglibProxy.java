package com.example.designmodes.type2_structurepatterns.mode_08_proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description: cglib代理示例类
 * @author: yanxiaotian
 * @create: 2020-11-18 16:08
 **/
public class CglibProxy implements MethodInterceptor {
    private Object target;
    public Object getInstance(final Object object){
        this.target=object;
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result=methodProxy.invoke(method,objects);
        return result;
    }
}
