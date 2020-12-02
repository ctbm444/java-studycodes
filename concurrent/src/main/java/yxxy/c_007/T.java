package yxxy.c_007;

/**
 * @description: 同步方法和非同步方法是否可以同时调用？  答：可以。m1和m2可以同时调用。
 * @author: yanxiaotian
 * @create: 2020-12-01 10:39
 **/
public class T {

    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName()+",m1 start...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+",m1 end...");
    }

    public synchronized void m2(){
        System.out.println(Thread.currentThread().getName()+",m2 start... ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+",m2 end...");
    }

    public static void main(String[] args) {
        T t=new T();
        /*new Thread(()->t.m1(),"t1").start();
        new Thread(()->t.m1(),"t3").start();
        new Thread(()->t.m2(),"t2").start();*/
        new Thread(t::m1,"t1").start();
        new Thread(t::m2,"t2").start();
        new Thread(t::m1,"t3").start();
    }
}
