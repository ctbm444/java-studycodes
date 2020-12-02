package yxxy.c_020;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * reentrantlock用于替代synchronized
 * 本例中由于m1锁定this,只有m1执行完毕的时候,m2才能执行
 * 这里是复习synchronized最原始的语义
 * @author: yanxiaotian
 * @create: 2020-12-02 14:34
 **/
public class ReentrantLock1 {
    synchronized void m1(){
        System.out.println("m1 start");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1 end");
    }
    synchronized void m2(){
        System.out.println("m2 start");
    }

    public static void main(String[] args) {
        ReentrantLock1 r=new ReentrantLock1();
        new Thread(r::m1,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r::m2,"t2").start();
    }
}
