package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: ArrayList的demo
 * @author: yanxiaotian
 * @create: 2020-11-26 17:37
 **/
public class ListDemo {
    public static void main(String[] args) {
        List list=new ArrayList();
        //可以添加null
        list.add(null);
        System.out.println(list);
        list.remove(null);
        System.out.println(list);

    }
}
