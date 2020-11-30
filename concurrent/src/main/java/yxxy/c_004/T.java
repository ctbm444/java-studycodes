package yxxy.c_004;

/**
 * @description: 在静态方法上加synchronized关键字，相当于加类锁，即synchronized(T.class)
 * @author: yanxiaotian
 * @create: 2020-11-17 15:53
 **/
public class T {
    private static int count = 0;
    public synchronized static void m(){//这里相当于synchronized(T.class)
        count++;
        System.out.println(Thread.currentThread().getName());
    }

    public static void m2(){
        //此处synchronized (T.class)不能替换为synchronized(this)，synchronized (T.class)是类锁，所有这个类的对象公用一个把锁。
        synchronized (T.class){
            count++;
            System.out.println(234);
        }
    }

    public static void main(String[] args) {

    }
}
