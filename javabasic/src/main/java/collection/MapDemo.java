package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: map 示例类
 * @author: yanxiaotian
 * @create: 2020-12-07 16:03
 **/
public class MapDemo {

    public static void main(String[] args) {
        /**
         * HashMap
         * 底层是数组+链表/红黑树，键值对集合，非线程安全。
         * key、value都可以为空。key重复时覆盖value。遍历时的顺序基本不可能是put的顺序。
         *
         * 源码阅读：
         * 默认容量是设置容量的下一个2的次数，通过5次和逻辑右移位做按位或运算。如容量设置为12，则实际容量为16。若为40，则为64。
         * hash算法：h=key.hashcode() ^ (h >>> 16) 高十六位和低十六位做异或运算。保证高十六位的变化能反映到低十六位上。
         * 计算index：n=table.length;index=(n-1) & hash; (n-1) & hash等价于h%n,但效率更高。
         * 关键方法：putval()。如果值为空，直接放入。如果值不为空，且key是相等的，替换值；如果key不相等，先判断红黑树，再判断链表。
         *
         * 多线程问题：jdk1.8中会导致数据丢失问题。如果两个线程在同时put的时候，如果index相同且都到达链表末尾，后一个线程的值会覆盖前一个线程的值。
         */
        HashMap hashMap=new HashMap(10);
        /**
         * Hashtable
         * 基于哈希表实现的，通过sychronized关键字保证线程安全。
         * hash=key.hashcode; index=(hash & 0x7FFFFFFF) % table.length;
         */
        Hashtable hashtable=new Hashtable(10);
        /**
         * LinedHashMap 继承了HashMap  底层是数组+链表/红黑树+环形双向链表
         * HashMap是无序的。LinkedHashMap通过维护一个双向链表，来保证迭代的顺序。
         *
         */
        LinkedHashMap linkedHashMap=new LinkedHashMap(10);
        /**
         * TreeMap
         * 1.支持排序的Map实现  2.基于红黑树，无容量限制 3.非线程安全 4.效率没有HashMap高，key不能为null
         * 红黑树：红黑树是一种可以自平衡的二叉查找树。通过变色或旋转进行自平衡。
         */
        TreeMap treeMap=new TreeMap();
        /**
         * ConcurrentHashMap
         * jdk1.7以前，通过分段锁
         * jdk1.8以后，通过CAS+synchronized实现
         *  最高可以16个线程并发无阻塞操作集合对象
         */
        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap(10);
        /**
         * ConcurrentSkipListMap
         * key是有序的
         * 支持更高的并发。数据量一定的情况下，并发线程越多，ConcurrentSkipListMap越能体现出他的优势。
         */
        ConcurrentSkipListMap concurrentSkipListMap=new ConcurrentSkipListMap();

        /**
         * 同步集合包装 Collections.synchronizedXXX
         */
        Map map1=Collections.synchronizedMap(new HashMap<>());
        Map map2= Collections.unmodifiableMap(new HashMap<>());//获取一个不可变集合
        Map map3=Collections.emptyMap();//获取一个空map

        Collections.sort(new ArrayList<String>(), (o1,o2) -> Integer.parseInt(o1)-Integer.parseInt(o2));

    }

}
