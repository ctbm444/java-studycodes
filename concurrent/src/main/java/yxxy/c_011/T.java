package yxxy.c_011;

import javax.print.attribute.standard.MediaSize;
import java.util.concurrent.TimeUnit;

/**
 * @description: 程序在执行过程中，如果出现异常，默认会释放锁。
 * @author: yanxiaotian
 * @create: 2020-12-01 15:23
 **/
public class T {
    int m=0;
    synchronized void m(){
        System.out.println(Thread.currentThread().getName()+" start...");
        while(true){
            m++;
            System.out.println(Thread.currentThread().getName()+" m="+m);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(m==5){
                int n=1/0;  //此处抛出异常，锁会被释放，要想不被释放，可以进行catch，然后循环继续
                System.out.println(n);
            }
        }
    }

    public static void main(String[] args) {
        T t=new T();
        Runnable r=new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        };
        new Thread(r,"thread1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r, "thread2").start();
    }
}
