package yxxy.c_004;

/**
 * @description:
 * @author: yanxiaotian
 * @create: 2020-11-17 15:53
 **/
public class T {
    private static int count = 0;
    public synchronized static void m(){
        count++;
        System.out.println(Thread.currentThread().getName());
    }

    public static void m2(){
        synchronized (T.class){
            count++;
            System.out.println(234);
        }
    }

    public static void main(String[] args) {

    }
}
