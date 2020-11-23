package yxxy.c_002;

/**
 * @description:
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
        synchronized (this){
            n++;
        }
    }


}
