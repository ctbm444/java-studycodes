package com.example.designpatterns;

import com.sun.java.browser.plugin2.DOM;
import org.springframework.cglib.proxy.MethodInterceptor;

import javax.servlet.Filter;
import javax.swing.*;
import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationHandler;
import java.sql.JDBCType;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: jdk中设计模式的运用
 * @author: yanxiaotian
 * @create: 2020-11-26 15:50
 **/
public class JdkDesignPatternsDemo {
    public static void main(String[] args) throws Exception{
        /******    建造型设计模式         ******/
        //1.工厂方法模式 Collection.iterator() 由具体的聚集类来确定使用哪一个Iterator
        Collection collection=new ArrayList();
        collection.iterator();

        //3.单例模式
        Runtime runtime=Runtime.getRuntime();

        //4.建造者模式 通过append()方法返回组长结果，返回的类型StringBuilder本身。
        StringBuilder sb=new StringBuilder();
        sb.append("a").append("b").append("c");

        //5.原型模式 实现cloneble接口可以进行浅拷贝。深拷贝可以通过二进制流
        List<? extends Cloneable> list1=new ArrayList<>();


        /******    结构型设计模式         ********/
        //6.适配器模式
        InputStreamReader isr=new InputStreamReader(new FileInputStream(""));
        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream(""));

        //7.装饰器模式
        FileInputStream fis=new FileInputStream("");
        BufferedInputStream bis=new BufferedInputStream(fis);

        //8.代理模式 InvocationHandler为jdk动态代理接口
        List<? extends InvocationHandler> list2=new ArrayList<>();
        List<? extends MethodInterceptor> list3=new ArrayList<>();//cglib动态代理，非jdk

        //9.外观模式 java.util.logging
        // Logging logging=new Logging();

        //10.桥接模式
        // JDBC

        //11.组合模式
        // DOM

        //12.享元模式 Integer的有一个IntegerCache类，-128-127之间的值自动装箱时公用缓存池里的Integer对象
        Integer.valueOf(5);


        /****     行为型设计模式            *****/
        //13.策略模式 线程池的四种拒绝策略
        ThreadPoolExecutor pool=
                new ThreadPoolExecutor(5,10,2,
                        TimeUnit.SECONDS,new LinkedBlockingQueue<>(), new ThreadPoolExecutor.DiscardOldestPolicy());

        //14.模板方法模式
        // AbstractList、AbstractMap 等
        //InputStream、OutputStream
        //AQS
        AbstractList list4=new ArrayList();

        //15.监听者模式  swing的listener
        JButton button=new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //16.迭代器模式 iterator  Collection接口的子接口有List,Set,Queue
        Set set=new HashSet<>();
        set.iterator();

        //17.责任链模式
        //j2ee的filter

        //18.命令模式 Runnable、Callable，ThreadPoolExecutor
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        //19.其他暂时不学习
    }
}
