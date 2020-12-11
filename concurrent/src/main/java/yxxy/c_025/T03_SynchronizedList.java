package yxxy.c_025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: yanxiaotian
 * @create: 2020-12-08 16:03
 **/
public class T03_SynchronizedList {
    public static void main(String[] args) {
        List strs=new ArrayList();
        List list= Collections.synchronizedList(strs);
    }
}
