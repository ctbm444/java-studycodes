package yxxy.c_026;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * @description:
 * @author: yanxiaotian
 * @create: 2020-12-10 11:16
 **/
public class T12_ForkJoinPool {
    static int[] num=new int[1000000];
    static final int MAX_NUM = 50000;
    static Random r= new Random();

    static{
        for(int i=0; i<num.length; i++){
            num[i]=r.nextInt(100);
        }
        System.out.println(Arrays.stream(num).sum());
        System.out.println(IntStream.of(num).sum());
        System.out.println(IntStream.concat(IntStream.of(num), IntStream.of(num)).sum());
        System.out.println((Arrays.stream(num)).parallel().sum());
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        ForkJoinPool fjp=new ForkJoinPool();
        AddTask task= new AddTask(0,num.length);
        fjp.execute(task);
        Long sum=task.join();
        System.out.println(sum);
    }

    static class AddTask extends RecursiveTask<Long> {
        private static final long serialVersionUID = 1L;
        int start, end;

        public AddTask(int s, int e) {
            start=s;
            end=e;
        }

        @Override
        protected Long compute() {
            if(end-start<= MAX_NUM){
                Long sum=0L;
                for(int i=start; i<end; i++){
                    sum+=i;
                }
                return sum;
            }
            int middle=start+(end-start)/2;
            AddTask subTask1=new AddTask(start,middle);
            AddTask subTask2=new AddTask(middle,end);
            subTask1.fork();
            subTask2.fork();
            return subTask1.join()+subTask2.join();
        }
    }
}
