package yxxy.c_026;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description: 缓冲线程池
 * @author: yanxiaotian
 * @create: 2020-12-09 10:08
 **/
public class T08_CachedPool {
    public static void main(String[] args) throws InterruptedException{
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println(service);
        for(int i=0; i<2; i++){
            service.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println(service);
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println(service);
    }
}
