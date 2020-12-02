package yxxy.c_006;

/**
 * @description:
 * @author: yanxiaotian
 * @create: 2020-12-01 10:24
 **/
public class T implements Runnable{

    public int count =10;
    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName()+",count="+count);
    }

    public static void main(String[] args) {
        yxxy.c_005.T t=new yxxy.c_005.T();
        for(int i=0;i<5;i++){
            new Thread(t,"t"+i).start();
        }
    }
}
