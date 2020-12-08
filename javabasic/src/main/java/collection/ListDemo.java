package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description: ArrayList的demo  ArrayList是有序可重复容器
 * @author: yanxiaotian
 * @create: 2020-11-26 17:37
 **/
public class ListDemo {
    public static void main(String[] args) {
        /**
         * 实现randomaccess接口，get方法中判断如果是randomaccess实例，则使用下标二级制查找算法。查询O(1),增删效率低
         */
        ArrayList list=new ArrayList();
        LinkedList list1=new LinkedList();//双向链表 增删快，查询O(n)
        Vector list2=new Vector();//底层是arraylist加synchronized关键字
        Stack list3=new Stack();//Vector的子类，FILO（first in last out）先进后出
        /**
         * 内部数组用volatile 和transient修饰。实现读写分离的思想。写加锁，读不加锁。
         * 写操作时，会复制出数组副本，复制结束后再指向引用。
         * 缺点：1.内存消耗大 2.不能保证实时的读写一致性，只能保证最终读写一致性。
         */
        CopyOnWriteArrayList list4=new CopyOnWriteArrayList();
        /**
         * Arraylist 查找元素调用的算法，判断有没有实现RandomAccess接口。
         */
        Collections.binarySearch(list,"1");


        //可以添加null
        /*list.add(null);
        System.out.println(list);
        list.remove(null);
        System.out.println(list);
        list.clear();
        list1.add(1);
        list3.push(1);
        list3.pop();
        System.out.println(list4.addIfAbsent(1));
        System.out.println(list4.addIfAbsent(1));*/

        /**
         * CopyOnWriteArrayList测试
         * CopyOnWriteArrayList的迭代器只能读到它创建之前的元素。iterator创建之后，对list修改，iterator是不知道的。除非新建一个iterator。
         */
        CopyOnWriteArrayList list5=new CopyOnWriteArrayList(new Integer[]{1,2,3});
        System.out.println(list5.toString());
        Iterator iterator1=list5.iterator();
        iterator1.forEachRemaining(System.out::println);//打印元素
        list5.add(4);
        Iterator iterator2=list5.iterator();
        iterator2.forEachRemaining(System.out::println);//打印元素
    }

    public boolean eq(Object o1,Object o2){
        return o1==null?o2==null:o1.equals(o2);
    }
}
