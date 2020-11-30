package yxxy.c_001;

/**
 * @description: synchronized关键字是对对象进行加锁
 * @author: yanxiaotian
 * @create: 2020-11-17 15:53
 **/
public class T {
    private int m=0;
    Object o=new Object();
    public void m(){
        synchronized (o){//任何线程要想执行下面的代码，必须先拿到o的锁
            m++;
            System.out.println(Thread.currentThread().getName()+",m="+m);
        }
    }

}
