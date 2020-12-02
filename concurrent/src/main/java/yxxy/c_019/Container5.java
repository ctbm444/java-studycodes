package yxxy.c_019;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @description: 用门栓 countdownlatch实现此题
 * 曾经的面试题：（淘宝？）
 * 实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束*
 * 分析下面这个程序，能完成这个功能吗？
 * @author: yanxiaotian
 * @create: 2020-12-01 17:20
 **/
public class Container5 {

    List list=new LinkedList<>();

    void add(Object o){
        list.add(o);
    }

    int get(){
        return list.size();
    }

    public static void main(String[] args) {
        Container5 c=new Container5();
        CountDownLatch latch=new CountDownLatch(5);
        new Thread(()->{
            System.out.println("t2 start");
            try {
                //t2阻塞 直到门栓变为0
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 end");
        },"t2").start();
        new Thread(()->{
            for(int i=0; i<10; i++){
                c.add(new Object());
                System.out.println("add "+i);
                latch.countDown();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();
    }
}
