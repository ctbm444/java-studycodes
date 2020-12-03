package yxxy.c_023;

import java.util.Arrays;

/**
 * @description: 单例模式 静态内部类
 * @author: yanxiaotian
 * @create: 2020-12-03 11:20
 **/
public class Singleton2 {
    private static class Holder{
        private static final Singleton2 instance=new Singleton2();
    }
    private Singleton2(){
        System.out.println("single");
    }
    public static Singleton2 getInstance(){
        return Holder.instance;
    }

    public static void main(String[] args) {
        Thread[] threads=new Thread[10];
        for(int i=0;i<10;i++){
            threads[i]=new Thread(()->{
                System.out.println(Singleton2.getInstance());
            });
        }
        Arrays.asList(threads).forEach(o-> o.start());
    }
}
