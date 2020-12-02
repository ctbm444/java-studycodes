package yxxy.c_010;

import java.util.concurrent.TimeUnit;

/**
 * @description: 一个同步方法可以调用另一个同步方法。一个线程已经获得了某对象的锁，还可以再次申请获得该对象的锁。
 * 即sychronized获得的是可重入锁。
 * 下面是子类调用父类的同步方法的情景
 * @author: yanxiaotian
 * @create: 2020-12-01 14:48
 **/
public class T {
    synchronized void m(){
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        Children c=new Children();
        new Thread(c::m,"thread1").start();
    }
}
class Children extends T{
    @Override
    synchronized void m() {
        System.out.println("child m start");
        super.m();
        System.out.println("child m end");
    }
}

