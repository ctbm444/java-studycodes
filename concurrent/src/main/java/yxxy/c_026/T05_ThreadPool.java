package yxxy.c_026;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description: 线程池 ThreadPool
 * @author: yanxiaotian
 * @create: 2020-12-09 08:48
 **/
public class T05_ThreadPool {
    public static void main(String[] args) throws InterruptedException{
        ExecutorService service= Executors.newFixedThreadPool(5);
        for(int i=0;i<6;i++){
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread());
                }
            });
        }
        System.out.println(service);

        //service.shutdown();
        service.shutdownNow();
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());

        TimeUnit.SECONDS.sleep(5);
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
    }
}
