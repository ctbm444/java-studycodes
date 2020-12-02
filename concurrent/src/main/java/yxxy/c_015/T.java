package yxxy.c_015;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: Atom原子类的方法都是原子性的，但是不能保证多个方法是原子性的。
 * @author: yanxiaotian
 * @create: 2020-12-01 16:26
 **/
public class T {
    AtomicInteger count=new AtomicInteger(0);
    void m(){
        for(int i=0;i<10000;i++){count.getAndIncrement();}
    }

    public static void main(String[] args) {
        T t=new T();
        List<Thread> threads=new LinkedList<>();
        for(int i=0; i<10; System.out.println("哈哈"+i) ){
            threads.add(new Thread(t::m,"Thread"+i));
            i++;
        }
        long start=System.currentTimeMillis();
        threads.forEach(o->o.start());
        threads.forEach(o->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.count);
        long time=(System.currentTimeMillis()-start);
        System.out.println(time);
    }
}
