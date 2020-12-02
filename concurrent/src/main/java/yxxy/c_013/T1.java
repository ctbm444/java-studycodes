package yxxy.c_013;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: volatile
 * @author: yanxiaotian
 * @create: 2020-12-01 16:26
 **/
public class T1 {
    AtomicInteger count=new AtomicInteger(0);
    void m(){
        for(int i=0;i<10000;i++){count.getAndIncrement();}
    }

    public static void main(String[] args) {
        T1 t=new T1();
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
