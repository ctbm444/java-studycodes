package yxxy.c_026;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @description: 线程池应用
 * @author: yanxiaotian
 * @create: 2020-12-09 09:33
 **/
public class T07_ParallelComputing {
    public static void main(String[] args) throws ExecutionException,InterruptedException {
        long start=System.currentTimeMillis();
        getPrime(1,200000);
        long end=System.currentTimeMillis();
        System.out.println(end-start);


        MyTask task1=new MyTask(1,50000);
        MyTask task2=new MyTask(50001,100000);
        MyTask task3=new MyTask(100001,150000);
        MyTask task4=new MyTask(150000,200000);
        final int coreCpuNum = 4;
        ExecutorService service = Executors.newFixedThreadPool(coreCpuNum);

        Future<List<Integer>> future1=service.submit(task1);
        Future<List<Integer>> future2=service.submit(task2);
        Future<List<Integer>> future3=service.submit(task3);
        Future<List<Integer>> future4=service.submit(task4);

        start=System.currentTimeMillis();
        future1.get();
        future2.get();
        future3.get();
        future4.get();
        end=System.currentTimeMillis();
        System.out.println(end-start);
    }



    static class MyTask implements Callable{
        int startPos,endPos;
        MyTask(int start, int end){
            this.startPos=start;
            this.endPos=end;
        }
        @Override
        public List<Integer> call() throws Exception {
            List<Integer> list = getPrime(startPos, endPos);
            return list;
        }
    }

    static boolean isPrime(int m){
        for(int i=2; i<m/2; i++){
            if(m % i ==0){
                return false;
            }
        }
        return true;
    }

    static List<Integer> getPrime(int start, int end){
        List<Integer> list = new ArrayList<>();
        for(int i=start; i<end; i++){
            if(isPrime(i)){
                list.add(i);
            }
        }
        return list;
    }
}
