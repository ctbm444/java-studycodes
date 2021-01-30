package excercise;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: yanxiaotian
 * @create: 2020-12-23 11:09
 **/
public class ThreadDemo1 {
    static int count=20;
    public static void main(String[] args) throws Exception{
        final Object o=new Object();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    do{
                        try {
                            if(count%2==1){
                                o.wait();
                            }
                            o.notify();
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        count--;
                        System.out.println(Thread.currentThread().getName()+":count="+count);
                    }while(count>1);
                }
            }
        },"t1");
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    do{
                        try {
                            if(count%2==0){
                                o.wait();
                            }
                            o.notify();
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        count--;
                        System.out.println(Thread.currentThread().getName()+":count="+count);
                    }while(count>1);
                }
            }
        },"t2");
        System.out.println("t1 is alive:"+t1.isAlive());
        System.out.println("t2 is alive:"+t2.isAlive());
        t1.setPriority(1);
        t2.setPriority(2);
        t1.start();
        t2.start();
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        //.join();
        //t1.yield();
        Thread.sleep(1000);
        System.out.println("t1 is alive:"+t1.isAlive());
        System.out.println("t2 is alive:"+t2.isAlive());
    }
}
