package yxxy.c_025;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @description:  SynchronousQueue 容量为1的阻塞队列
 * @author: yanxiaotian
 * @create: 2020-12-08 16:54
 **/
public class T09_SynchronousQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue strs = new SynchronousQueue();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(strs.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        strs.put("aaa"); //阻塞等待消费者消费
        strs.add("bbb");

        System.out.println(strs.size());
    }
}
