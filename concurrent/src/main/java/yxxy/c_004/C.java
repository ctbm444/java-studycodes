package yxxy.c_004;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: yanxiaotian
 * @create: 2020-11-17 16:21
 **/
public class C implements Runnable {
    public int count=0;

    public static void main(String[] args) {
        C c1=new C();
        C c2=new C();
        /*List<Thread> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(new Thread(c,"Thread"+i));
        }
        list.forEach(t->{
            t.start();
        });*/
        Thread t1=new Thread(c1,"t1");
        Thread t2=new Thread(c2,"t2");
        t1.start();
        t2.start();

    }

    /*@Override
    public synchronized void run() {
        count++;
        System.out.println(Thread.currentThread().getName()+",count="+count);
    }*/

    public void run() {
        synchronized (C.class){
            for(int i=0;i<10;i++){
                count++;
                System.out.println(Thread.currentThread().getName()+",count="+count);
            }
        }
    }
}
