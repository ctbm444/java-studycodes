package yxxy.c_026;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description: 单线程池
 * @author: yanxiaotian
 * @create: 2020-12-10 08:45
 **/
public class T09_SingleThreadPool {
    public static void main(String[] args) throws InterruptedException{
        ExecutorService service = Executors.newSingleThreadExecutor();
        for(int i=0; i<5; i++){
            TimeUnit.SECONDS.sleep(1);
            service.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
    }
}
