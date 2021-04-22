package excercise;

import org.openjdk.jol.info.ClassLayout;

/**
 * @description: 标记字打印测试
 * @author: yanxiaotian
 * @create: 2021-04-22 15:36
 **/
public class MarkwordTest {

    public static void main(String[] args) throws Exception{
        Object o=new Object();
        Thread.sleep(5000);
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
