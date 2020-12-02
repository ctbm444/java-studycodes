package yxxy.c_014;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 与c_013对比，volatile不能替代synchronized, volatile只能保证可见性，不能保证原子性。
 * @author: yanxiaotian
 * @create: 2020-12-01 16:26
 **/
public class T {
    int count=0;
    synchronized void m(){
        for(int i=0;i<10000;i++){count++;}
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
