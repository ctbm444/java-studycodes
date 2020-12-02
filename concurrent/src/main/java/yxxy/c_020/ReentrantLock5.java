package yxxy.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: ReentrantLock 实现公平锁
 * @author: yanxiaotian
 * @create: 2020-12-02 15:27
 **/
public class ReentrantLock5 extends Thread{
    private static Lock lock=new ReentrantLock(true);

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock5 r=new ReentrantLock5();
        for(int i=0;i<2;i++){
            new Thread(r,"t"+i).start();
        }
    }
}
