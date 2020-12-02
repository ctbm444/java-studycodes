package yxxy.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 使用ReentrantLock也能实现
 * 与sychronized相比，ReentrantLock需要手动释放锁。
 * sychronized锁会在发生异常的时候自动释放，而ReentrantLock不会自动释放锁，所以需要放在finally
 * @author: yanxiaotian
 * @create: 2020-12-02 14:40
 **/
public class ReentrantLock2 {
    Lock lock=new ReentrantLock();
    void m1(){
        lock.lock();
        try {
            for(int i=0;i<5;i++){
                System.out.println("m1...");
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    void m2(){
        lock.lock();
        System.out.println("m2 start");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLock2 r=new ReentrantLock2();
        new Thread(r::m1,"t1").start();
        new Thread(()->r.m2(),"t2").start();
    }
}
