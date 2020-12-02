package yxxy.c_019;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * 曾经的面试题：（淘宝？）
 * 实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束*
 * 分析下面这个程序，能完成这个功能吗？
 * @author: yanxiaotian
 * @create: 2020-12-01 17:20
 **/
public class Container1 {

    List list=new LinkedList<>();

    void add(Object o){
        list.add(o);
    }

    int get(){
        return list.size();
    }

    public static void main(String[] args) {
        Container1 c=new Container1();
        new Thread(()->{
            for(int i=0; i<10; i++){
                c.add(new Object());
                System.out.println("add "+i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();
        new Thread(()->{
            while(true){
                //System.out.println("c的大小："+c.get());
                if(c.get()==5){
                    break;
                }
            }
            System.out.println("thread2 结束");
        },"t2").start();
    }
}
