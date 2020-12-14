package yxxy.c_026;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: 线程池执行器
 * @author: yanxiaotian
 * @create: 2020-12-14 16:51
 **/
public class T13_ThreadPoolExecutor {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(5,10,
                TimeUnit.SECONDS.toSeconds(100),TimeUnit.SECONDS,new LinkedBlockingQueue<>(10));
    }
}
