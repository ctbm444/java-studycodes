package yxxy.c_025;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**
 * @description:  几种线程安全map的put性能测试
 * @author: yanxiaotian
 * @create: 2020-12-08 15:29
 **/
public class T01_ConcurrentMap {
    public static void main(String[] args) {
        //Map<String,String> map= new ConcurrentHashMap<>(); //530  370  348  378
        //Map<String,String> map=new ConcurrentSkipListMap<>(); //高并发且排序  628 521 558 601
        // Map<String,String> map=new Hashtable<>(); // 688 489 483 513
        Map<String,String> map= Collections.synchronizedMap(new HashMap<>()); // 519 502 581 528
        Random random=new Random();
        Thread[] ts=new Thread[100];
        CountDownLatch latch=new CountDownLatch(ts.length);
        Long start=System.currentTimeMillis();
        for(int i=0;i<ts.length;i++){
            ts[i]=new Thread(() -> {
                for(int j=0; j<10000;j++){
                    map.put("a"+random.nextInt(10000),"a"+random.nextInt(10000));
                }
                latch.countDown();
            },"t"+i);
        }
        Arrays.asList(ts).forEach(o -> o.start());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}
