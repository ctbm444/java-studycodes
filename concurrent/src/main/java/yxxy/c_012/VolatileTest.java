package yxxy.c_012;

/**
 * @description: 测试volatile关键字
 * @author: yanxiaotian
 * @create: 2020-12-01 16:10
 **/
public class VolatileTest {
    volatile int a=5;
    public static void main(String[] args) {
        VolatileTest v=new VolatileTest();
        v.a++;
        System.out.println(v.a);
    }
}
