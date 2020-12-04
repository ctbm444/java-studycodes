package collection;

import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @description:  Set是无序不可重复容器。
 * @author: yanxiaotian
 * @create: 2020-12-04 09:38
 **/
public class SetDemo {
    public static void main(String[] args) {
        HashSet set1=new HashSet<>(); //hashset底层使用的是hashmap。
        TreeSet set2=new TreeSet<>();//treeset底层使用的是treemap。支持排序
        LinkedHashSet set3=new LinkedHashSet();//linkedhashset是hashset的子类，底层是linkedhashmap。遍历序和插入序是一致的。
        BitSet set4=new BitSet();//bitset底层是long数组。
        CopyOnWriteArraySet set5=new CopyOnWriteArraySet();//底层用的CopyOnWriteArrayList,唯一区别是add方法调用的是addifabsent
        /**
         * bitset 示例  用bitset去重
         */
        String str="abcdecd";
        BitSet used=new BitSet();
        System.out.println(used.size());
        for(int i=0;i<str.length();i++){
            used.set(str.charAt(i));
        }
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        int size=used.size();
        System.out.println(size);
        for(int i=0;i<size;i++){
            if(used.get(i)){
                sb.append((char)i);
            }
        }
        sb.append("]");
        System.out.println(used);
        System.out.println(sb);


    }
}
