package com.example.designpatterns;


import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.adapter.AdvisorAdapter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @description: spring中的设计模式
 * @author: yanxiaotian
 * @create: 2020-11-26 17:04
 **/
public class SpringPatternsDemo {

    //1.抽象工厂模式 beanfactory

    //2.代理模式 AOP

    //3.模板方法模式
   //AbstractApplicationContext 中定义了一系列的抽象方法， 比如refreshBeanFactory 、
    //closeBeanFactory、getBeanFactory。

    //4.单例模式
    //Spring 可以管理单例对象，控制对象为单例

    //5.原型模式
    //Spring 可以管理多例对象，控制对象为prototype

    //6.适配器模式 AdvisorAdapter 将Advice 与Interceptor 的适配
    AdvisorAdapter advisorAdapter=new AdvisorAdapter() {
        @Override
        public boolean supportsAdvice(Advice advice) {
            return false;
        }

        @Override
        public MethodInterceptor getInterceptor(Advisor advisor) {
            return null;
        }
    };
}
