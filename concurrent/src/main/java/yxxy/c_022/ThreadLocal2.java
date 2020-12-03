package yxxy.c_022;

import java.util.concurrent.TimeUnit;

/**
 * @description: ThreadLocal 演示类
 * Thread是用空间换时间，synchronized是用时间换空间
 *
 * @author: yanxiaotian
 * @create: 2020-12-03 10:38
 **/
public class ThreadLocal2 {
    static ThreadLocal<Person> tl=new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(()->{
            tl.set(new Person("zhangsan"));
            for(int i=0;i<5;i++){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(tl.get().name);
            }
        }).start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(tl.get()==null){
                tl.set(new Person("lisi"));
            }else{
                tl.get().name="wangwu";
            }

        }).start();
    }
}
