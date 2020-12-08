package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;

/**
 * @description:  bitset 示例
 * 使用场景：可以用于海量数据的日志分析、用户数统计。如将40个数据进行排序、去重
 * @author: yanxiaotian
 * @create: 2020-12-04 14:09
 **/
public class BitsetDemo {
    public static void main(String[] args) {
        //containChars("edbca");
        //sortArray(new int[]{8,9,2,3,9999,5555,22,2,3,8});
        getNotExistNumber();
    }

    /**
     * 查询字符串中包含哪些字符。即字符串去重
     * @param str
     */
    public static void containChars(String str){
        BitSet set=new BitSet();
        for(int i=0;i<str.length();i++){
            set.set(str.charAt(i));
        }
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(int i=0;i<set.size();i++){
            if(set.get(i)){
                sb.append((char)i);
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    /**
     *  排序数组
     */
    public static void sortArray(int[] array){
        //虽然有默认容量，但是尽量估算大小。
        BitSet bitSet=new BitSet(2 <<13);
        System.out.println("bitset size："+bitSet.size());
        for(int i=0; i<array.length; i++){
            bitSet.set(array[i]);
        }
        //剔除重复数字后的元素个数
        int bitLen=bitSet.cardinality();
        System.out.println("bitset size:"+bitSet.size());
        System.out.println("bitset bitLent:"+bitLen);
        //进行排序，即把bit为true的元素复制到另一个数组
        int[] orderArray=new int[bitLen];
        int k=0;
        for(int i=bitSet.nextSetBit(0);i>=0;i=bitSet.nextSetBit(i+1)){
            orderArray[k++]=i;
        }
        System.out.println("after order...");
        for(int i=0;i<bitLen;i++){
            System.out.print(orderArray[i]+"\t");
        }
    }

    /**
     * 面试题：有1千万个随机数，随机数的范围在1到1亿之间。现在要求写出一种算法，将1到1亿之间没有在随机数中的数求出来？
     */
    public static void getNotExistNumber(){
        Random random=new Random();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0; i<10000000; i++){
            list.add(random.nextInt(100000000));
        }
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        BitSet set=new BitSet(100000000);
        list.forEach(o -> set.set(o));
        LinkedList numberNotExist=new LinkedList();
        for(int i=0; i<100000000;i++){
            if(!set.get(i)){
                numberNotExist.add(i);
            }
        }
        System.out.println("over");
        System.out.println(numberNotExist.contains(list.get(0)));
        System.out.println(numberNotExist.contains(list.get(1)));
        System.out.println(numberNotExist.contains(list.get(2)));

    }

}
