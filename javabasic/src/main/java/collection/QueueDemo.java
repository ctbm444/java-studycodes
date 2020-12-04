package collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description: 队列 示例
 * @author: yanxiaotian
 * @create: 2020-12-04 15:57
 **/
public class QueueDemo {
    public static void main(String[] args) {
        //linkedlist和arraydeque是deque的实现，一个是先进先出，一个是先进后出。相当于实现了queue和stack。
        Deque list1=new LinkedList();//linkedList实现了deque接口，deque接口实现了queue接口
        Deque deque=new ArrayDeque();//底层是循环数组,每次扩容2倍
        ConcurrentLinkedQueue queue=new ConcurrentLinkedQueue();//底层是链表，基于cas的非阻塞队列，无界队列
        ConcurrentLinkedDeque deque1=new ConcurrentLinkedDeque();//底层是双向链表，基于cas的非阻塞队列，无界队列
        PriorityQueue queue1=new PriorityQueue();//底层是数组，逻辑上是小顶堆，无界队列。数组是基于完全二叉树

        ArrayBlockingQueue queue2=new ArrayBlockingQueue(10,true);//底层是数组，阻塞队列，有界同步队列。一把锁，两个condition
        LinkedBlockingQueue queue3=new LinkedBlockingQueue(10);//底层是链表，阻塞队列，无界同步队列。两把锁，各有一个condition
        queue1.offer(5);
        queue1.offer(4);
        queue1.offer(9);
        System.out.println(queue1);
    }
}
