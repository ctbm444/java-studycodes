package yxxy.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * 使用ReentrantLock还可以调用lockInterruptibly方法，可以对线程interrupt方法做出响应，
 * 在一个线程等待锁的过程中，可以被打断
 * @author: yanxiaotian
 * @create: 2020-12-02 14:40
 **/
public class ReentrantLock4 {
    Lock lock=new ReentrantLock();
    void m1(){
        lock.lock();
        try {
            for(int i=0;i<5;i++){
                System.out.println("m1...");
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            System.out.println("m1 interrupted");
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     *使用trylock进行锁定时，无论是否锁定成功，方法都会继续执行
     *可以通过trylock的返回值判断是否锁定成功
     */
    void m2(){
        try {
            lock.lockInterruptibly();//对t2.interrupt()做出响应
            System.out.println("m2 start");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("m2 end");
        } catch (InterruptedException e) {
            System.out.println("t2 interrupted");
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock4 r=new ReentrantLock4();
        new Thread(r::m1,"t1").start();
        Thread t2=new Thread(()->r.m2(),"t2");
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();//打断t2的等待
    }
}
