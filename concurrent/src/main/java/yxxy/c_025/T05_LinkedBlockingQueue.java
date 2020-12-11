package yxxy.c_025;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: yanxiaotian
 * @create: 2020-12-08 16:11
 **/
public class T05_LinkedBlockingQueue {
    static BlockingQueue<String> strs=new LinkedBlockingQueue<>();
    static Random random=new Random();

    public static void main(String[] args) {
        new Thread(()->{
            for(int i=0; i<100; i++){
                try {
                    strs.put("a"+i); // 如果满了就会等待
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"producer").start();

        for(int i=0; i<5; i++){
            new Thread(() -> {
                for(;;){
                    try {
                        System.out.println(Thread.currentThread().getName() + "take " +strs.take() );//如果空了，就会等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "consumer"+i).start();
        }
    }
}
