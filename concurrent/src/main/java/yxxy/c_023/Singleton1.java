package yxxy.c_023;

/**
 * @description: 单例模式 双重校验
 * 注意点 1.重写无参构造器为private 2.instance除了用static修饰，还要用volatile。
 *
 * 类锁的作用？
 * 多个线程同时new单例对象时，
 * 为什么用volatile？
 * instance=new Singleton1()在cpu中需要三步，第一步分配内存空间，第二步初始化对象，第三步将instance指向内存空间。
 * 指令重排会导致第二步和第三步顺序交换。单线程下这样并没有问题。多线程下，如果A线程已经将instance指向了内存空间，但是还没有初始化对象。
 * 这时候B线程判断instance已经不是null，导致出错。
 * @author: yanxiaotian
 * @create: 2020-12-03 10:55
 **/
public class Singleton1 {
    private volatile static Singleton1 instance = null;
    private Singleton1(){}
    public static Singleton1 getInstance(){
        if(instance == null){
            synchronized (Singleton1.class){
                if(instance == null){
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for(int j=0;j<2;j++){
            new Thread(()->{
                long start=System.currentTimeMillis();
                for(int i=0;i<10000;i++){
                    Singleton1 s=Singleton1.getInstance();
                    System.out.println(s);
                    s=null;
                }
                System.out.println((System.currentTimeMillis()-start));
            }).start();
        }

    }
}
