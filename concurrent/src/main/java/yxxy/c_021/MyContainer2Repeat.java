package yxxy.c_021;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 重写一遍 MyContainer2
 * @author: yanxiaotian
 * @create: 2020-12-03 09:53
 **/
public class MyContainer2Repeat<T> {
    private final LinkedList<T> list=new LinkedList<>();
    final private static int MAX=10;
    ReentrantLock lock=new ReentrantLock();
    Condition producer=lock.newCondition();
    Condition consumer=lock.newCondition();

    void put(T t){
        lock.lock();
        try {
            while(list.size()==MAX){
                producer.await();
            }
            list.add(t);
            System.out.println(t+"生产了一个产品");
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    T get(){
        T t=null;
        lock.lock();
        try {
            while(list.size()==0){
                consumer.await();
            }
            t=list.removeFirst();
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        MyContainer2Repeat container=new MyContainer2Repeat();
        for(int i=0;i<10;i++){
            new Thread(()->{
                for(int j=0;j<5;j++){
                    System.out.println(Thread.currentThread().getName()+"消费了"+container.get()+"生产的产品被消费");
                }
            },"c"+i).start();
        }
        for(int i=0;i<2;i++){
            new Thread(()->{
                for(int j=0;j<25;j++){
                    container.put(Thread.currentThread().getName());
                }
            },"p"+i).start();
        }
    }
}
