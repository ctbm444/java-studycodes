package yxxy.c_019;

import yxxy.c_004.C;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description: 用栅栏 cyclicbarrier实现此题
 * 曾经的面试题：（淘宝？）
 * 实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束*
 * 分析下面这个程序，能完成这个功能吗？
 * @author: yanxiaotian
 * @create: 2020-12-01 17:20
 **/
public class Container6 {

    List list=new LinkedList<>();

    void add(Object o){
        list.add(o);
    }

    synchronized int get(){
        return list.size();
    }

    public static void main(String[] args) {
        Container6 c=new Container6();
        CyclicBarrier barrier=new CyclicBarrier(1, new Runnable() {
            @Override
            public void run() {
                System.out.println("个数到达5个！");
                System.out.println("t2 end");
            }
        });
        ExecutorService executor= Executors.newFixedThreadPool(1);
        executor.submit(new Runnable() {
            @Override
            public void run() {
                Container6 c=new Container6();
                for(int i=0;i<10;i++){
                    System.out.println("t1:"+i);
                    c.add(new Object());
                    if(c.get()==5){
                        try {
                            barrier.await();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        executor.shutdown();
    }
}
