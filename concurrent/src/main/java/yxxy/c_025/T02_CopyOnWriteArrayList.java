package yxxy.c_025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description: CopyOnWriteArrayList
 *写的时候复制容器
 *多线程环境下，写时效率低，读时效率高。
 *适合写少读多的场景
 * @author: yanxiaotian
 * @create: 2020-12-08 15:46
 **/
public class T02_CopyOnWriteArrayList {
    public static void main(String[] args) {
        List list=//new ArrayList();//有并发问题！
                // new Vector(); // 94 96
                new CopyOnWriteArrayList(); // 94  100
        Random random=new Random();
        Thread[] ts=new Thread[100];
        for(int i=0;i<ts.length;i++){
            ts[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    list.add("a"+random.nextInt());
                }
            });
        }
        System.out.println(computeTime(ts));

    }

    static long computeTime(Thread[] ts){
        long start=System.currentTimeMillis();
        Arrays.asList(ts).forEach(o -> o.start());
        Arrays.asList(ts).forEach(o -> {
            try {
                o.join(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end=System.currentTimeMillis();
        return end-start;
    }
}
