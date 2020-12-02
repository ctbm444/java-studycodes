package yxxy.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * ReentrantLock可以进行尝试锁定 tryLock
 * @author: yanxiaotian
 * @create: 2020-12-02 14:40
 **/
public class ReentrantLock3 {
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

    /**
     *使用trylock进行锁定时，无论是否锁定成功，方法都会继续执行
     *可以通过trylock的返回值判断是否锁定成功
     */
    void m2(){
        boolean locked=false;
        try {
            locked=lock.tryLock(6,TimeUnit.SECONDS);
            if(locked){
                System.out.println("m2 locked");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(locked){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock3 r=new ReentrantLock3();
        new Thread(r::m1,"t1").start();
        new Thread(()->r.m2(),"t2").start();
    }
}
