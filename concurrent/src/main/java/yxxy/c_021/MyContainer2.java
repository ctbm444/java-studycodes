package yxxy.c_021;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * 面试题：写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 * 使用ReentrantLock来实现
 * @author: yanxiaotian
 * @create: 2020-12-02 16:14
 **/
public class MyContainer2<T> {
    final private LinkedList<T> list=new LinkedList<T>();
    final private static int MAX=10;

    private final ReentrantLock lock=new ReentrantLock();
    private Condition producer=lock.newCondition();
    private Condition consumer=lock.newCondition();

    void put(T t){
        while(list.size()==MAX){
            lock.lock();
            try {
                producer.await();
                list.add(t);
                System.out.println(t+"生产一个产品");
                producer.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    T get(){
        T t=null;
        while(list.size()==0){
            try {
                consumer.await();
                t=list.removeFirst();
                consumer.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        return t;
    }

    int getCount(){
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer2 container1=new MyContainer2();

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
