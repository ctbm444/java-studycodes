package yxxy.c_001;

/**
 * @description:
 * @author: yanxiaotian
 * @create: 2020-11-17 15:53
 **/
public class T {
    private int m=0;
    Object o=new Object();
    public void m(){
        synchronized (o){
            m++;
            System.out.println(Thread.currentThread().getName()+",m="+m);
        }
    }

}
