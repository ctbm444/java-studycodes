package yxxy.c_002;

/**
 * @description: synchronized关键字对某个对象加锁
 * @author: yanxiaotian
 * @create: 2020-11-17 15:53
 **/
public class T {
    private int m=0;
    private int n=0;
    Object o=new Object();
    public void m(){
        synchronized (this){
            m++;
            System.out.println(Thread.currentThread().getName()+",m="+m);
        }
    }
    public synchronized void m2(){
        m++;
    }

    public void m3(){
        m++;
        synchronized (this){//任何线程想要执行下面的代码，必须先拿到this的锁。
            n++;
        }
    }


}
