package yxxy.c_021;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * 面试题：写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 * 使用ReentrantLock来实现
 * condition 能够更加精细的控制多线程的休眠与唤醒
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
        lock.lock();
        try {
            while(list.size()==MAX){
                producer.await();
            }
            list.add(t);
            System.out.println(t+"生产一个产品");
            consumer.signalAll();//通知所有消费者
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    T get(){
        T t=null;
        try {
            lock.lock();
            while(list.size()==0){
                consumer.await();
            }
            t=list.removeFirst();
            producer.signalAll();//通知所有生产者
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
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
                    System.out.println(Thread.currentThread().getName()+"消费了"+container1.get()+"的产品被消费");
                }
            },"consumer"+i).start();
        }
/*        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        for(int i=0;i<2;i++){
            new Thread(()->{
                for(int j=0;j<25;j++){
                    container1.put(Thread.currentThread().getName());
                }
            },"producer"+i).start();
        }
    }
}
