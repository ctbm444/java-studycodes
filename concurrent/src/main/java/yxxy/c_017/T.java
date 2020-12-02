package yxxy.c_017;

import java.util.concurrent.TimeUnit;

/**
 * @description: 锁定某对象o，如果o的属性发生改变，不影响锁的使用。如果o变成另一个对象，将会导致本线程的锁失效。
 * @author: yanxiaotian
 * @create: 2020-12-01 16:54
 **/
public class T {
    Object o=new Object();
    void m(){
        synchronized (o){
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        T t=new T();
        new Thread(()->t.m(),"Thead1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            System.out.println("线程2开始...");
        },"Thread2").start();
        t.o=new Object();  //这行代码改变了锁的对象，所以线程2可以执行。如果注释掉，线程2永远都不会执行。
    }
}
