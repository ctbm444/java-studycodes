package collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * @description: 队列 示例
 * @author: yanxiaotian
 * @create: 2020-12-04 15:57
 **/
public class QueueDemo {
    public static void main(String[] args) {
        /***************非线程安全队列****************/
        //linkedlist和arraydeque是deque的实现，一个是先进先出，一个是先进后出。相当于实现了queue和stack。
        Deque list1=new LinkedList();//linkedList实现了deque接口，deque接口实现了queue接口
        Deque deque=new ArrayDeque();//底层是循环数组,每次扩容2倍。先进后出
        PriorityQueue priorityQueue=new PriorityQueue();//底层是数组，逻辑上是小顶堆，无界队列。数组基于完全二叉树

        /***************线程安全非阻塞队列****************/
        /**
         * 线程安全非阻塞队列，使用CAS机制保证线程安全。不需要加锁。
         */

        ConcurrentLinkedQueue concurrentLinkedQueue=new ConcurrentLinkedQueue();//底层是链表，基于cas的非阻塞队列，无界队列
        ConcurrentLinkedDeque concurrentLinkedDeque=new ConcurrentLinkedDeque();//底层是双向链表，基于cas的非阻塞队列，无界队列

        /***************线程安全阻塞队列****************/
        /**
         * 线程安全阻塞队列，使用锁保证线程安全。
         */

        /**
         * 基于数组、先进先出、线程安全的集合类。特点是实现指定时间的阻塞读写，并且容量是可限制的。
         */
        ArrayBlockingQueue arrayBlockingQueue=new ArrayBlockingQueue(10,true);//底层是数组，阻塞队列，有界同步队列。一把锁，两个condition
        /**
         * LinkedBlockingQueue的入队和出队各用一把锁，避免了入队、出队的锁竞争，高并发情况下性能比ArrayBlockingQueue好很多。
         * 遍历和删除时加两把锁。
         */
        LinkedBlockingQueue linkedBlockingQueue=new LinkedBlockingQueue();//底层是链表，阻塞队列，无界同步队列。两把锁，各有一个condition
        /**
         * 底层是双向链表，双端阻塞队列，无界同步队列。一把锁两个condition。
         */
        LinkedBlockingDeque linkedBlockingDeque=new LinkedBlockingDeque();
        /**
         * 底层是数组，出队时对空则阻塞。支持优先级的无界阻塞队列。不存在队满的情况。一把锁一个condition
         * 注意：不能保证同优先级的元素顺序
         */
        PriorityBlockingQueue priorityBlockingQueue=new PriorityBlockingQueue();
        /**
         * 底层是PriorityQueue,无界阻塞队列，过期元素方可移除。
         */
        DelayQueue delayQueue=new DelayQueue();
        /**
         *  实现了BlockingQueue
         */
        SynchronousQueue synchronousQueue=new SynchronousQueue(true);
        /**
         *  LinkedTransferQueue实现了TransferQueue接口，可以实现队列不满时的阻塞。
         *  LinkedTransferQueue实际上是ConcurrentLinkedQueue、LinkedBlockingQueue和SynchronousQueue的超集。
         *  不仅综合了这几个类，而且提供了更好的实现。
         */
        TransferQueue transferQueue=new LinkedTransferQueue();



        /**
         * 使用示例
         */
        list1.addFirst(1);
        list1.addFirst(2);
        list1.push(3);//栈方法  push是放到栈顶，即第一个位置  push和pop是栈方法
        System.out.println(list1);
        list1.offer(4);//队列方法 offer是放到队列末尾。 offer、poll、peek是队列方法
        System.out.println(list1);
        list1.removeLast();
        System.out.println(list1);

        deque.push(3);
        deque.push(4);
        System.out.println(deque);
        deque.pop();
        System.out.println(deque);


        priorityQueue.offer(5);
        priorityQueue.offer(4);
        priorityQueue.offer(9);
        System.out.println(priorityQueue);

        boolean flag2=arrayBlockingQueue.offer(1);
        arrayBlockingQueue.offer(3);
        concurrentLinkedQueue.peek();
        System.out.println("queue2:"+arrayBlockingQueue);
        System.out.println(arrayBlockingQueue.poll());
        System.out.println("queue2:"+arrayBlockingQueue);

        delayQueue.offer(new Delayed() {
            @Override
            public long getDelay(TimeUnit unit) {
                return unit.toSeconds(1);
            }

            @Override
            public int compareTo(Delayed o) {
                return 0;
            }
        });

        synchronousQueue.offer(1);
        synchronousQueue.offer(2);
        System.out.println(synchronousQueue);

    }
}
