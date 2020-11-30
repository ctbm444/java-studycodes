package yxxy.c_003;

/**
 * @description:
 * @author: yanxiaotian
 * @create: 2020-11-26 15:37
 **/
public class T {
    private int count = 10;
    public synchronized void m(){//在方法上加synthronized，相当于对方法内所有代码加一个synchronized(this)
        count--;
        System.out.println(Thread.currentThread().getName()+"count");
    }
}
