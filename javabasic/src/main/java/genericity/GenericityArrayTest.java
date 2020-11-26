package genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 泛型数组测试类
 * @author: yanxiaotian
 * @create: 2020-11-26 15:14
 **/
public class GenericityArrayTest {
    public static void main(String[] args) {
        //泛型数组必须要用通配符方式，否则就会报错。
        //List<String>[] list1=new List<String>[10];
        List<?>[] lsa=new List<?>[10];
        Object o=lsa;
        Object[] oa=(Object[])o;
        List<Integer> list=new ArrayList<Integer>();
        list.add(3);
        oa[1]=list;
        Integer i=(Integer)lsa[1].get(0);
        System.out.println(i);
    }
}
