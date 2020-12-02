package yxxy.c_021;

import java.util.LinkedList;

/**
 * @description:
 * 面试题：写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 * 使用wait和notify/notifyAll来实现
 * @author: yanxiaotian
 * @create: 2020-12-02 16:14
 **/
public class MyContainer1<T> {
    final private LinkedList<T> list=new LinkedList<T>();
    final private static int MAX=10;

    synchronized void put(T t){
        while(list.size()==MAX){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        System.out.println(t+"生产一个产品");
        this.notifyAll();
    }

    synchronized T get(){
        while(list.size()==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t=list.removeFirst();
        this.notifyAll();
        return t;
    }

    int getCount(){
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer1 container1=new MyContainer1();

        for(int i=0;i<10;i++){
            new Thread(()->{
                for(int j=0;j<5;j++){
                    System.out.println(container1.get()+"的产品被消费");
                }
            },"consumer"+i).start();
        }
        for(int i=0;i<2;i++){
            new Thread(()->{
                for(int j=0;j<25;j++){
                    container1.put(Thread.currentThread().getName());
                }
            },"producer"+i).start();
        }
    }
}
