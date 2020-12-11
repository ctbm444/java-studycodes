package yxxy.c_026;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @description: 认识Future
 * @author: yanxiaotian
 * @create: 2020-12-09 08:57
 **/
public class T06_Future {
    public static void main(String[] args) throws ExecutionException,InterruptedException {
        FutureTask<Integer> task=new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.MILLISECONDS.sleep(500);
                return 1000;
            }
        });
        new Thread(task).start();

        System.out.println(task.get());

        ExecutorService service= Executors.newFixedThreadPool(5);
        Future<Integer> f = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.MILLISECONDS.sleep(500);
                return 1;
            }
        });

        System.out.println(f.get());
        System.out.println(f.isDone());
        //ArrayList
        //HashMap
    }
}
