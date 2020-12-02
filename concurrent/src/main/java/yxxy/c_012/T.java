package yxxy.c_012;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: yanxiaotian
 * @create: 2020-12-01 15:36
 **/
public class T {
    volatile boolean flag =true;//比较有无volatile的区别
    void m(){
        System.out.println("m start");
        while(flag){
            /*try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        T t=new T();
        new Thread(t::m,"thread1").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()-> t.flag=false).start();
    }
}
