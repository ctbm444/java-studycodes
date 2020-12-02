package yxxy.c_009;

import java.util.concurrent.TimeUnit;

/**
 * @description: 一个同步方法可以调用另一个同步方法。一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁。
 * 即sychronized获得的是可重入锁
 * @author: yanxiaotian
 * @create: 2020-12-01 14:38
 **/
public class T {
    synchronized void m1(){
        System.out.println(Thread.currentThread().getName()+", m1 start...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
    }
    synchronized void m2(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+", m2 start...");
    }

    public static void main(String[] args) {
        T t=new T();
        new Thread(()->t.m1(),"thread1").start();
        new Thread(()->t.m1(),"thread2").start();
    }
}
