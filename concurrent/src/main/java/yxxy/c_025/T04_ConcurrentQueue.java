package yxxy.c_025;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @description:
 * @author: yanxiaotian
 * @create: 2020-12-08 16:05
 **/
public class T04_ConcurrentQueue {
    public static void main(String[] args) {
        Queue<String> queue= new ConcurrentLinkedQueue();

        for(int i=0; i<10;i++){
            queue.offer("a"+i);
        }

        System.out.println(queue);
        System.out.println(queue.element());
        System.out.println(queue.size());

        System.out.println(queue.peek());
        System.out.println(queue.size());

        System.out.println(queue.poll());
        System.out.println(queue.size());

    }
}
