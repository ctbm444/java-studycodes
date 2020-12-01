package threadlocal;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: threadlocal对比类
 * @author: yanxiaotian
 * @create: 2020-12-01 09:48
 **/
public class ThreadLocalCompare {
    public String var=null;
    public void print(){
        System.out.println(Thread.currentThread().getName()+","+ this.var);
    }

    public static void main(String[] args) {
        List<Thread> list=new ArrayList<>();
        for(int i=0;i<15;i++){
            final String str=i+"";
            list.add(new Thread("thread"+str){
                @Override
                public void run() {
                    ThreadLocalCompare c=new ThreadLocalCompare();
                    c.var=str;
                    c.print();
                }
            });
        }

        list.forEach(t->t.start());
    }
}
